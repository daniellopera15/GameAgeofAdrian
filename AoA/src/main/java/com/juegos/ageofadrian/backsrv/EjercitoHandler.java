package com.juegos.ageofadrian.backsrv;

public class EjercitoHandler {
    private String nombre;
    private int auxialiares;
    private int centuriones;
    private int legionarios;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAuxialiares() {
        return auxialiares;
    }

    public void setAuxialiares(int auxialiares) {
        this.auxialiares = auxialiares;
    }

    public int getCenturiones() {
        return centuriones;
    }

    public void setCenturiones(int centuriones) {
        this.centuriones = centuriones;
    }

    public int getLegionarios() {
        return legionarios;
    }

    public void setLegionarios(int legionarios) {
        this.legionarios = legionarios;
    }

    @Override
    public String toString() {
        return nombre+ " " +auxialiares+ " " + centuriones+ " " + legionarios;
    }
}
