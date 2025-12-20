package com.siemonsele.d3_static_util;

import java.util.Random;

//工具类：都是静态方法
public class itUtil {
    public static String creatCode(int n){
        String code = "";  //记住验证码
        String date = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";

        //1.直接使用循环控制随机获取多少为的字符，让后拼接返回即可
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            //2.随机产生一个索引
            int number = random.nextInt(date.length());
            //3.提供对应索引处的字符
            char ch = date.charAt(number);
            code += ch;
        }
        return code;
    }
}
