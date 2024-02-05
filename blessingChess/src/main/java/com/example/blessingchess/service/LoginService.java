package com.example.blessingchess.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.blessingchess.data.dto.LoginData;
import com.example.blessingchess.data.po.WeChatLogin.User;
import com.example.blessingchess.data.dto.WeChatLoginModel;
import com.example.blessingchess.data.vo.Result;
import com.example.blessingchess.data.vo.WeChatLoginResult;
import com.example.blessingchess.data.wechat.WeChat;
import com.example.blessingchess.mapper.UserMapper;
import com.example.blessingchess.utils.HttpClientUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.blessingchess.utils.JwtUtils;

@Service
public class LoginService {

    //注入UserMapper
    @Autowired
    UserMapper userMapper;


    //接受前端传入的登录信息并处理
    public Result getToken(LoginData loginData) {

        //封装微信登录模型
        WeChatLoginModel model = new WeChatLoginModel(loginData.getCode(), WeChat.appId,WeChat.secret);

        //传入登录模型，取得登录接口响应的信息
        WeChatLoginResult<User> result = WeChatLogin(model);

        //返回结果，成功则返回Token
        if(result.getUser() == null) {
            return Result.error(0, "登录失败");
        }
        else {
            return Result.success(result.getUser().getToken(), "登录成功");
        }
    }


    //返回登录接口响应数据
    public WeChatLoginResult<User> WeChatLogin(WeChatLoginModel model) {

        //实例化返回模型
        WeChatLoginResult<User> result = new WeChatLoginResult<>();

        try {

            //打包好url并发送请求
            String urlFormat = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
            String url = String.format(urlFormat, WeChat.appId, WeChat.secret, model.getCode());
            String response = HttpClientUtil.doGet(url);

            //将请求响应信息转为json格式
            JSONObject jsonObject = new JSONObject(response);

            //判断请求是否有错
            if (jsonObject.getInt("errcode") == 0) {

                //在数据库中根据openid查找信息
                User user;
                user = userMapper.findUserByOpenId(jsonObject.getString("openid"));

                //如果没有登录过，数据库里面没有数据
                if (user == null || user.getId() == null) {

                    //打包User实体
                    user = new User();
                    user.setSessionKey(jsonObject.getString("session_key"));
                    user.setOpenId(jsonObject.getString("openid"));
                    user.setPassword(jsonObject.getString("openid"));
                    user.setLastTime(new Date());
                    //将用户信息传入token的载荷中
                    user.setToken(JwtUtils.generateJwt(user.toMap()));

                    //在数据库中插入新用户
                    userMapper.insert(user);
                }

                //如果有登录过
                else {

                    //更新最后登录时间
                    user.setLastTime(new Date());
                    userMapper.updateById(user);/*TODO：这里用了BaseMapper的update，但是不知道这样写行不行*/
                }

                //封装返回模型
                result.setUser(user);
                result.setUnionId(jsonObject.getString("unionid"));
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }


/*    //这里用来生成Token,问就是抄的,原理我也不知道
    public String creatToken(User user) {
        String token="";
        token= JWT.create()
                .withKeyId(String.valueOf(user.getId()))
                .withIssuer("www.ikertimes.com")
                .withIssuedAt(new Date())
                .withJWTId("jwt.ikertimes.com")
                .withClaim("session_key", user.getSessionKey())
                .withAudience(String.valueOf(user.getId()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }*/

}