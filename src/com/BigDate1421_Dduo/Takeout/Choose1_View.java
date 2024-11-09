package com.BigDate1421_Dduo.Takeout;

import com.BigDate1421_Dduo.JavaBean.Food;
import com.BigDate1421_Dduo.Tools.NowTime;

import java.util.Scanner;

public class Choose1_View {
    //展示所有食品信息
    public static void view(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------♡查看所有食品♡----------");
        System.out.println("现在是北京时间"+ NowTime.nowTime());
        System.out.println("下面是食品所有信息");
        System.out.println("—————————————--------------------------------------------——————");
        //遍历集合
        Food.traversal();
        System.out.println("——————————————-------------------------------------—------—————");

        System.out.println("输入1返回外卖界面");
        while(true){
            if(sc.nextInt()==1)TakeoutChoose.choose();
            System.out.println("未输入1,请重新输入");
        }
    }
}
