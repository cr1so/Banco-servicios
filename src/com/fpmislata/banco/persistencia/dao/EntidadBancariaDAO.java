package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.negocio.dominio.EntidadBancaria;
import java.util.List;

public interface EntidadBancariaDAO extends GenericDAO<EntidadBancaria>{

    public List<EntidadBancaria> findByNombre(String nombre);
    
}
