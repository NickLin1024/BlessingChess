package com.example.BlessingChess.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.BlessingChess.data.po.CardReceiverRelations;
import com.example.BlessingChess.data.po.GreetingCard;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


/**
 * GreetingCardMapper 接口定义了与 GreetingCard 实体相关的数据库映射操作。
 *
 * @author LXY
 * @since 2024-2-16
 */
@Mapper
public interface GreetingCardMapper extends BaseMapper<GreetingCard> {

    /**
     * 根据发送者 ID 查询 GreetingCard 列表。
     *
     * @param id 发送者的 ID
     * @return GreetingCard 列表，包含所有由指定发送者发送的卡片
     */
    public List<GreetingCard> selectBySenderId(Integer id);

    /**
     * 根据接收者 ID 查询 GreetingCard 列表。
     *
     * @param id 接收者的 ID
     * @return GreetingCard 列表，包含所有发送给指定接收者的卡片
     */
    public List<GreetingCard> selectByReceiverId(Integer id);

    /**
     * 计算指定 GreetingCard 的接收者数量。
     *
     * @param cardId 需要查询的贺卡 的 ID
     * @return 该贺卡的接收者数量
     */
    public Integer countReceiver(Integer cardId);

    /**
     * 查询用户还没收到过的 GreetingCard 列表。
     *
     * @param id 用户的id
     * @return GreetingCard 列表，包含用户还没收到过的 GreetingCard
     */
    public List<GreetingCard> selectNewCard(Integer id);

    /**
     * 插入新贺卡
     *
     * @param greetingCard 需要插入的贺卡对象
     */
    public void insertNewCard(GreetingCard greetingCard);

    /**
     * 根据cardId更新贺卡类中的非空元素
     *
     * @param greetingCard 需要更新的贺卡对象，必须包含id值
     */
    public void updateCard(GreetingCard greetingCard);

    /**
     * 根据cardId删除贺卡
     *
     * @param id 需要删除的贺卡的id
     */
    public void deleteCard(Integer id);
    /**
     * 根据cardId确认贺卡是否存在
     *
     * @param id 需要查询的贺卡的id
     */
    public Integer isCard(Integer id);

    public void newCardRelation(CardReceiverRelations cardReceiverRelations);
}

