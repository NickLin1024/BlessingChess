package com.example.BlessingChess.data.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户实体类，映射到数据库中的"user"表。
 *
 * @author LXY LJY
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {

    /**
     * 用户的唯一标识符，由数据库自动生成。
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 微信登录会话密钥。
     * 用于在服务器端验证用户身份，并在微信登录过程中进行安全验证。
     */
    private String sessionKey;

    /**
     * 微信用户的唯一标识符。
     * 用于标识微信用户，通常与微信用户的其他信息一起使用。
     */
    private String openId;

    /**
     * 用户最后一次登录的时间。
     */
    private LocalDateTime lastTime;

    /**
     * 用户的用户名。
     * 用于标识和展示用户的身份。
     */
    private String username;

    /**
     * 用户的邀请码。
     * 用于用户邀请朋友注册时的识别码，可以关联到推荐人。
     */
    private String invitationCode;

    /**
     * 将用户信息转换成Map包装进token
     * @return 用户信息的Map
     */
    public Map<String, Object> toMap() {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", getId());
        userMap.put("openId", getOpenId());
        userMap.put("lastTime", getLastTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));  //转为前端能解析的格式
        userMap.put("username", getUsername());
        userMap.put("invitationCode",invitationCode);
        return userMap;
    }
}
