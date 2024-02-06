package com.example.BlessingChess.service;

import com.example.BlessingChess.mapper.GreetingCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingCardService {
    //注入GreetingCardMapper
    @Autowired
    GreetingCardMapper greetingCardMapper;
}
