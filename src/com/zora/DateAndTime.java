package com.zora;

import java.util.Date;

public class DateAndTime {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(String.format(date.toString(),"yy-MM-dd"));
    }
}
