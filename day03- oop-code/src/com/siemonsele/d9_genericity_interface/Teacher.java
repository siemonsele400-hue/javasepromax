package com.siemonsele.d9_genericity_interface;

public class Teacher {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{name='" + name + "'}";
    }
}
