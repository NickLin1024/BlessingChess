package com.example.blessingchess.controller;

import com.example.blessingchess.data.po.LoginData;
import com.example.blessingchess.data.vo.Result;
import com.example.blessingchess.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    LoginService loginService;//调用登录Service

    //登录用接口，目前预想的是直接返回Token
    @PostMapping("/login")
    public Result handleLogin(@RequestBody LoginData loginData) {
        return Result.success(loginService.getToken(loginData));//把前端发送的登录信息传进去
    }

}
