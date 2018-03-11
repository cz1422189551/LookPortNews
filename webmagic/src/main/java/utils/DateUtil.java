package utils;

import java.util.Calendar;
import java.util.TimeZone;

public class DateUtil {

   static  Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));


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
