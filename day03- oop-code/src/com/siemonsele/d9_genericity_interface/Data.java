package com.siemonsele.d9_genericity_interface;

public interface Data<E> {
    void add(E e);
    void delete(int id);
    void update(E e);
    E getById(int id);
}