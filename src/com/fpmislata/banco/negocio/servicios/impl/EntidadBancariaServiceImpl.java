package com.fpmislata.banco.negocio.servicios.impl;

import com.fpmislata.banco.negocio.dominio.EntidadBancaria;
import com.fpmislata.banco.negocio.servicios.EntidadBancariaService;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class EntidadBancariaServiceImpl implements EntidadBancariaService {

    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;

    @Override
    public EntidadBancaria get(int id) {

        EntidadBancaria entidadBancaria = entidadBancariaDAO.get(id);

        return entidadBancaria;
    }

    @Override
    public boolean delete(int id) {
        return entidadBancariaDAO.delete(id);
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria t) {
        
        return entidadBancariaDAO.insert(t);
    }

    @Override
    public EntidadBancaria update(EntidadBancaria t) {
        return entidadBancariaDAO.update(t);
    }

    @Override
    public List<EntidadBancaria> findAll() {

        List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();

        return entidadesBancarias;
    }

}
