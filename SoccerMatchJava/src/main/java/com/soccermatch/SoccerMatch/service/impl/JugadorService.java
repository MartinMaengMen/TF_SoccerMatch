package com.soccermatch.SoccerMatch.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soccermatch.SoccerMatch.entity.Jugador;
import com.soccermatch.SoccerMatch.repository.IJugadorRepository;
import com.soccermatch.SoccerMatch.service.IJugadorService;

@Service
public class JugadorService implements IJugadorService{
@Autowired
private IJugadorRepository jugadorrepository;
	@Transactional
	@Override
	public Jugador Insert(Jugador t) throws Exception {
		// TODO Auto-generated method stub
		return jugadorrepository.save(t);
	}
	@Transactional
	@Override
	public Jugador Update(Jugador t) throws Exception {
		// TODO Auto-generated method stub
		return jugadorrepository.save(t);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Jugador> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return jugadorrepository.findAll();
	}
	@Transactional(readOnly=true)
	@Override
	public Optional<Jugador> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return jugadorrepository.findById(id);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		jugadorrepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		jugadorrepository.deleteAll();
		
	}


}
