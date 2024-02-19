package com.example.BlessingChess.service;

import com.example.BlessingChess.data.po.User;
import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    //返回user数据
    public Result userData(Integer id) {
        return Result.success(userMapper.findUserById(id), "success");
    }

}
