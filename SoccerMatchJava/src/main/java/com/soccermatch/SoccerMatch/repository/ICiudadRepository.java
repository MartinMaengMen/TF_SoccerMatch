package com.soccermatch.SoccerMatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.Ciudad;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad,Integer> {

}
