package com.fpmislata.banco.persistencia.dao;

import java.util.List;

public interface GenericDAO<T> {

    T get(int id);

    boolean delete(int id);

    T insert(T t);

    T update(T t);

    List<T> findAll();

}
