package com.BigDate1421_Dduo.Takeout;

import com.BigDate1421_Dduo.JavaBean.Food;
import com.BigDate1421_Dduo.Tools.NowTime;
import com.BigDate1421_Dduo.Tools.RandomString;

import java.util.Scanner;

public class Choose3_Delete {
    public static void delete() {
        System.out.println("----------♡删除食品♡----------");
        System.out.println("现在是北京时间"+ NowTime.nowTime());
        Scanner sc = new Scanner(System.in);
        //先判断集合内是否存在
        System.out.println("请输入要删除食品的名称");
        String input = sc.next();
        if (!Food.check(input)) {
            System.out.println("未找到与该食品");
            TakeoutChoose.choose();
        }
        else {
            System.out.println("已找到该食品");
            System.out.println(Food.seek(input));
            System.out.println("请输入验证码以删除");
            //生成随机的长度为5的字符串
            //通过死循环来进行更新验证码
            while (true) {
                String Vercode = RandomString.gencode();
                System.out.println("验证码: " + Vercode);
                System.out.println("如果想更新验证码请输入again,进入下一步则输入其他");
                if (sc.next().equals("again") ) ;
                else {
                    System.out.println("请注意你只有一次输入机会,如输入正确则删除");
                    if (sc.next().equals(Vercode)) {
                        System.out.println("输入正确,已删除");
                        Food.delete(input);
                        System.out.println("输入1返回外卖界面");
                        while(true){
                            if(sc.nextInt()==1)TakeoutChoose.choose();
                            System.out.println("未输入1,请重新输入");
                        }
                    }
                    else {
                        System.out.println("输入错误!");
                        TakeoutChoose.choose();
                    }
                }
            }
        }
    }
}
