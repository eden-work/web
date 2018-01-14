package com.wrox.utils;

public class TimeUtils {

    public static String intervalToString(long timeInterval)
    {
        if(timeInterval < 1_000)
            return "小于 1 秒";
        if(timeInterval < 60_000)
            return (timeInterval / 1_000) + " 秒";
        return "大约 " + (timeInterval / 60_000) + " 分钟";
    }

}
