package com.soccermatch.SoccerMatch.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soccermatch.SoccerMatch.entity.Participante;
import com.soccermatch.SoccerMatch.repository.IParticipanteRepository;
import com.soccermatch.SoccerMatch.service.IParticipanteService;

@Service
public class ParticipanteService implements IParticipanteService{
@Autowired
private IParticipanteRepository participanterepository;
	@Override
	public Participante Insert(Participante t) throws Exception {
		// TODO Auto-generated method stub
		return participanterepository.save(t);
	}

	@Override
	public Participante Update(Participante t) throws Exception {
		// TODO Auto-generated method stub
		return participanterepository.save(t);
	}

	@Override
	public List<Participante> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return participanterepository.findAll();
	}

	@Override
	public Optional<Participante> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return participanterepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		participanterepository.deleteById(id);
		
	}

	@Override
	public void deleteAll() throws Exception {
		participanterepository.deleteAll();
		
	}

}
