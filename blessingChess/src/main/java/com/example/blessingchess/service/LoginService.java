package com.example.blessingchess.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.blessingchess.data.po.LoginData;
import com.example.blessingchess.data.po.User;
import com.example.blessingchess.data.po.WeChatLoginModel;
import com.example.blessingchess.data.vo.WeChatLoginResult;
import com.example.blessingchess.data.wechat.WeChat;
import com.example.blessingchess.utils.HttpClientUtil;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {

    //接受前端传入的登录信息并处理
    public String getToken(LoginData loginData) {
        WeChatLoginModel model = new WeChatLoginModel(loginData.getCode(), WeChat.appId,WeChat.secret);//封装微信登录模型
        WeChatLoginResult<User> result = WeChatLogin(model);//取得接口响应的信息

    }

    public WeChatLoginResult<User> WeChatLogin(WeChatLoginModel model) {
        String urlFormat = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
        String url = String.format(urlFormat, WeChat.appId, WeChat.secret, model.getCode());
        String response = HttpClientUtil.doGet(url);//打包好url并发送请求

        //这里还要判断数据库里面有没有信息，即有没有注册过。通过code请求接口可以获得openid，openid是不变的，如果数据库已经有了，则更新登录时间信息

        JSONObject jsonObject = new JSONObject(response);//将请求响应信息转为json格式
        User user = new User();                          //打包User实体
        user.setSessionKey(jsonObject.getString("session_key"));
        user.setOpenId(jsonObject.getString("openid"));


        WeChatLoginResult<User> weChatLoginResult = new WeChatLoginResult<>();

        //最后返回打包好的数据
    }


    //这里用来生成Token
    public String creatToken(User user) {
        String token="";
        token= JWT.create()
                .withKeyId(user.getId())
                .withIssuer("www.ikertimes.com")
                .withIssuedAt(new Date())
                .withJWTId("jwt.ikertimes.com")
                .withClaim("session_key", user.getSessionKey())
                .withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

}
