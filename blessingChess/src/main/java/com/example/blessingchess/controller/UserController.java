package com.example.blessingchess.controller;

import com.example.blessingchess.data.dto.LoginData;
import com.example.blessingchess.data.vo.Result;
import com.example.blessingchess.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    LoginService loginService;//调用登录Service

    //登录用接口
    @PostMapping("/login")
    public Result handleLogin(@RequestBody LoginData loginData) {

        //传入登录信息，并返回Token
        return loginService.getToken(loginData);
    }

}
