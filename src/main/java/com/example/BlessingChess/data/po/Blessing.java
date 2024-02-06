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
@TableName("blessing")
public class Blessing {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String receiverID;
    private String senderID;
    private Date lastTime;
    private String content;
    private String iconName;
    private String invitationCode;
}
