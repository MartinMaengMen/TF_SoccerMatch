package com.soccermatch.SoccerMatch.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soccermatch.SoccerMatch.entity.Usuario;
import com.soccermatch.SoccerMatch.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {
	@Autowired
	private IUsuarioService usuarioservice;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Usuario> > fetchAll() {
		try {
			List<Usuario> usuario = usuarioservice.FindAll();
			return new ResponseEntity< List<Usuario> >(usuario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Usuario> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Usuario > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Usuario> usuario = usuarioservice.findById(id);
			if(usuario.isPresent()) {
				return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Usuario> save( @Valid @RequestBody Usuario usuario ) {
		try {
			Usuario tmp = usuarioservice.Update(usuario);
			if( tmp != null ) {
				return new ResponseEntity<Usuario>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Usuario usuario ) {
		try {
			Optional<Usuario> buscado = usuarioservice.findById(usuario.getId());
			
			if(buscado.isPresent()) {
				usuarioservice.Update(usuario);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping( value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> delete( @PathVariable("id") Integer id ) {
		try {
			Optional<Usuario> buscado = usuarioservice.findById(id);
			
			if(buscado.isPresent()) {
				usuarioservice.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
