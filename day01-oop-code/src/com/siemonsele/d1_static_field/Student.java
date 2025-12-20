package com.siemonsele.d1_static_field;

public class Student {
    //静态变量：有static修饰，属于类持有，在内存中值加载一次，被类和类的全部对象所共用
    static String name;
    //实例变量：无static修饰，属于每个对象
    int age;
}
