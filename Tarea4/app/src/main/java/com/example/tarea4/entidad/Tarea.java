package com.example.tarea4.entidad;

public class Tarea {
    private String nombre;
    private int imagenResId;

    public Tarea(String nombre, int imagenResId) {
        this.nombre = nombre;
        this.imagenResId = imagenResId;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagenResId() {
        return imagenResId;
    }
}
