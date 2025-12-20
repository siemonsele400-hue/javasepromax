package com.siemonsele.d13_estends_override2;

import com.siemonsele.d12_estends_override.Animal;

public class Test {
    public static  void main(String[] args) {
        //目标：搞清楚方法重写在实际开发中的应用场景
        Student s = new  Student("lxb",'男',175,"shuaige");
        System.out.println(s.toString()); //输出对象，其实是在输出对象所在的地址
        System.out.println(s);
    }
}
