package com.BigDate1421_Dduo.JavaBean;

import com.BigDate1421_Dduo.Exception.NameformatException;
import com.BigDate1421_Dduo.Start.StartChoose;

import java.util.HashMap;

//这个JavaBean类是用户
public class User extends Item{
    //键,值都为字符串类型

    //用户名和密码
    public static HashMap<String ,String>user=new HashMap<>();
    //双列集合存储用户名和密码
    //键,值都为字符串类型

    public static HashMap<String ,String>retrieve=new HashMap<>();
    //双列集合存储用户名和验证码
    //键,值都为字符串类型
    public static void addExample() {

        //添加用户样例
        user.put("User","123");
        retrieve.put("User","Duo");
    }

    public static boolean judgeInputUsername(String inputUsername) {

        //判断账户内是否存在
        return user.containsKey(inputUsername);
    }

    public static boolean judgeInputUserPasscode(String inputUsername, String inputUserPasscode) {

        //判断用户和密码是否对应
        //字符串直接比较的是地址值,调用equals方法比较具体值
        //这里第一次写的时候就犯了这个错误，写成了"=="
        return (inputUserPasscode.equals(user.get(inputUsername)));
    }

    public static void lockUser(String inputUsername){

        //锁定账户
        user.remove(inputUsername);
        //这里实际上是移除哈希表内的键值对
        StartChoose.choose();
        //返回开始界面
    }

    public static void  add(String newUsername,String inputUserPasscode){

        //异常处理
        if(newUsername.length()>=5||inputUserPasscode.length()>=10)
            throw new NameformatException();

        //添加用户名和密码
        user.put(newUsername,inputUserPasscode);
        //直接往哈希表里添加键值对
    }

    public static void verCode(String newUsername,String code){

        //添加用户的验证码
        //每一个用户都有一个验证码,一个长度为5的字符串
        retrieve.put(newUsername,code);
    }

    public static boolean judgeVercode(String Username,String Usercode){

        //判断验证码是否符合
        if(Usercode.equals(retrieve.get(Username)))
            return true;
        else return false;
    }

    public static String getPassage(String Username){

        //异常处理
        if(Username.length()>=5)
            throw new NameformatException();

        //通过用户名返回密码
        return user.get(Username);
    }

}
