package com.example.BlessingChess.service;

import com.example.BlessingChess.data.dto.GreetingCardReceiver;
import com.example.BlessingChess.data.po.Blessing;
import com.example.BlessingChess.data.po.CardReceiverRelations;
import com.example.BlessingChess.data.po.GreetingCard;
import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.mapper.GreetingCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * 贺卡服务类，提供对贺卡数据的相关操作。
 *
 * @author LXY LRQ
 * @version 1.0
 * @since 2024-02-16
 */
@Service
public class GreetingCardService {
    //注入GreetingCardMapper
    @Autowired
    GreetingCardMapper greetingCardMapper;

    /**
     * 加入新的贺卡。
     *
     * @param greetingCardReceiver 贺卡的dto信息
     * @return 操作结果，如果成功则返回OK状态,错误则返回error
     */
    public Result insertNewCard(GreetingCardReceiver greetingCardReceiver){
        //TODO 加入代码确认发送者id的有效性、图标和背景是否存在
        GreetingCard greetingCard = new GreetingCard(greetingCardReceiver);
        if (greetingCard.getIcon() == null || greetingCard.getSenderId() == null || greetingCard.getBackground() == null) {
            return Result.error(0,"缺少有效的发送者id或图标或背景");
        }
        greetingCardMapper.insertNewCard(greetingCard);
        return Result.ok();
    }

    /**
     * 根据用户ID查询所有该用户收到的贺卡。
     *
     * @param id 用户的ID
     * @return 查询结果，包含贺卡信息的列表,如果错误返回error
     */
    public Result selectByReceiverId(Integer id){
        //TODO 健壮性！！
        if (id == null) {
            return Result.error(0,"id不能为空");
        }
        return Result.success(greetingCardMapper.selectByReceiverId(id),"success");
    }

    /**
     * 根据用户ID获取一个新贺卡
     *
     * @param id 用户的ID
     * @return 查询结果，包含新贺卡的信息
     */
    public Result selectNewCard(Integer id){
        List<GreetingCard> list = greetingCardMapper.selectNewCard(id);
        Random random = new Random();
        Integer length = list.size();
        if (length <= 0) {
            return Result.success(null,"no card");
        }
        GreetingCard r = list.get(random.nextInt(0,length));
        CardReceiverRelations cardReceiverRelations = new CardReceiverRelations();
        cardReceiverRelations.setReceiverId(id);
        cardReceiverRelations.setCardId(r.getId());
        greetingCardMapper.newCardRelation(cardReceiverRelations);
        //TODO selectNewCard方法是所有可选贺卡的集合，要从中随机选一个，然后用mapper中已经写好的方法，把这个新贺卡的获取信息放入中间表
        return Result.success(r ,"success");
    }

    /**
     * 删除对应id的贺卡
     *
     * @param id 需要删除的贺卡id
     * @return 删除的结果，若成功返回ok
     */
    public Result deleteCard(Integer id){
      if (greetingCardMapper.isCard(id) == 0) {
            return Result.error(0,"没有此贺卡,无法删除");
        }
      if (greetingCardMapper.countReceiver(id) != 0) {
          return Result.error(0, "贺卡已被点亮，无法删除~");
      }
      greetingCardMapper.deleteCard(id);
      return Result.ok();
    }

    /**
     * 更新对应id的贺卡
     *
     * @param id 需要修改的贺卡id
     * @param greetingCardReceiver 前端提供的修改信息，若无需修改的变量为null
     * @return 删除的结果，若成功返回ok
     */
    public Result updateCard(Integer id,GreetingCardReceiver greetingCardReceiver){
        //TODO 健壮性！！比如确定该贺卡是否存在
        if (greetingCardMapper.isCard(id) == 0) {
            return Result.error(0,"没有此贺卡,无法更新");
        }
        if (greetingCardMapper.countReceiver(id) != 0) {
            return Result.error(0, "贺卡已被点亮，无法更改~");
        }
        GreetingCard greetingCard = new GreetingCard(greetingCardReceiver);
        greetingCard.setId(id);
        greetingCardMapper.updateCard(greetingCard);
        return Result.ok();
    }

    /**
     * 删除对应id的贺卡
     *
     * @param cardId 需要修改的贺卡id
     *
     * @return 贺卡被点亮的次数，若成功返回ok
     */
    public Result lightCard(Integer cardId) {
        if (greetingCardMapper.isCard(cardId) == 0) {
            return Result.error(0,"没有此贺卡");
        }
        return Result.success(greetingCardMapper.countReceiver(cardId),"success");
    }
    /**
     * 根据用户ID查询所有该用户发收的贺卡。
     *
     * @param id 用户的ID
     * @return 查询结果，包含贺卡信息的列表,如果错误返回error
     */
    public Result selectBySenderId(Integer id){
        //TODO 健壮性！！
        if (id == null) {
            return Result.error(0,"id不能为空");
        }
        return Result.success(greetingCardMapper.selectBySenderId(id),"success");
    }

    /**
     * 根据用户ID查询所有贺卡。
     *
     *
     * @return 查询结果，包含贺卡信息的列表
     */
    public Result selectAllCard(){
        return Result.success(greetingCardMapper.selectAllCard(),"success");
    }

}
