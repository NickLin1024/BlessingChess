package com.example.blessingchess.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blessingchess.data.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
