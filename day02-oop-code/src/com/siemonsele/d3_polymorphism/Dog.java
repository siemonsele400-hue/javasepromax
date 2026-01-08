package com.siemonsele.d3_polymorphism;

public class Dog extends Animal {
    @Override
    public void cry(){
        System.out.println("小狗汪汪叫~");
    }

    public static void lookDoor(){
        System.out.println("小狗会看门");
    }
}
