package com.soccermatch.SoccerMatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.Equipo;
import com.soccermatch.SoccerMatch.entity.Participante;
import com.soccermatch.SoccerMatch.entity.Usuario;
@Repository
public interface IParticipanteRepository extends JpaRepository<Participante,Integer> {

	@Query(value = "SELECT e FROM Equipo e where e.id = (SELECT p.equipo.id FROM Participante p where p.jugador.id = ?1 and p.equipo.id = e.id)")
	List<Equipo>fetchEquiposRecomendados(Integer id); 
	
	@Query("select u from Usuario u join Jugador j where j.id = ( select p.Jugador.id from Participante p where p.Equipo.id = ?1 and p.Jugador.id = j.id) and u.id = j.Usuario.id")
	List<Usuario>fetchMiembrosDeEquipo(Integer id);
}

