package com.example.crudandroid2.utilidades;

public class utilidades {

    public static final String CLIENTE="cliente";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_CORREO="correo";
    public static final String CAMPO_TELEFONO ="telefono";

    public static final String CREAR_CLIENTE ="CREATE TABLE "+CLIENTE+"(" +
            CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            CAMPO_NOMBRE+" TEXT, "+
            CAMPO_CORREO+" TEXT, "+
            CAMPO_TELEFONO +" INTEGER)";
}
