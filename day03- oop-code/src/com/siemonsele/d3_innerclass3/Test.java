package com.siemonsele.d3_innerclass3;

public class Test {
    public static void  main(String[] args) {
        //目标：了解局部内部类：定义在方法里，构造器里，代码块等局部范围里的类
        //局部内部类（鸡肋语法，没什么用）
        class A{
            public void show(){

            }
        }
        A a = new A();
        a.show();
    }
}
