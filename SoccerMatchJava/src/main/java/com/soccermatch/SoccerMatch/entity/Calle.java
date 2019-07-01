package com.soccermatch.SoccerMatch.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table( name = "Calle" )
public class Calle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "SMALLINT(4)")
	private Integer id;
	
	@NotEmpty(message = "ingrese nombre de la calle")
	@Size(min = 3, max = 100, message = "El nombre de la calle debe estar entre 3 a 100 caracteres" )
	@Column(name="nombre", length = 100, nullable=false)
	private String nombre;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_distrito",nullable=false)
	@NotNull(message = "Ingrese un distrito")
	private Distrito distrito;
	
	@OneToMany(mappedBy = "calle", cascade = CascadeType.ALL)
	private List<Cancha> cancha;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
