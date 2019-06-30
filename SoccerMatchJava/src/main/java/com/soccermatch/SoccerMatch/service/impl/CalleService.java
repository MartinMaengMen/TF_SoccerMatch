package com.soccermatch.SoccerMatch.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soccermatch.SoccerMatch.entity.Calle;
import com.soccermatch.SoccerMatch.repository.ICalleRepository;
import com.soccermatch.SoccerMatch.service.ICalleService;

@Service
public class CalleService implements ICalleService{
@Autowired
private ICalleRepository callerepository;
	@Transactional
	@Override
	public Calle Insert(Calle t) throws Exception {
		// TODO Auto-generated method stub
		return callerepository.save(t);
	}
	@Transactional
	@Override
	public Calle Update(Calle t) throws Exception {
		// TODO Auto-generated method stub
		return callerepository.save(t);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Calle> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return callerepository.findAll();
	}
	@Transactional(readOnly=true)
	@Override
	public Optional<Calle> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return callerepository.findById(id);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		callerepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		callerepository.deleteAll();
		
	}


}
