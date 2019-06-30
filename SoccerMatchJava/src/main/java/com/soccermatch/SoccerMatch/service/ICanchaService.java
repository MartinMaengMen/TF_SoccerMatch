package com.soccermatch.SoccerMatch.service;

import java.util.List;

import com.soccermatch.SoccerMatch.entity.Cancha;


public interface ICanchaService extends CrudService<Cancha,Integer> {
	List<Cancha> fetchByUsuarioId(Integer id) throws Exception;
}
