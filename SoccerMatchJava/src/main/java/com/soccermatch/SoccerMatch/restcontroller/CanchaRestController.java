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

import com.soccermatch.SoccerMatch.entity.Cancha;
import com.soccermatch.SoccerMatch.service.ICanchaService;

@RestController
@RequestMapping("/Cancha")
public class CanchaRestController {
	@Autowired
	private ICanchaService Canchaservice;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Cancha> > fetchAll() {
		try {
			List<Cancha> Cancha = Canchaservice.FindAll();
			return new ResponseEntity< List<Cancha> >(Cancha, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Cancha> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Cancha > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Cancha> Cancha = Canchaservice.findById(id);
			if(Cancha.isPresent()) {
				return new ResponseEntity< Cancha >(Cancha.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Cancha>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Cancha>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Cancha> save( @Valid @RequestBody Cancha Cancha ) {
		try {
			Cancha tmp = Canchaservice.Update(Cancha);
			if( tmp != null ) {
				return new ResponseEntity<Cancha>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Cancha>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Cancha>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Cancha Cancha ) {
		try {
			Optional<Cancha> buscado = Canchaservice.findById(Cancha.getId());
			
			if(buscado.isPresent()) {
				Canchaservice.Update(Cancha);
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
			Optional<Cancha> buscado = Canchaservice.findById(id);
			
			if(buscado.isPresent()) {
				Canchaservice.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

