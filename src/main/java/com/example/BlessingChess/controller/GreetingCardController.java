package com.example.BlessingChess.controller;

import com.example.BlessingChess.data.dto.GreetingCardReceiver;
import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.service.GreetingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetingCard")
public class GreetingCardController {
    @Autowired
    GreetingCardService greetingCardService;

    @PostMapping("/send")
    public Result insertNewCard(GreetingCardReceiver greetingCardReceiver){
        return greetingCardService.insertNewCard(greetingCardReceiver);
    }


    @GetMapping("/receive/{id}")
    public Result selectByReceiverId(@PathVariable Integer id){
        return greetingCardService.selectByReceiverId(id);
    }

    @GetMapping("{id}")
    public Result selectNewCard(@PathVariable Integer id){
        return greetingCardService.selectNewCard(id);
    }

    @DeleteMapping("{cardId}")
    public Result deleteCard(@PathVariable Integer cardId){
        return greetingCardService.deleteCard(cardId);
    }

    @PutMapping("{cardId}")
    public Result updateCard(@PathVariable Integer cardId,GreetingCardReceiver greetingCardReceiver){
        return greetingCardService.updateCard(cardId,greetingCardReceiver);
    }
}
