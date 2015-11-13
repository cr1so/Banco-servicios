package com.fpmislata.banco.negocio.servicios.securiry.Impl;

import com.fpmislata.banco.negocio.servicios.securiry.PasswordManager;
import org.jasypt.util.password.StrongPasswordEncryptor;

public class PasswordManagerImplJasypt implements PasswordManager {

    @Override
    public String encrypt(String plain) {
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(plain);
        return encryptedPassword;
    }

    @Override
    public boolean check(String plain, String encrypt) {
        StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
        boolean checked = strongPasswordEncryptor.checkPassword(plain, encrypt);
        return checked;
    }
}
