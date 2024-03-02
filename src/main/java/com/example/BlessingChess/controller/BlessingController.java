package com.example.BlessingChess.controller;

import com.example.BlessingChess.data.dto.BlessingReceiver;
import com.example.BlessingChess.data.dto.GreetingCardReceiver;
import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.service.BlessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blessing")
public class BlessingController {
    @Autowired
    BlessingService blessingService;

    /**
     * 发送新的祝福。
     *
     * @param blessingReceiver 贺卡的dto信息
     * @return 操作结果，如果成功则返回OK状态
     */
    @PostMapping("/send")
    public Result insertNewBlessing(@RequestBody BlessingReceiver blessingReceiver){
        return blessingService.insertNewBlessing(blessingReceiver);
    }

    /**
     * 根据用户ID查询所有该用户收到的祝福。
     *
     * @param id 用户的ID
     * @return 查询结果，包含祝福信息的列表
     */
    @GetMapping("/receive/{id}")
    public Result selectByReceiverId(@PathVariable Integer id){
        return blessingService.selectByReceiverId(id);
    }

    /**
     * 根据用户ID查询所有该用户收到的祝福。
     *
     * @param id 用户的ID
     * @return 查询结果，包含祝福信息的列表
     */
    @GetMapping("/send/{id}")
    public Result selectBySenderId(@PathVariable Integer id){
        return blessingService.selectBySenderId(id);
    }

    /**
     * 删除对应id的祝福
     *
     * @param blessingId 需要删除的祝福id
     * @return 删除的结果，若成功返回ok
     */
    @DeleteMapping("/{blessingId}")
    public Result deleteBlessing(@PathVariable Integer blessingId){
        return blessingService.deleteBlessing(blessingId);
    }

    /**
     * 更新对应id的祝福
     *
     * @param blessingId 需要修改的贺卡id
     * @param blessingReceiver 前端提供的修改信息，若无需修改的变量为null
     * @return 删除的结果，若成功返回ok
     */
    @PutMapping("/{blessingId}")
    public Result updateCard(@PathVariable Integer blessingId, @RequestBody BlessingReceiver blessingReceiver){
        return blessingService.updateBlessing(blessingId,blessingReceiver);
    }
    /**
     * 根据用户ID查询一个该用户将要收到的祝福。
     *
     * @param id 用户的ID
     * @return 查询结果，包含祝福信息的列表
     */
    @GetMapping("/{id}")
    public Result selectNewByReceiverId(@PathVariable Integer id){
        return blessingService.selectNewByReceiverId(id);
    }
}
