package com.siemonsele.d1_static_field;

public class Test1 {
    public static void main(String[] args) {
        //目标：理解static修饰成员变量的用法
        //1.类名.静态变量（推荐的方式）
        Student.name = "袁华";
        System.out.println(Student.name);

        //对象.静态变量（不推荐）
        Student s1 =  new Student();
        s1.name = "马冬梅";
        System.out.println(s1.name);

        //对象.静态变量（不推荐）
        Student s2 =  new Student();
        s2.name = "秋雅";

        System.out.println(s1.name);//秋雅

        //2。对象.实例变量
        //Student.age = 12; //报错
        s1.age = 21;
        s2.age = 23;
        System.out.println(s1.age);//21
    }
}
