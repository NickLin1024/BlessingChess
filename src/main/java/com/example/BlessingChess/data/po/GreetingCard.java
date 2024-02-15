package com.example.BlessingChess.data.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 贺卡的持久对象实体类，用于在数据库中存储和管理祝福信息。
 *
 * @author LRQ LXY
 * @version 1.1
 * @since 2024-02-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("card")
public class GreetingCard {
    /**
     * 贺卡的唯一标识符，由数据库自动生成。
     *
     * @TableId 注解表示该字段是表的主键，type = IdType.AUTO表示主键是自增的。
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 发送贺卡的用户的ID。
     */
    private Integer senderId;

    /**
     * 贺卡的发送时间。
     */
    private LocalDateTime deliveryTime;

    /**
     * 贺卡的内容。
     */
    private String content;

    /**
     * 贺卡的图标图片URL。
     */
    private String icon;

    /**
     * 贺卡的背景图片URL。
     */
    private String background;
}
