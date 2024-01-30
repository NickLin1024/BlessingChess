package com.example.blessingchess.controller;


import com.example.blessingchess.data.vo.Result;
import com.example.blessingchess.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Test")
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/")
    public Result test(){
        return Result.ok();
    }
}
