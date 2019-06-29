package com.soccermatch.SoccerMatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.Propietario;
@Repository
public interface IPropietarioRepository extends JpaRepository<Propietario,Integer>{

}
