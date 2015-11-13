package com.fpmislata.banco.negocio.servicios;

import java.util.List;

public interface GenericService<T> {
    
    T get(int id);

    boolean delete(int id);

    T insert(T t);

    T update(T t);

    List<T> findAll();
}
