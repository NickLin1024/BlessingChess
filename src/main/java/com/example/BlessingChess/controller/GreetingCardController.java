package com.example.BlessingChess.controller;

import com.example.BlessingChess.service.GreetingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class GreetingCardController {
    @Autowired
    GreetingCardService greetingCardService;
}
