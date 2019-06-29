package com.soccermatch.SoccerMatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.Participante;
@Repository
public interface IParticipanteRepository extends JpaRepository<Participante,Integer> {

}
