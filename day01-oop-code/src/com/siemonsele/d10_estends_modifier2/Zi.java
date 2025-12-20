package com.siemonsele.d10_estends_modifier2;

import com.siemonsele.d9_estends_modifier.Fu;

public class Zi extends Fu {

    public void print(){
//        privateMethod();
//        merhod();  报错
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.protectedMethod();
        zi.publicMethod();
    }
}
