package com.soccermatch.SoccerMatch.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soccermatch.SoccerMatch.entity.Usuario;
import com.soccermatch.SoccerMatch.repository.IUsuarioRepository;
import com.soccermatch.SoccerMatch.service.IUsuarioService;
@Service
public class UsuarioService implements IUsuarioService{
@Autowired
private IUsuarioRepository usuariorepository;

@Override
@Transactional
public Usuario Insert(Usuario t) throws Exception {
	// TODO Auto-generated method stub
	return usuariorepository.save(t);
}
@Transactional
@Override
public Usuario Update(Usuario t) throws Exception {
	// TODO Auto-generated method stub
	return usuariorepository.save(t);
}
@Transactional(readOnly=true)
@Override
public List<Usuario> FindAll() throws Exception {
	// TODO Auto-generated method stub
	return usuariorepository.findAll();
}
@Transactional(readOnly=true)
@Override
public Optional<Usuario> findById(Integer id) throws Exception {
	// TODO Auto-generated method stub
	return usuariorepository.findById(id);
}
@Transactional
@Override
public void deleteById(Integer id) throws Exception {
	usuariorepository.deleteById(id);
	
}
@Transactional
@Override
public void deleteAll() throws Exception {
	usuariorepository.deleteAll();
	
}


}
