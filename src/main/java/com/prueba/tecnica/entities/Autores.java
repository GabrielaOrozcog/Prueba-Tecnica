package com.prueba.tecnica.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "autores")
@IdClass(AutoresPK.class)
public class Autores implements Serializable{
	
	private static final long serialVersionUID = -9005522915247534874L;	
	@Id
	@Column(nullable = false, name = "id")
	private Long id;
	
	@Id
	@Column(nullable = false, name = "nombre")
	private String nombre;
	
	@Id
	@Column(nullable = false, name = "nacionalidad")
	private String nacionalidad;
	
	@JoinColumn(name = "autor", referencedColumnName = "autor", nullable = false)
    @ManyToOne(optional = false)
    private Libros libros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Libros getLibros() {
		return libros;
	}

	public void setLibros(Libros libros) {
		this.libros = libros;
	}
	
	

}
