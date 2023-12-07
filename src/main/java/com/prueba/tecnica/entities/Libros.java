package com.prueba.tecnica.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
@IdClass(LibrosPK.class)
public class Libros implements Serializable{

private static final long serialVersionUID = -629636322850605729L;
	
	@Id
	@Column(nullable = false, name = "id")
	private Long id;
	
	@Id
	@Column(nullable = false, name = "autor")
	private String autor;
	
	@Column(nullable = false, name = "titulo")
	private String titulo;
	
	@Column(nullable = false, name = "genero")
	private String genero;

	@Column(nullable = false, name = "añoPublicacion")
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
