package com.example.BlessingChess.mapper;

import com.example.BlessingChess.data.po.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from user where openid = #{openId}")
    User findUserByOpenId(String openId);

    //会自动将生成的id值，赋值给user对象的id属性
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(session_key,open_id,last_time,username) values (#{sessionKey}, #{openId}, #{lastTime}, #{username})")
    public void insert(User user);

    @Update("update user set last_time=#{lastTime} where id=#{id}")
    public void updateById(User user);

}