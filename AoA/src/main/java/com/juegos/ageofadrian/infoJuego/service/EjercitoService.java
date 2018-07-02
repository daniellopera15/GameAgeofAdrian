package com.juegos.ageofadrian.infoJuego.service;

import com.juegos.ageofadrian.infoJuego.model.Ejercito;

import java.util.List;

public interface EjercitoService {
    public Ejercito crearEjercito(Ejercito ejercito);

    public Ejercito editarEjercito(Ejercito ejercito);

    public boolean eliminarEjercito(String id);

    public List<Ejercito> listarEjercitos();
}
