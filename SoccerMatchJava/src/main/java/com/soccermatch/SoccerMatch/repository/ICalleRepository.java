package com.soccermatch.SoccerMatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.Calle;
@Repository
public interface ICalleRepository extends JpaRepository<Calle, Integer> {

}
