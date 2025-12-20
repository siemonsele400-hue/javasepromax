package com.siemonsele.d2_static_method;

public class Test {
    public static void main(String[] args) {
        //目标：理解静态方法（推荐）
        Student.printHelloworld();

        //2.对象名.静态方法（不推荐）
        Student s1=new Student();
        s1.printHelloworld();

        //3.对象名.实例方法
        Student s2=new Student();
        s2.score = 60;
        s2.proitPass();

        //Student.printPass();//报错，对象的方法必须用对象触发访问
    }
}
