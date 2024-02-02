package com.example.blessingchess.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blessingchess.data.po.WeChatLogin.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where openid = #{openId}")
    User findUserByOpenId(String openId);

}
