package com.cz.lookportnews.webmagic.utils;

import java.util.Calendar;
import java.util.TimeZone;

public class DateUtil {

   static  Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));



    public static String checkTwoDomain(String url) {
        int twoDomain = url.lastIndexOf(".") + 5;
        if (url.length() < (twoDomain + 1)) {
            //没有二级域名，返回一级域名 如：http://sports.163.com/ ,返回sports
            int len = url.indexOf(".");
            return url.substring(7, len);
        } else {
            //返回二级域名 如：http://sports.163.com/nba ,返回nba
            return url.substring(twoDomain);
        }

    }

    public static String getMonth() {
        return String.format("%02d",(calendar.get(Calendar.MONTH)+1));
    }
    public static String getDay() {
        return String.format("%02d",(calendar.get(Calendar.DAY_OF_MONTH)));
    }

    public static String getMonthDay(){
        return getMonth() + getDay();
    }

}
