package com.juegos.ageofadrian.infoJuego.model;

import java.util.ArrayList;
import java.util.List;

public class Legion extends Soldado {

    private String nombre;
    private List<Soldado> soldados;

    public Legion(String nombre, Integer danio, Integer costo) {
        super(danio, costo, TipoSoldado.LEGION);
        this.nombre = nombre;
        soldados = new ArrayList<Soldado>();
        aumentarFuerza(20);
        aumentarDefensa(50);
    }

    public void agregarSoldado(Soldado soldado){
        this.soldados.add(soldado);
        aumentarDanio(soldado.getDanio());
    }

    public List<Soldado> getSoldados(){
        return soldados;
    }

}
