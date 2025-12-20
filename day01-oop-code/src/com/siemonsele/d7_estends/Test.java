package com.siemonsele.d7_estends;

public class Test {
    public static void main(String[] args) {
    //目标：认识继承，搞清楚继承的特点，以及继承后子类创建对象的特点
    //子烈对象的创建的特点：会由子类和父类等多张 设计图共同创建出子类对象，但是能访问什么还是看权限
    B b = new B();
    System.out.println(b.i);
//    System.out.println(b.j);
//    System.out.println(b.k);//报错
    b.print();
    //b.print2();//报错
    b.print3();
    }
}
