package com.example.blessingchess.data.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {
    private String id;
    private String sessionKey;
    private String openId;
    private String password;
}
//要存入数据库的用户信息