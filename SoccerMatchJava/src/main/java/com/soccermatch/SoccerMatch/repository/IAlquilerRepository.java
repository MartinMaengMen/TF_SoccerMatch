package com.soccermatch.SoccerMatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.Alquiler;
@Repository
public interface IAlquilerRepository extends JpaRepository<Alquiler, Integer> {

}
