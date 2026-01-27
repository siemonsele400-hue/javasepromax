package com.siemonsele.d7_genericity;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //目标：认识泛型
 /*       ArrayList list = new ArrayList();
        list.add("郑州");
        list.add("新郑");
        list.add("zzuit");
        list.add("lxb");
        list.add(true);
        list.add(123.45);

        //1.开发中很多时候需要统一数据类型。（如果不使用泛型，类型没办法统一，就需要进行强制转换！）
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            String s = (String)o; //强制转换
            System.out.println(s); 由于有非字符串格式，所以会报错
        }
*/
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        //ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<>(); //jdk1.7开始后面类型可以不写
        list.add("郑州");
        list.add("新郑");
        list.add("zzuit");

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
    }
}
