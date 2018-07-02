package com.juegos.ageofadrian.infoJuego.model;

public class Centurion extends Soldado {
    //private Arma escudo;

    public Centurion(Integer danio, Integer costo) {
        super(danio, costo, TipoSoldado.CENTURION);
        aumentarFuerza(10);
        aumentarDefensa(50);
    }

    @Override
    public Integer recibirAtaque(Integer danio) {
        int probabilidad = (int) Math.random() * 1;
        if(probabilidad == 1){
             return super.recibirAtaque(danio);
        }

        return danio;
    }
}
