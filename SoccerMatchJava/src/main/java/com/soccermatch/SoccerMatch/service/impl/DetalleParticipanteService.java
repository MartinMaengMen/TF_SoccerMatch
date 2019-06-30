package com.soccermatch.SoccerMatch.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soccermatch.SoccerMatch.entity.DetalleParticipante;
import com.soccermatch.SoccerMatch.repository.IDetalleParticipanteRepository;
import com.soccermatch.SoccerMatch.service.IDetalleParticipanteService;

@Service
public class DetalleParticipanteService implements IDetalleParticipanteService{
@Autowired
private IDetalleParticipanteRepository detalleparticipanterepository;
	@Transactional
	@Override
	public DetalleParticipante Insert(DetalleParticipante t) throws Exception {
		// TODO Auto-generated method stub
		return detalleparticipanterepository.save(t);
	}
	@Transactional
	@Override
	public DetalleParticipante Update(DetalleParticipante t) throws Exception {
		// TODO Auto-generated method stub
		return detalleparticipanterepository.save(t);
	}
	@Transactional(readOnly=true)
	@Override
	public List<DetalleParticipante> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return detalleparticipanterepository.findAll();
	}
	@Transactional(readOnly=true)
	@Override
	public Optional<DetalleParticipante> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return detalleparticipanterepository.findById(id);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		detalleparticipanterepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		detalleparticipanterepository.deleteAll();
		
	}

	

}
