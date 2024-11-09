package com.BigDate1421_Dduo.Start;

import com.BigDate1421_Dduo.JavaBean.User;
import com.BigDate1421_Dduo.Tools.NowTime;

import java.util.Scanner;

public class Choose3_Forget {
    public static void forget() {
        System.out.println("----------♡忘记密码♡----------");
        System.out.println("现在是北京时间"+NowTime.nowTime());
        Scanner sc=new Scanner(System.in);
        //首先输入用户名判断其是否存在哈希表内
        System.out.println("请输入用户名");
        //与登录方法一致
        String inputUsername= sc.next();
        //判断是否存在此用户
        //将键传递给Map方法
        if(!User.judgeInputUsername(inputUsername)) {
            System.out.println("不存在该用户名");
            //返回开始界面
            StartChoose.choose();
        }
        else {
            //通过另一个哈希表,键是用户名,值是验证码验证
            System.out.println("存在该用户");
            System.out.println("请输入用户"+inputUsername+"的验证码");
            if(User.judgeVercode(inputUsername, sc.next())){
                System.out.println("验证码正确");
                System.out.println("用户名"+inputUsername+"的密码是:"+User.getPassage(inputUsername));
            }
            else System.out.println("输入错误");
            //返回开始界面
            StartChoose.choose();
        }
    }
}
