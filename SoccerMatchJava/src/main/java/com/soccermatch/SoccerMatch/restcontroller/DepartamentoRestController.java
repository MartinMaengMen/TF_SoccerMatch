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

import com.soccermatch.SoccerMatch.entity.Departamento;
import com.soccermatch.SoccerMatch.service.IDepartamentoService;

@RestController
@RequestMapping("/Departamento")
public class DepartamentoRestController {
	@Autowired
	private IDepartamentoService Departamentoservice;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Departamento> > fetchAll() {
		try {
			List<Departamento> Departamento = Departamentoservice.FindAll();
			return new ResponseEntity< List<Departamento> >(Departamento, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Departamento> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Departamento > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Departamento> Departamento = Departamentoservice.findById(id);
			if(Departamento.isPresent()) {
				return new ResponseEntity< Departamento >(Departamento.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Departamento>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Departamento>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Departamento> save( @Valid @RequestBody Departamento Departamento ) {
		try {
			Departamento tmp = Departamentoservice.Update(Departamento);
			if( tmp != null ) {
				return new ResponseEntity<Departamento>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Departamento>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Departamento>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Departamento Departamento ) {
		try {
			Optional<Departamento> buscado = Departamentoservice.findById(Departamento.getId());
			
			if(buscado.isPresent()) {
				Departamentoservice.Update(Departamento);
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
			Optional<Departamento> buscado = Departamentoservice.findById(id);
			
			if(buscado.isPresent()) {
				Departamentoservice.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

