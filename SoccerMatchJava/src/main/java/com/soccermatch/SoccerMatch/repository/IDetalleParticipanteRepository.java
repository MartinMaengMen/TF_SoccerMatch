package com.soccermatch.SoccerMatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.DetalleParticipante;
@Repository
public interface IDetalleParticipanteRepository extends JpaRepository<DetalleParticipante,Integer> {

}
