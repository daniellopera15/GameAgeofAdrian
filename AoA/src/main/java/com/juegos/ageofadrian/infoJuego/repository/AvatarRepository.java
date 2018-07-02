package com.juegos.ageofadrian.infoJuego.repository;

import com.juegos.ageofadrian.infoJuego.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
}
