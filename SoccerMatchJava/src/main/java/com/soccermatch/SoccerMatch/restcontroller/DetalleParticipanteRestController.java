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

import com.soccermatch.SoccerMatch.entity.DetalleParticipante;
import com.soccermatch.SoccerMatch.service.IDetalleParticipanteService;

@RestController
@RequestMapping("/DetalleParticipante")
public class DetalleParticipanteRestController {
	@Autowired
	private IDetalleParticipanteService DetalleParticipanteservice;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<DetalleParticipante> > fetchAll() {
		try {
			List<DetalleParticipante> DetalleParticipante = DetalleParticipanteservice.FindAll();
			return new ResponseEntity< List<DetalleParticipante> >(DetalleParticipante, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<DetalleParticipante> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< DetalleParticipante > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<DetalleParticipante> DetalleParticipante = DetalleParticipanteservice.findById(id);
			if(DetalleParticipante.isPresent()) {
				return new ResponseEntity< DetalleParticipante >(DetalleParticipante.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<DetalleParticipante>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<DetalleParticipante>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<DetalleParticipante> save( @Valid @RequestBody DetalleParticipante DetalleParticipante ) {
		try {
			DetalleParticipante tmp = DetalleParticipanteservice.Update(DetalleParticipante);
			if( tmp != null ) {
				return new ResponseEntity<DetalleParticipante>(HttpStatus.OK);
			} else {
				return new ResponseEntity<DetalleParticipante>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<DetalleParticipante>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody DetalleParticipante DetalleParticipante ) {
		try {
			Optional<DetalleParticipante> buscado = DetalleParticipanteservice.findById(DetalleParticipante.getId());
			
			if(buscado.isPresent()) {
				DetalleParticipanteservice.Update(DetalleParticipante);
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
			Optional<DetalleParticipante> buscado = DetalleParticipanteservice.findById(id);
			
			if(buscado.isPresent()) {
				DetalleParticipanteservice.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

