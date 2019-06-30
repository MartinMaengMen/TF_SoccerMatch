package com.soccermatch.SoccerMatch.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soccermatch.SoccerMatch.entity.Departamento;
import com.soccermatch.SoccerMatch.repository.IDepartamentoRepository;
import com.soccermatch.SoccerMatch.service.IDepartamentoService;

@Service
public class DepartamentoService implements IDepartamentoService{
@Autowired
private IDepartamentoRepository departamentorepository;
	@Transactional
	@Override
	public Departamento Insert(Departamento t) throws Exception {
		// TODO Auto-generated method stub
		return departamentorepository.save(t);
	}
	@Transactional
	@Override
	public Departamento Update(Departamento t) throws Exception {
		// TODO Auto-generated method stub
		return departamentorepository.save(t);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Departamento> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return departamentorepository.findAll();
	}
	@Transactional(readOnly=true)
	@Override
	public Optional<Departamento> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return departamentorepository.findById(id);}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		departamentorepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		departamentorepository.deleteAll();
		
	}

}
