package com.BigDate1421_Dduo.Takeout;

import com.BigDate1421_Dduo.JavaBean.Food;
import com.BigDate1421_Dduo.Tools.NowTime;

import java.util.Scanner;

public class Choose4_Seek {
    public static void seek() {
        System.out.println("----------♡查找食品♡----------");
        System.out.println("现在是北京时间"+ NowTime.nowTime());
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个关键字查找数据(名称)");
        String keyword= sc.next();
        if(Food.seek(keyword).isEmpty())
            System.out.println("未找到信息");
        else {
            System.out.println("找到"+Food.seek(keyword).size()+"项数据");
            //用增强for循环遍历集合
            for(Food food:Food.seek(keyword))
                System.out.println(food);
        }
        System.out.println("输入1重新查找");
        System.out.println("输入2返回上一步");
        while(true){
            int judge= sc.nextInt();
            if(judge==1) Choose4_Seek.seek();
            if(judge==2)TakeoutChoose.choose();
            System.out.println("输入错误请重新输入");
        }

    }
}
