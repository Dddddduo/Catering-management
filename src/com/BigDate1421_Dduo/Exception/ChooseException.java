package com.BigDate1421_Dduo.Exception;

public class ChooseException extends RuntimeException{
    //选项异常

    public ChooseException() {
        super("输入的选项异常");
        System.out.println("输入的选项异常");
    }

//    public ChooseException(String message) {
//        super(message);
//    }

}
