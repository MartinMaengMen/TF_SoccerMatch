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

import com.soccermatch.SoccerMatch.entity.Propietario;
import com.soccermatch.SoccerMatch.entity.Usuario;
import com.soccermatch.SoccerMatch.service.IPropietarioService;
import com.soccermatch.SoccerMatch.service.IUsuarioService;

@RestController
@RequestMapping("/Propietario")
public class PropietarioRestController {
	@Autowired
	private IPropietarioService Propietarioservice;
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Propietario> > fetchAll() {
		try {
			List<Propietario> Propietario = Propietarioservice.FindAll();
			return new ResponseEntity< List<Propietario> >(Propietario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Propietario> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Propietario > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Propietario> Propietario = Propietarioservice.findById(id);
			if(Propietario.isPresent()) {
				return new ResponseEntity< Propietario >(Propietario.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Propietario>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Propietario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Propietario> save( @Valid @RequestBody Propietario Propietario ) {
		try {
			if (Propietario.getUsuario().getId() != null) {
				Optional<Usuario> usuario = usuarioService.findById(Propietario.getUsuario().getId());

				if (usuario.isPresent()) {
					Propietario.setUsuario(usuario.get());
				}
			}
			
			Propietario tmp = Propietarioservice.Insert(Propietario);
			if( tmp != null ) {
				return new ResponseEntity<Propietario>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Propietario>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<Propietario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Propietario Propietario ) {
		try {
			Optional<Propietario> buscado = Propietarioservice.findById(Propietario.getId());
			
			if(buscado.isPresent()) {
				if (Propietario.getUsuario().getId() != null) {
					Optional<Usuario> usuario = usuarioService.findById(Propietario.getUsuario().getId());

					if (usuario.isPresent()) {
						Propietario.setUsuario(usuario.get());
					}
				}
				Propietarioservice.Update(Propietario);
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
			Optional<Propietario> buscado = Propietarioservice.findById(id);
			
			if(buscado.isPresent()) {
				Propietarioservice.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

