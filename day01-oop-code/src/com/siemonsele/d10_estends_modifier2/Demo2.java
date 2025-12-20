package com.siemonsele.d10_estends_modifier2;

import com.siemonsele.d9_estends_modifier.Fu;

public class Demo2 {
    public static void main(String[] args) {
        Fu f = new Fu();
//        f.privateMethod();
//        f.method();
//        f.protectedMethod();
        f.publicMethod();

        Zi zi = new Zi();
//        zi.protectedMethod();
//        zi.method();
        zi.publicMethod();
    }
}
