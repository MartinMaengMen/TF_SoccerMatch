package com.soccermatch.SoccerMatch.service;

import java.util.Optional;

import com.soccermatch.SoccerMatch.entity.Jugador;

public interface IJugadorService extends CrudService<Jugador,Integer>{
	Optional<Jugador> findByUsuario(Integer id) throws Exception;
}
