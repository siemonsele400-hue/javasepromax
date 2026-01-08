package com.siemonsele.d3_polymorphism;

public class Cat extends Animal {
    @Override
    public void cry(){
        System.out.println("小猫喵喵叫~ ");
    }

    public  void eat(){
        System.out.println("小猫会吃鱼");
    }
}
