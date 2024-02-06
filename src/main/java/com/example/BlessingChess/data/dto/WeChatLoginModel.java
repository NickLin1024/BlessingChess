package com.example.BlessingChess.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeChatLoginModel {
    private String code;
    private String appId;
    private String secret;
    private String wxUsername;
}
//用LoginData中的code还有微信小程序标识的AppID和AppSecret去请求openID和session_key，这个是登录模型