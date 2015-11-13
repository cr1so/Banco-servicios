package com.fpmislata.banco.negocio.servicios.securiry;

import com.fpmislata.banco.negocio.dominio.Usuario;

public interface Authorization {
    public boolean isAuthorizedURL (Usuario usuario, String url, String metodo);
}
