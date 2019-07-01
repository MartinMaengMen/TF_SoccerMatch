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

import com.soccermatch.SoccerMatch.entity.Distrito;
import com.soccermatch.SoccerMatch.service.IDistritoService;

@RestController
@RequestMapping("/Distrito")
public class DistritoRestController {
	@Autowired
	private IDistritoService Distritoservice;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Distrito> > fetchAll() {
		try {
			List<Distrito> Distrito = Distritoservice.FindAll();
			return new ResponseEntity< List<Distrito> >(Distrito, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Distrito> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Distrito > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Distrito> Distrito = Distritoservice.findById(id);
			if(Distrito.isPresent()) {
				return new ResponseEntity< Distrito >(Distrito.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Distrito>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Distrito>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Distrito> save( @Valid @RequestBody Distrito Distrito ) {
		try {
			Distrito tmp = Distritoservice.Update(Distrito);
			if( tmp != null ) {
				return new ResponseEntity<Distrito>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Distrito>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Distrito>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Distrito Distrito ) {
		try {
			Optional<Distrito> buscado = Distritoservice.findById(Distrito.getId());
			
			if(buscado.isPresent()) {
				Distritoservice.Update(Distrito);
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
			Optional<Distrito> buscado = Distritoservice.findById(id);
			
			if(buscado.isPresent()) {
				Distritoservice.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

