package com.BigDate1421_Dduo.JavaBean;

import com.BigDate1421_Dduo.Interface.GetFoodSpace;
import com.BigDate1421_Dduo.Interface.GetName;
import com.BigDate1421_Dduo.Interface.GetScore;
import com.BigDate1421_Dduo.Interface.ToString;
import com.BigDate1421_Dduo.Takeout.Choose5_Order;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//这个JavaBean类是食品
public class Food extends Item implements GetName, GetScore,GetFoodSpace,ToString{

    private String name;//名称
    private int price;  //价格
    private String score;//评分
    private String foodSpace;//产地

    /*------------------------------------------------------*/
    public Food() {
    }

    public Food(String name, int price, String score, String foodSpace) {

        this.name = name;
        this.price = price;
        this.score = score;
        this.foodSpace = foodSpace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getFoodSpace() {
        return foodSpace;
    }

    public void setFoodSpace(String foodSpace) {
        this.foodSpace = foodSpace;
    }

    public String toString() {
        return "Food{name = " + name + ", price = " + price + ", score = " + score + ", foodSpace = " + foodSpace + "}";
    }

    /*------------------------------------------------------*/
    public static ArrayList<Food>foods=new ArrayList<>();
    //创建单列集合存储食品信息

    public static void addExampleFood(){
        //添加食品样例
        foods.add(new Food("炸鸡腿",10,"100","肯豆基"));
        foods.add(new Food("汉堡",15,"90","华来市"));
        foods.add(new Food("可乐",3,"85","北华超市"));
        foods.add(new Food("雪碧",4,"85","北华超市"));
    }


    public static void traversal(){
        //用迭代器,Lambda表达式遍历单列集合
        Iterator<Food> iterator = foods.iterator();
        iterator.forEachRemaining(element -> {
            System.out.println(element);
        });
    }

    public static List<Food> seek(String keyword){
        //用stream流和终结方法collect过滤元素
        List<Food>list=
                    foods
                        .stream()
                        .filter(s -> s.name.contains(keyword))
                        .collect(Collectors.toList());
        //System.out.println(list);这里一开始出现了问题所以遍历了一下
        return list;
    }

    public static boolean check(String input){
        //检查是否存在元素
        //Lambda表达式会忽略结果,所以我选择用迭代器遍历
        Iterator<Food> iterator = foods.iterator();
        while (iterator.hasNext())
            if (iterator.next().name.equals(input))
                return true;
        return false;
    }

    public static void add(Food food){
        //添加元素
        foods.add(food);
        //添加到点餐集合里去
        Choose5_Order.add(food.name,food.price);
    }
    public static void delete(String food){
        //用迭代器遍历删除下一个元素
        Iterator<Food> iterator = foods.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next().name;
            if (item.equals(food)) {
                iterator.remove(); // 删除元素
            }
        }
        //删除点餐集合里的数据
        Choose5_Order.delete(food);
    }

}
