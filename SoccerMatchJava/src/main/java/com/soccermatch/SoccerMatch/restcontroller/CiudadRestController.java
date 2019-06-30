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

import com.soccermatch.SoccerMatch.entity.Ciudad;
import com.soccermatch.SoccerMatch.service.ICiudadService;

@RestController
@RequestMapping("/Ciudad")
public class CiudadRestController {
	@Autowired
	private ICiudadService Ciudadservice;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Ciudad> > fetchAll() {
		try {
			List<Ciudad> Ciudad = Ciudadservice.FindAll();
			return new ResponseEntity< List<Ciudad> >(Ciudad, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Ciudad> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Ciudad > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Ciudad> Ciudad = Ciudadservice.findById(id);
			if(Ciudad.isPresent()) {
				return new ResponseEntity< Ciudad >(Ciudad.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Ciudad>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Ciudad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Ciudad> save( @Valid @RequestBody Ciudad Ciudad ) {
		try {
			Ciudad tmp = Ciudadservice.Update(Ciudad);
			if( tmp != null ) {
				return new ResponseEntity<Ciudad>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Ciudad>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Ciudad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Ciudad Ciudad ) {
		try {
			Optional<Ciudad> buscado = Ciudadservice.findById(Ciudad.getId());
			
			if(buscado.isPresent()) {
				Ciudadservice.Update(Ciudad);
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
			Optional<Ciudad> buscado = Ciudadservice.findById(id);
			
			if(buscado.isPresent()) {
				Ciudadservice.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

