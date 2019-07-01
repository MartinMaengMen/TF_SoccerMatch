package com.soccermatch.SoccerMatch.service;

import java.util.List;

import com.soccermatch.SoccerMatch.entity.Equipo;
import com.soccermatch.SoccerMatch.entity.Participante;


public interface IParticipanteService extends CrudService<Participante,Integer>{
	List<Equipo> fetchEquiposRecomendados(Integer id) throws Exception;
}
