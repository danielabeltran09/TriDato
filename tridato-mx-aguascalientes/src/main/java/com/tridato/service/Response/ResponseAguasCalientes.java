package com.tridato.service.Response;

public class ResponseAguasCalientes {
    private boolean Success;
    private String Message;
    private Object Data;

    public ResponseAguasCalientes() {
    }

    public ResponseAguasCalientes(boolean success, String message, Object data) {
        Success = success;
        Message = message;
        Data = data;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }
}


class Data{
    private Publicaciones[] Publicaciones;
    private Acuerdos[] Acuerdos;

    public Data() {
    }

    public Data(com.tridato.service.Response.Publicaciones[] publicaciones, com.tridato.service.Response.Acuerdos[] acuerdos) {
        Publicaciones = publicaciones;
        Acuerdos = acuerdos;
    }

    public com.tridato.service.Response.Publicaciones[] getPublicaciones() {
        return Publicaciones;
    }

    public void setPublicaciones(com.tridato.service.Response.Publicaciones[] publicaciones) {
        Publicaciones = publicaciones;
    }

    public com.tridato.service.Response.Acuerdos[] getAcuerdos() {
        return Acuerdos;
    }

    public void setAcuerdos(com.tridato.service.Response.Acuerdos[] acuerdos) {
        Acuerdos = acuerdos;
    }
}

class Publicaciones{
    private int PublicacionID;
    private String FechaPublicacion;
    private int UsuarioID;
    private String FechaDictado;
    private int FirmaUsuarioID;
    private int GrupoAreaMateriaID;
    private String ListaPDF;

    public Publicaciones() {
    }

    public Publicaciones(int publicacionID, String fechaPublicacion, int usuarioID, String fechaDictado, int firmaUsuarioID, int grupoAreaMateriaID, String listaPDF) {
        PublicacionID = publicacionID;
        FechaPublicacion = fechaPublicacion;
        UsuarioID = usuarioID;
        FechaDictado = fechaDictado;
        FirmaUsuarioID = firmaUsuarioID;
        GrupoAreaMateriaID = grupoAreaMateriaID;
        ListaPDF = listaPDF;
    }

    public int getPublicacionID() {
        return PublicacionID;
    }

    public void setPublicacionID(int publicacionID) {
        PublicacionID = publicacionID;
    }

    public String getFechaPublicacion() {
        return FechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        FechaPublicacion = fechaPublicacion;
    }

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        UsuarioID = usuarioID;
    }

    public String getFechaDictado() {
        return FechaDictado;
    }

    public void setFechaDictado(String fechaDictado) {
        FechaDictado = fechaDictado;
    }

    public int getFirmaUsuarioID() {
        return FirmaUsuarioID;
    }

    public void setFirmaUsuarioID(int firmaUsuarioID) {
        FirmaUsuarioID = firmaUsuarioID;
    }

    public int getGrupoAreaMateriaID() {
        return GrupoAreaMateriaID;
    }

    public void setGrupoAreaMateriaID(int grupoAreaMateriaID) {
        GrupoAreaMateriaID = grupoAreaMateriaID;
    }

    public String getListaPDF() {
        return ListaPDF;
    }

    public void setListaPDF(String listaPDF) {
        ListaPDF = listaPDF;
    }
}
class Acuerdos{
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
        private Object[] AcuerdosClasificacion ;
        private Object[] Archivos;
        private Object Publicado;

    public Acuerdos() {
    }

    public Acuerdos(int acuerdoID, int numero, int areaID, String documento, String naturaleza, String partes, String extracto, boolean permisoVerTexto, int tipoAcuerdoID, String fechaPublicacion, String fecDictado, boolean editar, String descripcionClasificacion, Object[] acuerdosClasificacion, Object[] archivos, Object publicado) {
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
        AcuerdosClasificacion = acuerdosClasificacion;
        Archivos = archivos;
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

    public Object[] getAcuerdosClasificacion() {
        return AcuerdosClasificacion;
    }

    public void setAcuerdosClasificacion(Object[] acuerdosClasificacion) {
        AcuerdosClasificacion = acuerdosClasificacion;
    }

    public Object[] getArchivos() {
        return Archivos;
    }

    public void setArchivos(Object[] archivos) {
        Archivos = archivos;
    }

    public Object getPublicado() {
        return Publicado;
    }

    public void setPublicado(Object publicado) {
        Publicado = publicado;
    }
}
