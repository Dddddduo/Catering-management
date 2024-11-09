package com.BigDate1421_Dduo.Takeout;

import com.BigDate1421_Dduo.Exception.ChooseException;
import com.BigDate1421_Dduo.Tools.NowTime;

import java.util.Scanner;

//查看食品界面
public class TakeoutChoose {

    public static void choose() {
        Scanner sc=new Scanner(System.in);
        System.out.println("----------♡欢迎使用食品管理系统♡----------");
        System.out.println("现在是北京时间"+ NowTime.nowTime());
        System.out.println("1.查看目前所有食品信息");
        System.out.println("2.添加食品信息");
        System.out.println("3.删除食品信息");
        System.out.println("4.查找食品信息");
        System.out.println("5.模拟外卖点单");
        System.out.println("6.退出系统");
        System.out.println("请输入您的选择");

        int choose= sc.nextInt();

        //如果选择是1,查看所有信息
        if(choose==1) Choose1_View.view();

        //如果选择是2,增
        else if (choose == 2) Choose2_Add.add();

        //如果选择是3,删
        else if (choose == 3) Choose3_Delete.delete();

        //如果选择是4,查
        else if (choose == 4) Choose4_Seek.seek();

        //如果选择是5,模拟外卖点单
        else if (choose == 5) Choose5_Order.order();

        //如果选择是6,终止虚拟机运行,退出程序
        else if (choose == 6) System.exit(0);

        else {
//            System.out.println("没有此选择,请重新输入");
//            TakeoutChoose.choose();
            throw new ChooseException();
        }

    }
}
