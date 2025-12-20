package com.siemonsele.d5_static_code;

import java.util.ArrayList;

public class CodeTest2 {
    private String name;
    private ArrayList<String> names = new ArrayList<>();
    //实例代码块：属于类的每个对象的，每次创建时都会执行一次，而且是在构造器之前执行的
    //作用：完成实例变量的初始化
     {
         System.out.println("==实例代码块执行了==");
         name = "张三";
         names.add("张三");
         names.add("李四");
         names.add("王五");
     }

     public CodeTest2(){
         System.out.println("==构造器执行了==");
     }
     public static void main(String[] args) {
         //目标：搞清楚代码块的作用，应用场景
         System.out.println("==main方法执行了==");
         new CodeTest2();
         new CodeTest2();
         new CodeTest2();
     }
}
