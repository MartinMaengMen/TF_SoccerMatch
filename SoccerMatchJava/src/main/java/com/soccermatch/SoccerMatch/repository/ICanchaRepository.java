package com.soccermatch.SoccerMatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.Cancha;

@Repository
public interface ICanchaRepository extends JpaRepository<Cancha,Integer> {

	@Query("SELECT c FROM Cancha c WHERE c.propietario.id = ?1")
	List<Cancha>fetchByUsuarioId(Integer id);
}
