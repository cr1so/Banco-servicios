package com.fpmislata.banco.negocio.dominio;

import java.util.Date;

public class EntidadBancaria {
    int idEntidadBancaria;
    String nombre;
    int codigoEntidad;
    Date fechaCreacion;
    String direccion;
    String cif;

    public EntidadBancaria(int idEntidadBancaria, String nombre, int codigoEntidad, Date fechaCreacion, String direccion, String cif) {
        this.idEntidadBancaria = idEntidadBancaria;
        this.nombre = nombre;
        this.codigoEntidad = codigoEntidad;
        this.fechaCreacion = fechaCreacion;
        this.direccion = direccion;
        this.cif = cif;
    }

    public EntidadBancaria() {
    }

    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoEntidad(int codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigoEntidad() {
        return codigoEntidad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCif() {
        return cif;
    }
}
