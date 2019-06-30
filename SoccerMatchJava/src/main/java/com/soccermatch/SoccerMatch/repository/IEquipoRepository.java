package com.soccermatch.SoccerMatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.Equipo;
@Repository
public interface IEquipoRepository extends JpaRepository<Equipo,Integer> {

}
