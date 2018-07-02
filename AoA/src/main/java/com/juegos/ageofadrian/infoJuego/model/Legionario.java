package com.juegos.ageofadrian.infoJuego.model;

public class Legionario extends Soldado{

    //private Arma escudo;

    public Legionario(Integer danio, Integer costo) {
        super(danio, costo, TipoSoldado.LEGIONARIO);
        aumentarFuerza(25);
        aumentarDefensa(5);
    }
}
