package com.siemonsele.d13_estends_override2;

public class Student {
    private String name;
    private char sex;
    private double height;
    private String desc;

    @Override
    public  String toString() {
        return "Student{" +
                "name=" + name + '\'' + "sex" + sex  + '\'' +"height" + height +  '\'' + "desc" + desc + "}";
    }

    public Student() {
    }

    public Student(String name, char sex, double height, String desc) {
        this.name = name;
        this.sex = sex;
        this.height = height;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
