package com.soccermatch.SoccerMatch.restcontroller;

import java.util.ArrayList;
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
import com.soccermatch.SoccerMatch.entity.Equipo;
import com.soccermatch.SoccerMatch.entity.Participante;
import com.soccermatch.SoccerMatch.service.IEquipoService;
import com.soccermatch.SoccerMatch.entity.Usuario;
import com.soccermatch.SoccerMatch.service.IParticipanteService;

@RestController
@RequestMapping("/participante")
public class ParticipanteRestController {
	@Autowired
	private IParticipanteService Participanteservice;
	@Autowired
	private IEquipoService equipoService;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Participante> > fetchAll() {
		try {
			List<Participante> Participante = Participanteservice.FindAll();
			return new ResponseEntity< List<Participante> >(Participante, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Participante> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Participante > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Participante> Participante = Participanteservice.findById(id);
			if(Participante.isPresent()) {
				return new ResponseEntity< Participante >(Participante.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Participante>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Participante>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(value = "/jugador/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Equipo> > fetchEquipos(@PathVariable("id") Integer id) {
		try {
			List<Equipo> Equipo = Participanteservice.fetchEquiposRecomendados(id);
			return new ResponseEntity< List<Equipo> >(Equipo, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity< List<Equipo> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/recomendados/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Equipo> > fetchEquiposRecomendados(@PathVariable("id") Integer id) {
		try {
			List<Equipo> Equipos = Participanteservice.fetchEquiposRecomendados(id);
			List<Equipo> Todos = equipoService.FindAll();
			List<Equipo> Recomendados = new ArrayList<Equipo>();
			Boolean estado = false;
			for (Equipo equipo : Todos) {
				for (Equipo equipo2 : Equipos) {
					if(equipo.getId() == equipo2.getId())
					{
						estado = true;
						break;
					}
				}
				if(estado == false) {
					Recomendados.add(equipo);
				}
				else {
					estado = false;
				}
			}
			return new ResponseEntity< List<Equipo> >(Recomendados, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity< List<Equipo> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/equipo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Usuario> > fetchMiembrosDeEquipo(@PathVariable("id") Integer id) {
		try {
			List<Usuario> miembros = Participanteservice.fetchMiembrosDeEquipo(id);
			return new ResponseEntity< List<Usuario> >(miembros, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity< List<Usuario> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/alquiler/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Alquiler> > fetchListAlquiler(@PathVariable("id") Integer id) {
		try {
			List<Alquiler> Equipo = Participanteservice.fetchListAlquiler(id);
			return new ResponseEntity< List<Alquiler> >(Equipo, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity< List<Alquiler> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Participante> save( @Valid @RequestBody Participante Participante ) {
		try {
			Participante tmp = Participanteservice.Update(Participante);
			if( tmp != null ) {
				return new ResponseEntity<Participante>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Participante>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Participante>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Participante Participante ) {
		try {
			Optional<Participante> buscado = Participanteservice.findById(Participante.getId());
			
			if(buscado.isPresent()) {
				Participanteservice.Update(Participante);
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
			Optional<Participante> buscado = Participanteservice.findById(id);
			
			if(buscado.isPresent()) {
				Participanteservice.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

