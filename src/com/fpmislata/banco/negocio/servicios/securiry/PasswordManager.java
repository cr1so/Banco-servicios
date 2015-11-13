package com.fpmislata.banco.negocio.servicios.securiry;

public interface PasswordManager {

    public String encrypt(String plain);

    boolean check(String plain, String encrypt);

}
