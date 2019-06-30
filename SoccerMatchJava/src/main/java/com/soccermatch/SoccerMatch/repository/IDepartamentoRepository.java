package com.soccermatch.SoccerMatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccermatch.SoccerMatch.entity.Departamento;
@Repository
public interface IDepartamentoRepository extends JpaRepository<Departamento,Integer> {

}
