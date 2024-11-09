package com.BigDate1421_Dduo.Start;

import com.BigDate1421_Dduo.Exception.ChooseException;
import com.BigDate1421_Dduo.Tools.NowTime;

import java.util.Scanner;


//初始界面
public class StartChoose {

    public static void choose() {
        Scanner sc = new Scanner(System.in);

        //把食品添加到这里
        //是因为每次进入外卖界面都会往集合里添加数据,
        //数据会重复,这样只会添加一次

        System.out.println("----------♡欢迎使用多多外卖系统♡----------");
        System.out.println("现在是北京时间" + NowTime.nowTime());
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("3.忘记密码");
        System.out.println("4.制作信息");
        System.out.println("5.退出");
        //这里的警告是因为写了太多的打印输出代码
        System.out.println("请输入您的选择");

        int choose = sc.nextInt();

        //如果选择是1,进入登录界面
        if (choose == 1) Choose1_Enter.enter();

        //如果选择是2,进入注册界面
        else if (choose == 2) Choose2_Register.register();

        //如果选择是3,进入密码重置界面
        else if (choose == 3) Choose3_Forget.forget();

        //如果选择是4,打开制作者信息
        else if (choose == 4) Choose4_Message.message();

        //如果选择是5,终止虚拟机运行，退出程序
        else if (choose == 5) System.exit(0);

        else {
//            System.out.println("没有此选择,请重新输入");
//            StartChoose.choose();
            throw new ChooseException();
        }
    }
}
