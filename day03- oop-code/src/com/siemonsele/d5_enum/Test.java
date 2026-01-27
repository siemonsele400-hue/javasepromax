package com.siemonsele.d5_enum;

public class Test {
    public static void main(String[] args) {
        //目标：认识枚举类，搞清楚枚举类的特点
//        A a = new A();  baocuo
        A a1 = A.X;
        A a2 = A.Y;
        A a3 = A.Z;
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");

        //value方法是用来拿到枚举类的全部对象，放到一个数组中去返回
        A[] as = A.values();
        for (int i = 0; i < as.length; i++) {
            A a = as[i];
            System.out.println(a);
        }
        A y = A.valueOf("Y");
        System.out.println(y == a2);

        //ordinal 拿对象的索引
        System.out.println(a1.ordinal());
        System.out.println(a2.ordinal());
    }
}
