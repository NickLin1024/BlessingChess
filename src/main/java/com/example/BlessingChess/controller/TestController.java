package com.example.BlessingChess.controller;

import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/")
    public Result test(){
        return Result.success(new Date(),"hello");
    }
}
