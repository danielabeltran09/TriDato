package com.tridato.service.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aguascalientes_acuerdos")
public class Acuerdo {
    @Id
    private int AcuerdoID;
    private int Numero;
    private int AreaID;
    private String Documento;
    private String Naturaleza;
    private String Partes;
    private String PermisoVerTexto;
    private String Extracto;
    private int TipoAcuerdoID;
    private String FechaPublicacion;
    private String FecDictado;

    protected Acuerdo() {
    }

    public Acuerdo(int acuerdoID, int numero, int areaID, String documento, String naturaleza, String partes, String permisoVerTexto, String extracto, int tipoAcuerdoID, String fechaPublicacion, String fecDictado) {
        AcuerdoID = acuerdoID;
        Numero = numero;
        AreaID = areaID;
        Documento = documento;
        Naturaleza = naturaleza;
        Partes = partes;
        PermisoVerTexto = permisoVerTexto;
        Extracto = extracto;
        TipoAcuerdoID = tipoAcuerdoID;
        FechaPublicacion = fechaPublicacion;
        FecDictado = fecDictado;
    }

    public int getAcuerdoID() {
        return AcuerdoID;
    }

    public void setAcuerdoID(int acuerdoID) {
        AcuerdoID = acuerdoID;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public int getAreaID() {
        return AreaID;
    }

    public void setAreaID(int areaID) {
        AreaID = areaID;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public String getNaturaleza() {
        return Naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        Naturaleza = naturaleza;
    }

    public String getPartes() {
        return Partes;
    }

    public void setPartes(String partes) {
        Partes = partes;
    }

    public String getPermisoVerTexto() {
        return PermisoVerTexto;
    }

    public void setPermisoVerTexto(String permisoVerTexto) {
        PermisoVerTexto = permisoVerTexto;
    }

    public String getExtracto() {
        return Extracto;
    }

    public void setExtracto(String extracto) {
        Extracto = extracto;
    }

    public int getTipoAcuerdoID() {
        return TipoAcuerdoID;
    }

    public void setTipoAcuerdoID(int tipoAcuerdoID) {
        TipoAcuerdoID = tipoAcuerdoID;
    }

    public String getFechaPublicacion() {
        return FechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        FechaPublicacion = fechaPublicacion;
    }

    public String getFecDictado() {
        return FecDictado;
    }

    public void setFecDictado(String fecDictado) {
        FecDictado = fecDictado;
    }
}
