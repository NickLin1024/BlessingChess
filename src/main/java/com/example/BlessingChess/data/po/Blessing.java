package com.example.BlessingChess.data.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 祝福的持久对象实体类，用于在数据库中存储和管理祝福信息。
 *
 * @author LRQ LXY
 * @version 1.1
 * @since 2024-02-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("blessing")
public class Blessing {
    /**
     * 祝福的唯一标识符，由数据库自动生成。
     *
     * @TableId 注解表示该字段是表的主键，type = IdType.AUTO表示主键是自增的。
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 发送祝福的用户的ID。
     */
    private String senderId;

    /**
     * 接收祝福的用户的ID。
     */
    private String receiverId;

    /**
     * 祝福的发送时间。
     */
    private Date deliveryTime;

    /**
     * 祝福的内容。
     */
    private String content;

    /**
     * 祝福的图标图片URL。
     */
    private String icon;

    /**
     * 祝福的背景图片URL。
     */
    private String background;

    /**
     * 标识该祝福是否已经被查看。
     * true表示已查看，false表示未查看。
     */
    private boolean isViewed;
}