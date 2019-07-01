package com.soccermatch.SoccerMatch.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "SMALLINT(4)")
	private Integer id;

	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="usuario")
	private Jugador jugador;

	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="usuario")
	private Propietario propietario;
	
	@NotNull
	@Min(value = 10000000, message = "el DNI debe tener 8 numeros")
	@Max(value = 99999999, message = "el DNI debe tener 8 numeros")
	@Column(name = "dni", nullable=false)
	private int dni;

	@NotEmpty(message = "ingrese nombre")
	@Size(min = 4, max = 100, message = "el nombre debe tener entre 4 a 100 caracteres")
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	@Min(value = 1000000, message = "El numero de telefono debe tener entre 7 a 9 numeros")
	@Max(value = 999999999, message = "El numero de telefono debe tener entre 7 a 9 numeros")
	@Column(name = "num_telefono", nullable = false)
	private int numtelefono;
	
	@NotEmpty(message = "ingrese un username")
	@Size(min = 6, max = 100, message = "El username deber tener entre 6 a 100 caracteres")
	@Column(name = "username", length = 100, nullable = false)
	private String username;
	
	@NotEmpty(message = "ingrese Password")
	@Size(min = 8, max = 100, message = "El password deber tener entre 8 a 100 caracteres")
	@Column(name = "password", length = 100, nullable = false)
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumtelefono() {
		return numtelefono;
	}

	public void setNumtelefono(int numtelefono) {
		this.numtelefono = numtelefono;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
