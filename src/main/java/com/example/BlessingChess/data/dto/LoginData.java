package com.example.BlessingChess.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginData {
    @Getter
    private String code;
    private String wxUsername;
}
//这个是前端发送给后端的登录信息实体类
