package com.soccermatch.SoccerMatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.Cancha;

@Repository
public interface ICanchaRepository extends JpaRepository<Cancha,Integer> {

}
