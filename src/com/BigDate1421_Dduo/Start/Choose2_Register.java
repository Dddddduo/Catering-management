package com.BigDate1421_Dduo.Start;

import com.BigDate1421_Dduo.JavaBean.User;
import com.BigDate1421_Dduo.Tools.NowTime;
import com.BigDate1421_Dduo.Tools.RandomString;

import java.util.Scanner;

//注册
public class Choose2_Register {
    public static void register() {
        Scanner sc=new Scanner(System.in);
        System.out.println("----------♡注册♡----------");
        System.out.println("现在是北京时间"+NowTime.nowTime());
        System.out.println("请输入用户名");
        System.out.println("用户名必须是数字字母大小写混合,不包含字符空格,不小于2位,不大于6位");
        String newUsername= sc.next();
        //生成用户名的正则表达式
        String usernamePattern = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{2,6}$";
        //用正则表达式判断
        if(!newUsername.matches(usernamePattern)){
            //不符合规范
            System.out.println("用户名不符合规范");
            System.out.println("1.请重新输入");
            System.out.println("2.返回开始界面");
            switch (sc.nextInt()){
                case 1:Choose2_Register.register();
                case 2:StartChoose.choose();
            }
        }
        else {
            //用户名规范判断通过 即用户名和密码都符合规范
            System.out.println("用户名符合规范");
            System.out.println("请输入密码");
            System.out.println("密码必须是数字,不包含字母字符空格,不小于3位,不大于5位");
            String newPasscoder= sc.next();
            //生成密码的正则表达式
            String userPasscoderPattern = "^\\d{3,5}$";
            //用正则表达式判断
            if(!newPasscoder.matches(userPasscoderPattern)){
                System.out.println("密码不符合规范");
                System.out.println("1.重新输入账号");
                System.out.println("2.返回开始界面");
                switch (sc.nextInt()){
                    case 1:Choose2_Register.register();
                    case 2:StartChoose.choose();
                }
            }
            else {
                //进入验证码
                System.out.println("用户名和密码都符合规范");
                //生成随机的长度为5的字符串
                //通过死循环来进行更新验证码
                while (true) {
                    String Vercode = RandomString.gencode();
                    System.out.println("请输入验证码");
                    System.out.println("验证码: " + Vercode);
                    System.out.println("如果想更新验证码请输入again,进入下一步则输入其他");
                    if (sc.next().equals("again") ) ;
                    else {
                        System.out.println("请注意你只有一次输入机会,如输入正确则注册");
                        if (sc.next().equals(Vercode)) {
                            System.out.println("输入正确,已注册");
                            System.out.println("刚刚输入的验证码可以在忘记密码时使用");
                            //添加新账号
                            User.add(newUsername, newPasscoder);
                            //添加验证码
                            User.verCode(newUsername, Vercode);
                            System.out.println("您的账号是" + newUsername);
                            System.out.println("您的密码是" + newPasscoder);
                            System.out.println("您的验证码是" + Vercode);
                            //返回开始界面
                            StartChoose.choose();
                        } else {
                            System.out.println("输入错误");
                            //返回开始界面
                            StartChoose.choose();
                        }
                    }
                }
            }
        }
    }
}
