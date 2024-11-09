package com.BigDate1421_Dduo.Exception;

public class MistakeException extends RuntimeException{
    public MistakeException() {
        super("输入错误次数过多");
        System.out.println("输入错误次数过多");
    }

//    public MistakeException(String message) {
//        super(message);
//    }
}
