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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = "Cancha" )
public class Cancha implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "SMALLINT(4)")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_propietario",nullable=false)
	@NotNull(message = "Ingrese un propietario")
	private Propietario propietario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_calle",nullable=false)
	@NotNull(message = "Ingrese una calle")
	private Calle calle;
	
	@OneToMany(mappedBy = "cancha", cascade = CascadeType.ALL)
	private List<Alquiler> alquiler;
	
	@NotEmpty(message="ingrese nombre")
	@Size(min = 4, max = 100, message = "El nombre de la cancha debe estar entre 4 a 100 caracteres" )
	@Column(name="nombre", length=50, nullable=false)
	private String nombre;
	
	@NotEmpty(message="ingrese direccion")
	@Size(min = 8, max = 100, message = "la direccion debe estar entre 8 a 100 caracteres" )
	@Column(name="direccion", length = 100, nullable = false)
	private String direccion;
	
	@Min(value = 10)
	@Max(value = 80)
	@NotNull(message = "se debe colocar un precio a la hora")
	@Column(name="precio_hora", columnDefinition = "TINYINT(2)", nullable = false)
	private int precioHora;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Calle getCalle() {
		return calle;
	}

	public void setCalle(Calle calle) {
		this.calle = calle;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(int precio_hora) {
		this.precioHora = precio_hora;
	}
	
	
	
	
}
