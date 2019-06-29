package com.soccermatch.SoccerMatch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "DetalleParticipante" )
public class DetalleParticipante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "SMALLINT(4)")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_alquiler",nullable=false)
	@NotNull(message = "Ingrese un alquiler")
	private Alquiler alquiler;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_participante",nullable=false)
	@NotNull(message = "Ingrese un participante")
	private Participante participante;
	
	@Min(value = 0)
	@Column(name="cuota", columnDefinition = "TINYINT(1)", nullable = false)
	private int cuota;
	
	@Column(name="parte_pagada", nullable = false)
	private Boolean pagado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Alquiler getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public int getCuota() {
		return cuota;
	}

	public void setCuota(int cuota) {
		this.cuota = cuota;
	}

	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}
	
	
}
