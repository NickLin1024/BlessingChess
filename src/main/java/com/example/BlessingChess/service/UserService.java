package com.example.BlessingChess.service;

import com.example.BlessingChess.data.po.User;
import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    //返回user数据
    public Result userData(Integer id) {
        return Result.success(userMapper.findUserById(id), "success");
    }

    //更新棋盘数据
    public Result updateChessBoard(Integer id, int diceNum, int position) {

        //取出user
        User user = userMapper.findUserById(id);

        //更新数据
        user.setDiceNum(diceNum);
        user.setPosition(position);

        //更新数据库
        userMapper.updateById(user);

        return Result.ok();
    }

}
