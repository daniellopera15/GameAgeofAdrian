package com.juegos.ageofadrian.infoJuego.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Arma {
    private static Long idStatic = 0L;

    @Id
    private Long id;
    private String tipo;
    private Integer valor;

    public Arma(String tipo, Integer valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.id = ++idStatic;
    }

    public Long getId(){
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getValor() {
        return valor;
    }
}
