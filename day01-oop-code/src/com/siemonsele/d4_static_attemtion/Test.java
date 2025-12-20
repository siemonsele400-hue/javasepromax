package com.siemonsele.d4_static_attemtion;

public class Test {
    //静态变量
    public static String schoolName = "郑州工业应用技术学院";
    //静态方法
    public static void inAddr(){
        System.out.println("zzuit");
    }

    //实例变量
    private String name;
    //实例方法
    public void printInfo(){
        System.out.println(name);
    }

        //3.实例方法中既可以直接访问类成员，也可以直接访问实例成员
        //2.实例方法中可以出现this关键字，类方法中不可以出现this关键字
    public void testNoStatic(){
        System.out.println(schoolName);
        inAddr();
        System.out.println(this);
        System.out.println(name);
        printInfo();
    }

    //1.静态方法中可以直接访问类的静态成员，不可以直接访问实例成员
    public static void testStatic(){
        System.out.println(schoolName);
        inAddr();
        //System.out.println(this);//报错
        //System.out.println(name);//报错
        //printInfo();//报错
    }
}
