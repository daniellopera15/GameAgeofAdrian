package com.juegos.ageofadrian.infoJuego.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Soldado {
    private static Long idStatic = 0L;

    @Id
    private Long id;
    private TipoSoldado tipoSoldado;
    private Integer vida;
    private Integer danio;
    private Integer fuerza;
    @OneToOne
    private Arma arma;
    private Integer defensa;
    private Integer costo;

    public Soldado(Integer danio, Integer costo, TipoSoldado tipoSoldado) {
        this.vida = 1000;
        this.danio = 0;
        aumentarFuerza(5);
        aumentarDefensa(100);
        this.costo = costo;
        this.tipoSoldado = tipoSoldado;
        this.id = ++idStatic;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getDanio() {
        return danio;
    }

    public Integer getFuerza() {
        return fuerza;
    }

    public void aumentarFuerza(Integer fuerza) {
        this.fuerza += fuerza;
        aumentarDanio(fuerza);
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        if (this.arma != null)
            this.danio -= this.arma.getValor();

        this.arma = arma;
        aumentarDanio(arma.getValor());
    }

    public void aumentarDanio(Integer danio){
        this.danio += danio;
    }

    public Integer getDefensa() {
        return defensa;
    }

    //public void restarDefensa(Integer defensa){ this.defensa -= defensa; }

    public void aumentarDefensa(Integer defensa) {
        this.defensa += defensa;
    }

    public Integer getCosto() {
        return costo;
    }

    public TipoSoldado getTipoSoldado() {
        return tipoSoldado;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public void restaurarVida(){
        this.vida = 1000;
    }

    public Integer recibirAtaque(Integer danio){
        if(defensa > 0){
            danio = perderDefensa(danio);
        }

        if(danio > 0){
            danio = perderVida(danio);
        }

        return danio;
    }

    public Integer perderVida(Integer danio){
        Integer vidaInicial = vida;

        vida -= danio;
        danio -= vidaInicial;
        return danio;
    }

    public Integer perderDefensa(Integer danio){
        Integer defensaInicial = defensa;

        defensa -= danio;
        danio -= defensaInicial;
        if(defensa < 0){
            defensa = 0;
        }
        return danio;
    }
}
