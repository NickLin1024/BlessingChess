package com.example.BlessingChess.data.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 贺卡接收关系的持久对象实体类，用于在数据库中存储和管理祝福信息。
 *
 * @author LRQ LXY
 * @version 1.1
 * @since 2024-02-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("card_receiver_relations")
public class CardReceiverRelations {
    /**
     * 唯一标识符，由数据库自动生成。
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 对应贺卡表中的id
     */
    private Integer cardId;

    /**
     * 对应用户表中的id
     */
    private Integer receiverId;
}
