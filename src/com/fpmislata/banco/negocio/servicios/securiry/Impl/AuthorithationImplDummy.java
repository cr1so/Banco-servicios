package com.fpmislata.banco.negocio.servicios.securiry.Impl;

import com.fpmislata.banco.negocio.dominio.Usuario;
import com.fpmislata.banco.negocio.servicios.securiry.Authorization;

public class AuthorithationImplDummy implements Authorization {

    @Override
    public boolean isAuthorizedURL(Usuario usuario, String url, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
