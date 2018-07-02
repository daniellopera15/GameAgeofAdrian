package com.juegos.ageofadrian.infoJuego.service;

import com.juegos.ageofadrian.infoJuego.model.Avatar;

import java.util.List;

public interface AvatarService {
    public Avatar crearAvatar(Avatar avatar);

    public Avatar editarAvatar(Avatar avatar);

    public boolean eliminarAvatar(Long id);

    public List<Avatar> listarAvatares();
}
