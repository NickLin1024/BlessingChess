package com.example.BlessingChess.data.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("card")
public class GreetingCard {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String receiverID;
    private String senderID;
    private Date deliveryTime;
    private String content;
    private String icon;
}
