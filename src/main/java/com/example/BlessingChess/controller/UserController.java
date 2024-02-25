package com.example.BlessingChess.controller;

import com.example.BlessingChess.data.dto.LoginData;
import com.example.BlessingChess.data.po.User;
import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.service.LoginService;
import com.example.BlessingChess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    LoginService loginService;//调用登录Service

    @Autowired
    UserService userService;

    //登录用接口
    @PostMapping("/login")
    public Result handleLogin(@RequestBody LoginData loginData) {

        //传入登录信息，并返回Token
        return loginService.testGetToken(loginData);
    }

    //查询用户数据接口
    @GetMapping("/data/{id}")
    public Result userData(@PathVariable Integer id) {
        return userService.userData(id);
    }

    //更新棋盘数据
    @PostMapping("/chessboard/{id}")
    public Result updateChessBoard(@PathVariable Integer id, @RequestParam Integer diceNum, Integer position) {
        return userService.updateChessBoard(id, diceNum, position);
    }

}
