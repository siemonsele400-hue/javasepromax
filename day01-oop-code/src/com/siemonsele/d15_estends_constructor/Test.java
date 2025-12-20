package com.siemonsele.d15_estends_constructor;

public class Test {
    public static void main(String[] args) {
        //目标：搞清楚继承后子类构造器的特点
        //子类的全部构造器都会先调用父类的构造器，再执行自己的构造器
        Wolf w1 = new Wolf();
        Wolf w2 = new Wolf("七匹狼");
    }
}
