package com.BigDate1421_Dduo.Start;

import com.BigDate1421_Dduo.Exception.ChooseException;
import com.BigDate1421_Dduo.Exception.MistakeException;
import com.BigDate1421_Dduo.JavaBean.User;
import com.BigDate1421_Dduo.Takeout.TakeoutChoose;
import com.BigDate1421_Dduo.Tools.NowTime;

import java.util.Scanner;
//登录
public class Choose1_Enter {
    public static void enter() {
        Scanner sc=new Scanner(System.in);
        System.out.println("----------♡登录♡----------");
        System.out.println("现在是北京时间"+NowTime.nowTime());
        //输入用户名
        System.out.println("请输入你的用户名");
        String inputUsername= sc.next();
        //判断是否存在此用户
        //将键传递给Map方法
        if(!User.judgeInputUsername(inputUsername)){
            System.out.println("不存在该用户名");
            //进行下一步选择
            System.out.println("请输入下一步选择");
            System.out.println("1.重试");
            System.out.println("2.返回开始菜单");
            switch (sc.nextInt()){
                //重新进入登录界面
                case 1: Choose1_Enter.enter();
                //进入初始界面
                case 2: StartChoose.choose();
            }
            //抛出异常
            throw new ChooseException();
        }
        else {
            //进入用户名与密码的匹配判断
            System.out.println("用户名存在");
            System.out.println("请注意一共有三次机会输入密码");
            System.out.println("如输入次数过多将会抹除数据");
            //通过循环判断输入密码次数
            for(int i=3;i>=0;i--){
                //输入密码
                System.out.println("请输入密码");
                String inputUserPasscode= sc.next();
                if(!User.judgeInputUserPasscode(inputUsername,inputUserPasscode)){
                    //输入密码错误次数过多 锁定账户
                    if(i==1) {
                        System.out.println("对不起您的输入次数过多,账户已经锁定");
                        User.lockUser(inputUsername);
                        throw new MistakeException();
                    }
                    System.out.println("密码输入错误,您还有"+(i-1)+"次机会");
                    //进行下一步操作
                    System.out.println("请输入下一步选择");
                    System.out.println("1.重试密码");
                    System.out.println("2.重输用户名");
                    System.out.println("3.返回开始菜单");
                    switch (sc.nextInt()){
                        case 1 :  continue;
                        case 2 :  Choose1_Enter.enter();
                        case 3 :  StartChoose.choose();
                    }
                }
                else {
                    //验证通过则进入外卖界面
                    System.out.println("密码输入成功");
                    TakeoutChoose.choose();
                }
            }
        }
    }
}
