package com.example.BlessingChess.service;

import com.example.BlessingChess.data.dto.GreetingCardReceiver;
import com.example.BlessingChess.data.po.GreetingCard;
import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.mapper.GreetingCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingCardService {
    //注入GreetingCardMapper
    @Autowired
    GreetingCardMapper greetingCardMapper;

    public Result insertNewCard(GreetingCardReceiver greetingCardReceiver){
        GreetingCard greetingCard = new GreetingCard(greetingCardReceiver);
        greetingCardMapper.insertNewCard(greetingCard);
        return Result.ok();
    }

    public Result selectByReceiverId(Integer id){
        return Result.success(greetingCardMapper.selectByReceiverId(id),"success");
    }

    public Result selectNewCard(Integer id){
        return Result.success(greetingCardMapper.selectNewCard(id),"success");
    }

    public Result deleteCard(Integer cardId){
        greetingCardMapper.deleteCard(cardId);
        return Result.ok();
    }

    public Result updateCard(Integer id,GreetingCardReceiver greetingCardReceiver){
        GreetingCard greetingCard = new GreetingCard(greetingCardReceiver);
        greetingCard.setId(id);
        greetingCardMapper.updateCard(greetingCard);
        return Result.ok();
    }
}
