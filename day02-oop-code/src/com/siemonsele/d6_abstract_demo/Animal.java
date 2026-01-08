package com.siemonsele.d6_abstract_demo;

public abstract class Animal {
    private  String name;

    //抽象类的好处：方法体无意义时可以不写（简化代码），强制子类重写（更好的支持多态）
    public abstract void cry();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
