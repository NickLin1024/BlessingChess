package com.example.BlessingChess.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.BlessingChess.data.po.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    //根据openid查找用户
    @Select("select * from user where open_id = #{openId}")
    User findUserByOpenId(String openId);

    @Select("select * from user where invitation_code = #{invitationCode}")
    User findUserByInvitationCode(String invitationCode);

    //会自动将生成的id值，赋值给user对象的id属性
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(session_key,open_id,last_time,username,invitation_code) values (#{sessionKey}, #{openId}, #{lastTime}, #{username},#{invitationCode})")
    public void insertNewUser(User user);

    @Update("update user set last_time=#{lastTime} where id=#{id}")
    public void updateTimeById(User user);

}