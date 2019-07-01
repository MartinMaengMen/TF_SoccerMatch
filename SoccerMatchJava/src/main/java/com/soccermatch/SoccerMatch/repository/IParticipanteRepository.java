package com.soccermatch.SoccerMatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.Alquiler;
import com.soccermatch.SoccerMatch.entity.Equipo;
import com.soccermatch.SoccerMatch.entity.Participante;
import com.soccermatch.SoccerMatch.entity.Usuario;
@Repository
public interface IParticipanteRepository extends JpaRepository<Participante,Integer> {

	@Query(value = "SELECT e FROM Equipo e where e.id = (SELECT p.equipo.id FROM Participante p where p.jugador.id = ?1 and p.equipo.id = e.id)")
	List<Equipo>fetchEquiposRecomendados(Integer id); 
	
	@Query("select u from Usuario u join Jugador j on u.id = j.usuario.id where j.id = ( select p.jugador.id from Participante p where p.equipo.id = ?1 and p.jugador.id = j.id)")
	List<Usuario>fetchMiembrosDeEquipo(Integer id);
	
	@Query("select a from Alquiler a where a.equipo.id = ?1")
	List<Alquiler>fetchListAlquiler(Integer id);
}

