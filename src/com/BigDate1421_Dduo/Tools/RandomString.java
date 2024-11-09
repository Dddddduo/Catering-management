package com.BigDate1421_Dduo.Tools;

import java.util.Random;
//获取随机验证码
public class RandomString {

    //把能随机出现的字符填进去
    private static final String Largestring
            = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String gencode() {
        //将长度作为形参传入
        String randomString = generateRandomString(5);
        //返回随机数
        return randomString;
    }

    public static String generateRandomString(int length) {
        //播种
        Random random = new Random();
        //创建字符数组
        char[] text = new char[length];
        //随机截取字符串中的五个字符放入数组中
        for (int i = 0; i < length; i++)
            text[i] = Largestring.charAt(random.nextInt(Largestring.length()));
        //将数组拼成字符串返回
        return new String(text);
    }
}
