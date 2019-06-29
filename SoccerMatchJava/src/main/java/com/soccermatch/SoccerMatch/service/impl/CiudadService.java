package com.soccermatch.SoccerMatch.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soccermatch.SoccerMatch.entity.Ciudad;
import com.soccermatch.SoccerMatch.repository.ICiudadRepository;
import com.soccermatch.SoccerMatch.service.ICiudadService;

@Service
public class CiudadService implements ICiudadService{
@Autowired
private ICiudadRepository ciudadrepository;
	@Transactional
	@Override
	public Ciudad Insert(Ciudad t) throws Exception {
		// TODO Auto-generated method stub
		return ciudadrepository.save(t);
	}
	@Transactional
	@Override
	public Ciudad Update(Ciudad t) throws Exception {
		// TODO Auto-generated method stub
		return ciudadrepository.save(t);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Ciudad> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return ciudadrepository.findAll();
	}
	@Transactional(readOnly=true)
	@Override
	public Optional<Ciudad> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return ciudadrepository.findById(id);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		ciudadrepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		ciudadrepository.deleteAll();
		
	}


}
