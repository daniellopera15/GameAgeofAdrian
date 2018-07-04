package com.juegos.ageofadrian.infoJuego.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ejercito {

    @Id
    private String nombre;
    @OneToMany
    private List<Soldado> soldados;
/*
    public Ejercito(String nombre) {
        this.nombre = nombre;
        this.soldados = new ArrayList<Soldado>();
    }
*/
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Soldado> getSoldados() {
        return soldados;
    }

    public void setSoldados(List<Soldado> soldados) {
        this.soldados = soldados;
    }

    public void agregarSoldado(Soldado soldado) {
        this.soldados.add(soldado);
    }

    public Integer atacarEjercito() {
        Integer danio = 0;
        for (Soldado soldado : soldados) {
            danio += soldado.getDanio();
        }
        return danio;
    }

    //Se recorre la lista de soldados y se elimina la defensa primero y luego la vida.
    //Continua hasta que el danio se acabe
    public void recibirAtaque(Integer danio) {
        List<Soldado> eliminados = new ArrayList<Soldado>();
        for (Soldado soldado : soldados) {
            if (danio > 0) {
                danio = soldado.recibirAtaque(danio);
                if (soldado.getVida() <= 0) {
                    eliminados.add(soldado);
                }
            } else {
                break;
            }
        }
        eliminarSoldados(eliminados);
    }

    //Elimina de la lista a los soldados eliminados
    public void eliminarSoldados(List<Soldado> eliminados) {
        for (Soldado soldado : eliminados) {
            if (soldado.getTipoSoldado() == TipoSoldado.LEGION) {
                destruirLegion(soldado);
            }
            this.soldados.remove(soldado);
        }
    }

    //En caso de que una legion haya sido eliminada,todos sus soldados pasan a formar parte de la lista (Incluyedo las legiones internas)
    public void destruirLegion(Soldado soldado) {
        Legion legion = (Legion) soldado;
        for (Soldado soldadosLegion : legion.getSoldados()) {
            this.soldados.add(soldadosLegion);
        }
    }
}
