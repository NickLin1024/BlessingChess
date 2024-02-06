package com.example.BlessingChess.utils;

import java.util.Random;

/**
 * 用于测试的随机字符串生成类
 *
 * @author LXY
 * @version 1.0
 * @since 2024-02-6
 */
public class RandomStringGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * 随机字符串生成器
     *
     * @param LENGTH 生成的随机字符串的长度
     * @return 返回一个由大写字母、小写字母和数字组成的随机字符串
     */
    public static String generateRandomString(int LENGTH) {

        Random random = new Random();
        StringBuilder sb = new StringBuilder(LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
