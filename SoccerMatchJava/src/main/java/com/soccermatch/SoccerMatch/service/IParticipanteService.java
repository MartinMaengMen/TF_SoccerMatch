package com.soccermatch.SoccerMatch.service;

import java.util.List;

import com.soccermatch.SoccerMatch.entity.Equipo;
import com.soccermatch.SoccerMatch.entity.Participante;
import com.soccermatch.SoccerMatch.entity.Usuario;


public interface IParticipanteService extends CrudService<Participante,Integer>{
	List<Equipo> fetchEquiposRecomendados(Integer id) throws Exception;
	List<Usuario>fetchMiembrosDeEquipo(Integer id) throws Exception;
}
