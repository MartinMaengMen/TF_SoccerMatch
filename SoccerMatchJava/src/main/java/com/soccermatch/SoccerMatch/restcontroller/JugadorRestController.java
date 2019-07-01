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

import com.soccermatch.SoccerMatch.entity.Jugador;
import com.soccermatch.SoccerMatch.entity.Usuario;
import com.soccermatch.SoccerMatch.service.IJugadorService;
import com.soccermatch.SoccerMatch.service.IUsuarioService;

@RestController
@RequestMapping("/Jugador")
public class JugadorRestController {
	@Autowired
	private IJugadorService Jugadorservice;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Jugador>> fetchAll() {
		try {
			List<Jugador> Jugador = Jugadorservice.FindAll();
			return new ResponseEntity<List<Jugador>>(Jugador, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Jugador>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Jugador> fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Jugador> Jugador = Jugadorservice.findById(id);
			if (Jugador.isPresent()) {
				return new ResponseEntity<Jugador>(Jugador.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Jugador>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Jugador>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Jugador> save(@Valid @RequestBody Jugador Jugador) {
		try {
			if (Jugador.getUsuario().getId() != null) {
				Optional<Usuario> usuario = usuarioService.findById(Jugador.getUsuario().getId());

				if (usuario.isPresent()) {
					Jugador.setUsuario(usuario.get());
				}
			}

			Jugador tmp = Jugadorservice.Insert(Jugador);

			if (tmp != null) {
				return new ResponseEntity<Jugador>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Jugador>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<Jugador>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Jugador Jugador) {
		try {
			Optional<Jugador> buscado = Jugadorservice.findById(Jugador.getId());

			if (buscado.isPresent()) {
				if (Jugador.getUsuario().getId() != null) {
					Optional<Usuario> usuario = usuarioService.findById(Jugador.getUsuario().getId());
					if (usuario.isPresent()) {
						Jugador.setUsuario(usuario.get());
					}
				}
				Jugadorservice.Update(Jugador);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Jugador> buscado = Jugadorservice.findById(id);

			if (buscado.isPresent()) {
				Jugadorservice.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
