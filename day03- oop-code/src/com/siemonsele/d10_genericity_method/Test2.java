package com.siemonsele.d10_genericity_method;

import com.siemonsele.d5_enum.A;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        // 目标：通配符和上下限。
        // 需求：所有汽车要一起参与比赛。
        ArrayList<TSL> tsls = new ArrayList<>();
        tsls.add(new TSL());
        tsls.add(new TSL());
        tsls.add(new TSL());
        go(tsls);

        ArrayList<LX> lxes = new ArrayList<>();
        lxes.add(new LX());
        lxes.add(new LX());
        lxes.add(new LX());
        go(lxes);

//        ArrayList<Dog> dogs = new ArrayList<>();
//        dogs.add(new Dog());
//        dogs.add(new Dog());
//        dogs.add(new Dog());
//        go(dogs);
    }

    // 虽然LX和TSL是Car的子类，但是 ArrayList<TSL>和 ArrayList<LX> 与 ArrayList<Car> 没有半毛钱关系。
    // 通配符：其实就是？，可以在使用泛型的时候代表一切类型。  E T K V 是定义时用
    // 泛型的上下限： ? extends Car(上限，？必须是Car或者Car的子类)
    //             ? super Car(下限，？必须是Car或者Car的父类)
    public static void go(ArrayList<? extends Car> cars){
    }

}

class Car{

}

class TSL extends Car{

}

class LX extends Car{

}

class Dog{
}
