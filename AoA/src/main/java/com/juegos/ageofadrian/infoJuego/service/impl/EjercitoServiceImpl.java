package com.juegos.ageofadrian.infoJuego.service.impl;

import com.juegos.ageofadrian.infoJuego.model.Ejercito;
import com.juegos.ageofadrian.infoJuego.repository.EjercitoRepository;
import com.juegos.ageofadrian.infoJuego.service.EjercitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EjercitoServiceImpl implements EjercitoService {

    @Autowired
    private EjercitoRepository ejercitoRepository;

    @Override
    public Ejercito crearEjercito(Ejercito ejercito) {
        return ejercitoRepository.save(ejercito);
    }

    @Override
    public Ejercito editarEjercito(Ejercito ejercito) {
        if (ejercitoRepository.findOne(ejercito.getNombre()) == null)
            return null;

        return ejercitoRepository.save(ejercito);
    }

    @Override
    public boolean eliminarEjercito(String id) {
        if (ejercitoRepository.findOne(id) == null)
            return false;

        ejercitoRepository.delete(id);
        return true;
    }

    @Override
    public List<Ejercito> listarEjercitos() {
        return ejercitoRepository.findAll();
    }
}
