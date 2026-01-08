package com.siemonsele.d1_polymorphism;

public class Test {
    public static void main(String[] args) {
        //目标：认识多态，搞清楚多态的使用前提
        //多态的前提：有继承/实现的关系；存在父类引用子类对象；存在方法重写
        //1.对象多态，行为多态
        Animal animal = new Animal();
        animal.cry();
        Animal a1 = new Cat();
        a1.cry();
        Animal a2 = new Dog();
        a2.cry();
    }
}
