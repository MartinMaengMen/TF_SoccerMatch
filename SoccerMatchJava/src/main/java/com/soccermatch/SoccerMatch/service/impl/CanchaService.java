package com.soccermatch.SoccerMatch.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soccermatch.SoccerMatch.entity.Cancha;
import com.soccermatch.SoccerMatch.repository.ICanchaRepository;
import com.soccermatch.SoccerMatch.service.ICanchaService;

@Service
public class CanchaService implements ICanchaService{
@Autowired
private ICanchaRepository cancharepository; 
	@Transactional
	@Override
	public Cancha Insert(Cancha t) throws Exception {
		// TODO Auto-generated method stub
		return cancharepository.save(t);
	}
	@Transactional
	@Override
	public Cancha Update(Cancha t) throws Exception {
		// TODO Auto-generated method stub
		return cancharepository.save(t);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Cancha> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return cancharepository.findAll();
	}
	@Transactional(readOnly=true)
	@Override
	public Optional<Cancha> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return cancharepository.findById(id);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		cancharepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		cancharepository.deleteAll();
		
	}



}
