package com.example.BlessingChess.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

//用于生成随机的邀请码
@Service
public class RandomUtil {

    @Autowired
    UserUtils userUtils;

    public String RandomInvitationCode() {
        Random random = new Random();
        int result;

        do {
            result = random.nextInt(900000000) + 100000000;
        }while (userUtils.hasInvitationCode(String.valueOf(result)));

        return String.valueOf(result);
    }
}
