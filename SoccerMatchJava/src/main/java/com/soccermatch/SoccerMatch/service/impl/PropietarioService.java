package com.soccermatch.SoccerMatch.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soccermatch.SoccerMatch.entity.Propietario;
import com.soccermatch.SoccerMatch.repository.IPropietarioRepository;
import com.soccermatch.SoccerMatch.service.IPropietarioService;
@Service
public class PropietarioService implements IPropietarioService{
@Autowired
private IPropietarioRepository propietariorepository;
	@Transactional
	@Override
	public Propietario Insert(Propietario t) throws Exception {
		// TODO Auto-generated method stub
		return propietariorepository.save(t);
	}
	@Transactional
	@Override
	public Propietario Update(Propietario t) throws Exception {
		// TODO Auto-generated method stub
		return propietariorepository.save(t);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Propietario> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return propietariorepository.findAll();
	}
	@Transactional(readOnly=true)
	@Override
	public Optional<Propietario> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return propietariorepository.findById(id);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		propietariorepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		propietariorepository.deleteAll();
		
	}


}
