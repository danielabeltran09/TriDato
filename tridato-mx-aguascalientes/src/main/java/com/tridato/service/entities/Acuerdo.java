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
    private String Extracto;
    private boolean PermisoVerTexto;
    private int TipoAcuerdoID;
    private String FechaPublicacion;
    private String FecDictado;
    private boolean Editar;
    private String DescripcionClasificacion;
    private boolean Publicado;

    protected Acuerdo() {
    }

    public Acuerdo(int acuerdoID, int numero, int areaID, String documento, String naturaleza, String partes, String extracto, boolean permisoVerTexto, int tipoAcuerdoID, String fechaPublicacion, String fecDictado, boolean editar, String descripcionClasificacion, boolean publicado) {
        AcuerdoID = acuerdoID;
        Numero = numero;
        AreaID = areaID;
        Documento = documento;
        Naturaleza = naturaleza;
        Partes = partes;
        Extracto = extracto;
        PermisoVerTexto = permisoVerTexto;
        TipoAcuerdoID = tipoAcuerdoID;
        FechaPublicacion = fechaPublicacion;
        FecDictado = fecDictado;
        Editar = editar;
        DescripcionClasificacion = descripcionClasificacion;
        Publicado = publicado;
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

    public String getExtracto() {
        return Extracto;
    }

    public void setExtracto(String extracto) {
        Extracto = extracto;
    }

    public boolean isPermisoVerTexto() {
        return PermisoVerTexto;
    }

    public void setPermisoVerTexto(boolean permisoVerTexto) {
        PermisoVerTexto = permisoVerTexto;
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

    public boolean isEditar() {
        return Editar;
    }

    public void setEditar(boolean editar) {
        Editar = editar;
    }

    public String getDescripcionClasificacion() {
        return DescripcionClasificacion;
    }

    public void setDescripcionClasificacion(String descripcionClasificacion) {
        DescripcionClasificacion = descripcionClasificacion;
    }

    public boolean getPublicado() {
        return Publicado;
    }

    public void setPublicado(boolean publicado) {
        Publicado = publicado;
    }
}
