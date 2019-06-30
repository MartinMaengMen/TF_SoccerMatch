package com.soccermatch.SoccerMatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.Distrito;
@Repository
public interface IDistritoRepository extends JpaRepository<Distrito,Integer> {

}
