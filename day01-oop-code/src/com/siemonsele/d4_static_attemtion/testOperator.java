package com.siemonsele.d4_static_attemtion;

public class testOperator {
    public static void main(String[] args) {
        //目标：理解使用static的几点注意事项
        Test.testStatic();
        Test.inAddr();
        Test t = new Test();
        t.printInfo();
        t.testNoStatic();
    }
}
