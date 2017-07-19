package com.example.android7ed.listapermisos.ClasesFuncionales;

import android.os.Parcelable;

import java.io.Serializable;



public class Permisos implements Serializable{
    private String name;
    private String descripcion;
    public Permisos (String namep, String descripcionp){
        name = namep;
        descripcion = descripcionp;
    }
    public String getName (){
        return name;
    }
    public String getDescripcion (){
        return descripcion;
    }
    public String toString (){
        return name;
    }
}