package com.example.blessingchess.data.vo;

import com.example.blessingchess.data.po.WeChatLogin.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeChatLoginResult<T> {
    private T user;
    private String unionId;
    private String errmsg;
    private int errcode;
}
//从登录接口请求得到的信息
