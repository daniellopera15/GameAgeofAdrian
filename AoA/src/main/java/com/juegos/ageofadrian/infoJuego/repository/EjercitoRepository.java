package com.juegos.ageofadrian.infoJuego.repository;

import com.juegos.ageofadrian.infoJuego.model.Ejercito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjercitoRepository extends JpaRepository<Ejercito, String> {
}
