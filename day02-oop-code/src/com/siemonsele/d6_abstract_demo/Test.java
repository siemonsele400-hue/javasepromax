package com.siemonsele.d6_abstract_demo;

public class Test {
    public static void main(String[] args) {
        //目标：搞清楚抽象类的应用场景
        Animal a = new Cat();
        a.cry();

        Animal a2 = new Dog();
        a2.cry();
    }
}
