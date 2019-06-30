package com.soccermatch.SoccerMatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.Jugador;
@Repository
public interface IJugadorRepository extends JpaRepository<Jugador,Integer> {

}
