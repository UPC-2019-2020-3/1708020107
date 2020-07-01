package com.zht.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    //日期转换
    public static String date2String(Date date, String patt)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }
    //字符转换
    public static Date string2Date(String str,String patt) throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }
}
