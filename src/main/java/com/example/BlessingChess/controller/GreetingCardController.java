package com.example.BlessingChess.controller;

import com.example.BlessingChess.data.dto.GreetingCardReceiver;
import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.service.GreetingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 贺卡控制器，用于处理与贺卡相关的HTTP请求。
 */
@RestController
@RequestMapping("/greetingCard")
public class GreetingCardController {
    @Autowired
    GreetingCardService greetingCardService;

    /**
     * 加入新的贺卡。
     *
     * @param greetingCardReceiver 贺卡的dto信息
     * @return 操作结果，如果成功则返回OK状态
     */
    @PostMapping("/send")
    public Result insertNewCard(GreetingCardReceiver greetingCardReceiver){
        return greetingCardService.insertNewCard(greetingCardReceiver);
    }

    /**
     * 根据用户ID查询所有该用户收到的贺卡。
     *
     * @param id 用户的ID
     * @return 查询结果，包含贺卡信息的列表
     */
    @GetMapping("/receive/{id}")
    public Result selectByReceiverId(@PathVariable Integer id){
        return greetingCardService.selectByReceiverId(id);
    }


    /**
     * 根据用户ID获取一个新贺卡
     *
     * @param id 用户的ID
     * @return 查询结果，包含新贺卡的信息
     */
    @GetMapping("/{id}")
    public Result selectNewCard(@PathVariable Integer id){
        return greetingCardService.selectNewCard(id);
    }

    /**
     * 删除对应id的贺卡
     *
     * @param cardId 需要删除的贺卡id
     * @return 删除的结果，若成功返回ok
     */
    @DeleteMapping("/{cardId}")
    public Result deleteCard(@PathVariable Integer cardId){
        return greetingCardService.deleteCard(cardId);
    }


    /**
     * 删除对应id的贺卡
     *
     * @param cardId 需要修改的贺卡id
     * @param greetingCardReceiver 前端提供的修改信息，若无需修改的变量为null
     * @return 删除的结果，若成功返回ok
     */
    @PutMapping("/{cardId}")
    public Result updateCard(@PathVariable Integer cardId,GreetingCardReceiver greetingCardReceiver){
        return greetingCardService.updateCard(cardId,greetingCardReceiver);
    }
}
