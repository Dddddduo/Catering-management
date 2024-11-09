package com.BigDate1421_Dduo.Takeout;


import com.BigDate1421_Dduo.JavaBean.Food;
import com.BigDate1421_Dduo.Tools.NowTime;

import java.util.Scanner;

public class Choose2_Add {
    public static void add() {
        Scanner sc=new Scanner(System.in);
        System.out.println("----------♡添加食品♡----------");
        System.out.println("现在是北京时间"+ NowTime.nowTime());
        System.out.println("请输入要添加食品的名称");
        String input= sc.next();
        if(Food.check(input)){
            System.out.println("商品重复");
            TakeoutChoose.choose();
        }
        else{
            System.out.println("没有重复名称的食品,请继续输入");
            Food food=new Food();
            //先把名称填好
            food.setName(input);
            //接着录入三项数据
            System.out.println("请输入食品价格");
            food.setPrice(sc.nextInt());
            System.out.println("请输入食品评分");
            food.setScore(sc.next());
            System.out.println("请输入食品产地");
            food.setFoodSpace(sc.next());
            //添加到食品集合里
            Food.add(food);
            System.out.println("添加食品集合成功");
            //返回食品界面
            System.out.println("输入1返回外卖界面");
            while(true){
                if(sc.nextInt()==1)TakeoutChoose.choose();
                System.out.println("未输入1,请重新输入");
            }
        }
    }
}
