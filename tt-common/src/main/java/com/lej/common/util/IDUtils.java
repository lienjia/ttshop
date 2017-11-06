package com.lej.common.util;

import java.util.Random;

/**
 * User: lienjiaa
 * Date: 2017/10/24
 * Time: 17:38
 * Version:V1.0
 */
public class IDUtils {
    public static long getItemId(){
        long mills = System.currentTimeMillis();
        Random random = new Random();
        //加上两位随机数
        int end2 = random.nextInt(99);
        //如果不足两位，前面补0
        String str = mills + String.format("%02d",end2);
        long id = new Long(str);
        return id;
    }
}
