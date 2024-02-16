package com.example.BlessingChess.controller;

import com.example.BlessingChess.data.dto.GreetingCardReceiver;
import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/")
    public Result test(){
        return Result.success(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"hello");
    }

    @PostMapping("/1")
    public Result test1(GreetingCardReceiver greetingCardReceiver){
        return testService.test1(greetingCardReceiver);
    }

    @GetMapping("/2/{id}")
    public Result test2(@PathVariable Integer id){
        return testService.test2(id);
    }


}
