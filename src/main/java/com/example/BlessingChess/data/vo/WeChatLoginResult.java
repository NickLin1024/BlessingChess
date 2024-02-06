package com.example.BlessingChess.data.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeChatLoginResult {
    private String token = null;
    private String unionId;
    private String errmsg;
    private int errcode;
}