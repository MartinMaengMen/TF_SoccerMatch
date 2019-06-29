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

import com.soccermatch.SoccerMatch.entity.Calle;
import com.soccermatch.SoccerMatch.service.ICalleService;

@RestController
@RequestMapping("/Calle")
public class CalleRestController {
	@Autowired
	private ICalleService Calleservice;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Calle> > fetchAll() {
		try {
			List<Calle> Calle = Calleservice.FindAll();
			return new ResponseEntity< List<Calle> >(Calle, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Calle> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Calle > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Calle> Calle = Calleservice.findById(id);
			if(Calle.isPresent()) {
				return new ResponseEntity< Calle >(Calle.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Calle>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Calle>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Calle> save( @Valid @RequestBody Calle Calle ) {
		try {
			Calle tmp = Calleservice.Update(Calle);
			if( tmp != null ) {
				return new ResponseEntity<Calle>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Calle>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Calle>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Calle Calle ) {
		try {
			Optional<Calle> buscado = Calleservice.findById(Calle.getId());
			
			if(buscado.isPresent()) {
				Calleservice.Update(Calle);
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
			Optional<Calle> buscado = Calleservice.findById(id);
			
			if(buscado.isPresent()) {
				Calleservice.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

