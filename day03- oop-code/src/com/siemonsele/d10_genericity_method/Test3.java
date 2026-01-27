package com.siemonsele.d10_genericity_method;

public class Test3 {
    public static void main(String[] args) {
        int count = 0;
        for (int j = 0; j < 100; j++) {
            count = count++;
        }
        System.out.println(count);
    }
}