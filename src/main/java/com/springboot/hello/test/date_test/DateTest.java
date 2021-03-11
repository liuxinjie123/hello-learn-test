package com.springboot.hello.test.date_test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        String dateStr = "20210308";
        String YYYYMMDD = "yyyyMMdd";

        SimpleDateFormat format = new SimpleDateFormat(YYYYMMDD);
        Date date = null;
        try {
            date = format.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        System.out.println(format.format(date));
    }


    public static Date getCurrDateNoSFM(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }
}
