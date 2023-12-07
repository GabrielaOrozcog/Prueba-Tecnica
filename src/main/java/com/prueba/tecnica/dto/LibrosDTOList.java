package com.prueba.tecnica.dto;

import java.util.Date;

public class LibrosDTOList {

	private Long id;
	private String autor;
	private String titulo;
	private String genero;
	private Date añoPublicacion;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getAñoPublicacion() {
		return añoPublicacion;
	}
	public void setAñoPublicacion(Date añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}
		
}
