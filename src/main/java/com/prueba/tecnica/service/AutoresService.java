package com.prueba.tecnica.service;

import org.springframework.stereotype.Service;

import com.prueba.tecnica.dto.AutoresDTO;
import com.prueba.tecnica.dto.AutoresDTOList;
import com.prueba.tecnica.dto.Response;

import fj.data.Either;

@Service
public interface AutoresService {
	
	Either<Exception, Response> crearAutor (AutoresDTO autoresDTO);
	
	Either<Exception, AutoresDTOList> buscarAutor (Long id);
	
	Either<Exception, Response> borrarAutor (Long id);

}
