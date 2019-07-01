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

import com.soccermatch.SoccerMatch.entity.Equipo;
import com.soccermatch.SoccerMatch.service.IEquipoService;

@RestController
@RequestMapping("/Equipo")
public class EquipoRestController {
	@Autowired
	private IEquipoService Equiposervice;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Equipo> > fetchAll() {
		try {
			List<Equipo> Equipo = Equiposervice.FindAll();
			return new ResponseEntity< List<Equipo> >(Equipo, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Equipo> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Equipo > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Equipo> Equipo = Equiposervice.findById(id);
			if(Equipo.isPresent()) {
				return new ResponseEntity< Equipo >(Equipo.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Equipo>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Equipo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Equipo> save( @Valid @RequestBody Equipo Equipo ) {
		try {
			Equipo tmp = Equiposervice.Update(Equipo);
			if( tmp != null ) {
				return new ResponseEntity<Equipo>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Equipo>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Equipo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Equipo Equipo ) {
		try {
			Optional<Equipo> buscado = Equiposervice.findById(Equipo.getId());
			
			if(buscado.isPresent()) {
				Equiposervice.Update(Equipo);
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
			Optional<Equipo> buscado = Equiposervice.findById(id);
			
			if(buscado.isPresent()) {
				Equiposervice.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

