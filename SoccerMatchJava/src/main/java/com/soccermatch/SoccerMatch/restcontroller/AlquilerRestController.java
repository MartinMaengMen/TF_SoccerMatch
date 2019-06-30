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

import com.soccermatch.SoccerMatch.entity.Alquiler;
import com.soccermatch.SoccerMatch.service.IAlquilerService;

@RestController
@RequestMapping("/Alquiler")
public class AlquilerRestController {
	@Autowired
	private IAlquilerService Alquilerservice;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Alquiler> > fetchAll() {
		try {
			List<Alquiler> Alquiler = Alquilerservice.FindAll();
			return new ResponseEntity< List<Alquiler> >(Alquiler, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Alquiler> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Alquiler > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Alquiler> Alquiler = Alquilerservice.findById(id);
			if(Alquiler.isPresent()) {
				return new ResponseEntity< Alquiler >(Alquiler.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Alquiler>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Alquiler>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Alquiler> save( @Valid @RequestBody Alquiler Alquiler ) {
		try {
			Alquiler tmp = Alquilerservice.Update(Alquiler);
			if( tmp != null ) {
				return new ResponseEntity<Alquiler>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Alquiler>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Alquiler>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Alquiler Alquiler ) {
		try {
			Optional<Alquiler> buscado = Alquilerservice.findById(Alquiler.getId());
			
			if(buscado.isPresent()) {
				Alquilerservice.Update(Alquiler);
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
			Optional<Alquiler> buscado = Alquilerservice.findById(id);
			
			if(buscado.isPresent()) {
				Alquilerservice.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

