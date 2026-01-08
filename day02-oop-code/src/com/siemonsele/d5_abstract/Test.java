package com.siemonsele.d5_abstract;

public class Test {
    public static void main(String[] args) {
        //目标：认识抽象类，搞清楚抽象类的特点
        //抽象类的核心特点：不能创建对象
        //A a = new A;  //报错
        //一个类继承抽象类，必须重写完抽象类的全部抽象方法，否则这个类也必须是抽象类
        B b = new B();
    }
}
