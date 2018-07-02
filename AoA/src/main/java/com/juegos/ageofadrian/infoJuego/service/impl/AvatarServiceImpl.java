package com.juegos.ageofadrian.infoJuego.service.impl;

import com.juegos.ageofadrian.infoJuego.model.Avatar;
import com.juegos.ageofadrian.infoJuego.repository.AvatarRepository;
import com.juegos.ageofadrian.infoJuego.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AvatarServiceImpl implements AvatarService {

    @Autowired
    private AvatarRepository avatarRepository;

    @Override
    public Avatar crearAvatar(Avatar avatar) {
        return avatarRepository.save(avatar);
    }

    @Override
    public Avatar editarAvatar(Avatar avatar) {
        if (avatarRepository.findOne(avatar.getId()) == null)
            return null;

        return avatarRepository.save(avatar);
    }

    @Override
    public boolean eliminarAvatar(Long id) {
        if (avatarRepository.findOne(id) == null)
            return false;

        avatarRepository.delete(id);
        return true;
    }

    @Override
    public List<Avatar> listarAvatares() {
        return avatarRepository.findAll();
    }
}
