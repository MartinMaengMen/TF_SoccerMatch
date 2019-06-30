package com.soccermatch.SoccerMatch.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = "Jugador" )
public class Jugador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "SMALLINT(4)")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario", nullable = false)
	@NotNull(message = "Ingrese un usuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL)
	private List<Participante> participante;

	@NotEmpty(message = "ingrese direccion")
	@Size(min = 8, max = 100, message = "direccion debe estar entre 8 a 100 caracteres" )
	@Column(name = "direccion", length = 100, nullable = false)
	private String Direccion;
	
	public Integer getId() {
		return id;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}

