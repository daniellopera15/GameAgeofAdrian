package com.juegos.ageofadrian.infoJuego.model;

public class Auxiliar extends Soldado {

    public Auxiliar(Integer danio, Integer costo) {
        super(danio, costo, TipoSoldado.AUXILIAR);
        aumentarDefensa(5);
    }

    @Override
    public Integer getDanio() {
        int probabilidad = (int) Math.random() * 1;
        if (probabilidad == 1) {
            return 0;
        }
        return super.getDanio();
    }

}
