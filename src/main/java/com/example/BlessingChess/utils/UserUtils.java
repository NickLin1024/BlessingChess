package com.example.BlessingChess.utils;

import com.example.BlessingChess.data.po.User;
import com.example.BlessingChess.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUtils {

    @Autowired
    UserMapper userMapper;

    public boolean hasUser(User user) {
        if (user == null || user.getId() == null) return false;
        else return true;
    }

    public boolean hasInvitationCode (String invitationCode) {
        User user = userMapper.findUserByInvitationCode(invitationCode);
        if(user == null) return false;
        else return true;
    }
}
