package com.prueba.tecnica.repository;

import org.springframework.data.repository.CrudRepository;
import com.prueba.tecnica.entities.Libros;
import com.prueba.tecnica.entities.LibrosPK;

public interface LibrosRepository extends CrudRepository<Libros, LibrosPK>{

}
