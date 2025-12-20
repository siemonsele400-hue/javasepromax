package com.siemonsele.d9_estends_modifier;

public class Demo1 {
    public static void main(String[] args) {
        Fu f = new Fu();
//        f.privateMethod(); 报错，私有只能在本类中访问
        f.method();
        f.protectedMethod();
        f.publicMethod();
    }
}
