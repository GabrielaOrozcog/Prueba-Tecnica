package com.prueba.tecnica.dto;

import com.prueba.tecnica.entities.Libros;

public class AutoresDTOList {
	
	private Long id;
	private String nombre;
	private String nacionalidad;
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
