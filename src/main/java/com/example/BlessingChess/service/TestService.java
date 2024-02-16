package com.example.BlessingChess.service;

import com.example.BlessingChess.data.dto.GreetingCardReceiver;
import com.example.BlessingChess.data.po.GreetingCard;
import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.mapper.GreetingCardMapper;
import com.example.BlessingChess.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    TestMapper testMapper;
    @Autowired
    GreetingCardMapper greetingCardMapper;
    public Result test1(GreetingCardReceiver greetingCardReceiver){
        GreetingCard greetingCard = new GreetingCard(greetingCardReceiver);
        greetingCardMapper.insertNewCard(greetingCard);
        return Result.ok();
    }

    public Result test2(Integer id){
        return Result.success(greetingCardMapper.selectNewCard(id),"success");
    }
}
