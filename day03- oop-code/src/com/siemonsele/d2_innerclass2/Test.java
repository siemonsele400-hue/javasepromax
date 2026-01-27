package com.siemonsele.d2_innerclass2;

public class Test {
    public static  void main(String[] args) {
        //目标：认识静态内部类，搞清楚其特点
        //外部类名.内部类 对象名 = new 外部类名.静态内部类（）；
        Outer.Inner in = new Outer.Inner();
        in.show();
    }
}
