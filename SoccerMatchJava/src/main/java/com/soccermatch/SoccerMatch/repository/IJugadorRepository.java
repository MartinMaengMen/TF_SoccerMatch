package com.soccermatch.SoccerMatch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.Jugador;
@Repository
public interface IJugadorRepository extends JpaRepository<Jugador,Integer> {
	
	@Query("SELECT j FROM Jugador j join Usuario u on j.usuario.id = u.id WHERE u.id = ?1 ")
	Optional<Jugador> findByUsuario(Integer id);	
}
