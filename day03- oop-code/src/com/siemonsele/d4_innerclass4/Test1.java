package com.siemonsele.d4_innerclass4;

public class Test1 {
    public static void main(String[] args) {
        //目标：认识匿名内部类
        //匿名内部类本质是一个子类，同时会立即创建一个子类对象
        //匿名内部类的名称：当前类名&编号
        Animal a = new Animal(){
            @Override
            public void cry(){
                System.out.println("狗汪汪汪的叫~~~");
            }

        };
        a.cry();
    }
}

//class Dog extends Animal{
//    @Override
//    public void cry(){
//        System.out.println("狗汪汪汪的叫~~~");
//    }
//}

abstract  class Animal {
    public  abstract void cry();
}