package com.soccermatch.SoccerMatch.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soccermatch.SoccerMatch.entity.Equipo;
import com.soccermatch.SoccerMatch.repository.IEquipoRepository;
import com.soccermatch.SoccerMatch.service.IEquipoService;

@Service
public class EquipoService implements IEquipoService{
	@Autowired
	private IEquipoRepository equiporepository;
	@Transactional
	@Override
	public Equipo Insert(Equipo t) throws Exception {
		// TODO Auto-generated method stub
		return equiporepository.save(t);
	}
	@Transactional
	@Override
	public Equipo Update(Equipo t) throws Exception {
		// TODO Auto-generated method stub
		return equiporepository.save(t);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Equipo> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return equiporepository.findAll();
	}
	@Transactional(readOnly=true)
	@Override
	public Optional<Equipo> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return equiporepository.findById(id);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		equiporepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		equiporepository.deleteAll();
		
	}

	

}
