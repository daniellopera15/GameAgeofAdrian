package com.juegos.ageofadrian.infoJuego.model;

import javax.persistence.*;


@Entity
@Table(name = "Avatar")
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String password;
    private String descripcion;
    private Integer nivel;
    private Long dinero;
    @OneToOne
    private Ejercito ejercito;

    public Avatar() {
    }

    /*
        public Avatar(String nombre, String password, String descripcion, String nombreEjercito) {
            this.nombre = nombre;
            this.password = password;
            this.descripcion = descripcion;
            this.nivel = 0;
            this.dinero = 0L;
            this.ejercito = new Ejercito(nombreEjercito);
        }
    */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Long getDinero() {
        return dinero;
    }

    public void setDinero(Long dinero) {
        this.dinero = dinero;
    }

    public Ejercito getEjercito() {
        return ejercito;
    }

    public void setEjercito(Ejercito ejercito) {
        this.ejercito = ejercito;
    }

}
