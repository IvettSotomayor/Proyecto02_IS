package com.example.proyecto02_is;

public class Turno {
    private int ID;
    private String nombre;
    private String jornada;

    public Turno(int ID, String nombre, String jornada) {
        this.ID = ID;
        this.nombre = nombre;
        this.jornada = jornada;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJornada() { return jornada; }

    public void setJornada(String jornada) { this.jornada = jornada; }
}

