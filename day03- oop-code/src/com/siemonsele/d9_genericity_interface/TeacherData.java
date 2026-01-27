package com.siemonsele.d9_genericity_interface;

public class TeacherData implements Data<Teacher> {
    @Override
    public void add(Teacher teacher) {
        System.out.println("添加老师: " + teacher);
    }

    @Override
    public void delete(int id) {
        System.out.println("删除老师，ID: " + id);
    }

    @Override
    public void update(Teacher teacher) {
        System.out.println("更新老师: " + teacher);
    }

    @Override
    public Teacher getById(int id) {
        System.out.println("查询老师，ID: " + id);
        return null;
    }
}
