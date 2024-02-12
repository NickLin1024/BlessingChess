package com.example.BlessingChess.data.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 前后端用于传输新增贺卡的实体类
 *
 * @author LXY
 * @version 1.0
 * @since 2024-02-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GreetingCardReceiver {
    private Integer senderId;
    private String content;
    private String iconUrl;
    private String backgroundUrl;
    }
