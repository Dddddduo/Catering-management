package com.BigDate1421_Dduo.Tools;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
//返回系统现在的时间

public class NowTime {
    public static LocalDateTime nowTime() {
        //Instant类是JDK8新增的时间类 名为时间戳
        long timestamp = Instant.now().getEpochSecond();
        //日历类Calendar 根据输入的时区参数返回年月日时秒分
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.of("Asia/Shanghai"));
        //返回值为LocalDateTime类型
        return dateTime;
    }
}
