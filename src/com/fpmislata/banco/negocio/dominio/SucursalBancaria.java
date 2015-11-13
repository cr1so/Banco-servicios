package com.fpmislata.banco.negocio.dominio;

public class SucursalBancaria {

    int idSucursalBancaria;
    String localizacion;
    String direccion;
    String telefono;
    String nombreDirector;

    public SucursalBancaria(int idSucursalBancaria, String localizacion, String direccion, String telefono, String nombreDirector) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.localizacion = localizacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombreDirector = nombreDirector;
    }

    public SucursalBancaria() {
    }

    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }
}
