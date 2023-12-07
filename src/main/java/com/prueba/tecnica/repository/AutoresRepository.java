package com.prueba.tecnica.repository;

import org.springframework.data.repository.CrudRepository;
import com.prueba.tecnica.entities.Autores;
import com.prueba.tecnica.entities.AutoresPK;

public interface AutoresRepository extends CrudRepository<Autores, AutoresPK>{

}
