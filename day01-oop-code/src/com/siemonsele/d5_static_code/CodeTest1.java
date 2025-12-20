package com.siemonsele.d5_static_code;

import java.util.ArrayList;

public class CodeTest1 {

    public static String schoolName = "郑州工业应用技术学院";
    public static ArrayList<String> names = new ArrayList<>();
    //静态代码块：有static修饰，属于类持有，与类一起优先加载，自动执行一次
    //作用：可以用来初始化静态变量的数据
    static{
        System.out.println("==静态代码块执行了==");
        names.add("张三");
        names.add("李四");
        names.add("王五");
    }
    public static void main(String[] args) {
        //目标：搞清楚静态代码块的特点，了解应用场景
        //作用：可以用来初始化静态变量的数据
        System.out.println("==main方法执行了==");
        System.out.println(names);
    }
}
