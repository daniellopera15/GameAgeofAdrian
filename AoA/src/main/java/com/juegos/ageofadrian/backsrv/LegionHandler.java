package com.juegos.ageofadrian.backsrv;

public class LegionHandler {
    private String nombre;
    private int auxiliares;
    private int centuriones;
    private int legionarios;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAuxialiares() {
        return auxiliares;
    }

    public void setAuxialiares(int auxialiares) {
        this.auxiliares = auxialiares;
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
        return nombre+ " " +auxiliares+ " " + centuriones+ " " + legionarios;
    }
}
