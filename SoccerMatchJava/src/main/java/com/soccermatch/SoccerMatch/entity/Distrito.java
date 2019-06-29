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
@Table( name = "Distrito" )
public class Distrito implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "SMALLINT(4)")
	private Integer id;
	
	@NotEmpty(message="Ingrese nombre del departamento")
	@Size(min = 3, max = 100, message = "El nombre del distrito debe estar entre 3 a 100 caracteres" )
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_ciudad", nullable = false)
	@NotNull(message = "Ingrese una ciudad")
	private Ciudad ciudad;
	
	@OneToMany(mappedBy = "distrito", cascade = CascadeType.ALL)
	private List<Calle> calle;
	
	@OneToMany(mappedBy = "distrito", cascade = CascadeType.ALL)
	private List<Equipo> Equipo;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

