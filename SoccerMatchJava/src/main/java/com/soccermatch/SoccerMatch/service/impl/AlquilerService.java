package com.soccermatch.SoccerMatch.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soccermatch.SoccerMatch.entity.Alquiler;
import com.soccermatch.SoccerMatch.repository.IAlquilerRepository;
import com.soccermatch.SoccerMatch.service.IAlquilerService;
@Service
public class AlquilerService implements IAlquilerService{
	@Autowired
	private IAlquilerRepository alquilerrepository;
	@Transactional
	@Override
	public Alquiler Insert(Alquiler t) throws Exception {
		// TODO Auto-generated method stub
		return alquilerrepository.save(t);
	}
	@Transactional
	@Override
	public Alquiler Update(Alquiler t) throws Exception {
		// TODO Auto-generated method stub
		return alquilerrepository.save(t);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Alquiler> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return alquilerrepository.findAll();
	}
	@Transactional(readOnly=true)
	@Override
	public Optional<Alquiler> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return alquilerrepository.findById(id);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		alquilerrepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		alquilerrepository.deleteAll();
		
	}



}
