package com.siemonsele.d16_estends_consteuctor2;

public class Teacher extends People{
    private String skill;
    public Teacher(){
    }

    public Teacher(String name, int age, String skill) {
        super(name, age); // 子类为啥要调用父类构造器：初始化继承自父类部分的数据。
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
