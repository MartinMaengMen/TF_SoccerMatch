package com.soccermatch.SoccerMatch.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = "Equipo" )
public class Equipo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "SMALLINT(4)")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_distrito", nullable = false)
	@NotNull(message = "Ingrese un distrito")
	private Distrito distrito;
	
	@OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
	private List<Participante> participante;
	
	@OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
	private List<Alquiler> alquiler;
	
	@NotEmpty(message = "ingresar nombre del equipo")
	@Size(min = 3, max = 100, message = "el nombre del equipo debe tener entre 3 a 100 caracteres")
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;
	
	@NotEmpty(message = "ingresar una descripcion")
	@Column(name="descripcion", nullable = false)
	private String descripcion;
	
	@Min(value = 1, message = "Solo se permite equipos formados 12 personas")
	@Max(value = 12, message = "Solo se permite equipos formados 12 personas")
	@Column(name="num_participantes", columnDefinition = "TINYINT(2)", nullable=false)
	private int numParticipantes;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_juego")
	private Date fechaJuego;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumParticipantes() {
		return numParticipantes;
	}

	public void setNumParticipantes(int numparticipantes) {
		this.numParticipantes = numparticipantes;
	}

	public Date getFechaJuego() {
		return fechaJuego;
	}

	public void setFechaJuego(Date fechajuego) {
		this.fechaJuego = fechajuego;
	}
	
	
}
