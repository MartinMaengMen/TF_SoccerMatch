package com.soccermatch.SoccerMatch.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soccermatch.SoccerMatch.entity.Distrito;
import com.soccermatch.SoccerMatch.repository.IDistritoRepository;
import com.soccermatch.SoccerMatch.service.IDistritoService;

@Service
public class DistritoService implements IDistritoService{
	@Autowired
	private IDistritoRepository distritorepository;
	@Transactional
	@Override
	public Distrito Insert(Distrito t) throws Exception {
		// TODO Auto-generated method stub
		return distritorepository.save(t);
	}
	@Transactional
	@Override
	public Distrito Update(Distrito t) throws Exception {
		// TODO Auto-generated method stub
		return distritorepository.save(t);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Distrito> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return distritorepository.findAll();
	}
	@Transactional(readOnly=true)
	@Override
	public Optional<Distrito> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return distritorepository.findById(id);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		distritorepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		distritorepository.deleteAll();
		
	}

	

}
