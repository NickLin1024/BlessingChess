package com.example.BlessingChess.data.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String sessionKey;
    private String openId;
    private Date lastTime;
    private String username;

    /**
     * 将用户信息转换成Map包装进token
     * @return 用户信息的Map
     */
    public Map<String, Object> toMap() {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", getId());
        userMap.put("sessionKey", getSessionKey());
        userMap.put("openId", getOpenId());
        userMap.put("lastTime", getLastTime());
        userMap.put("username", getUsername());
        return userMap;
    }
}