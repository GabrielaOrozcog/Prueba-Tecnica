package com.prueba.tecnica.service;

import org.springframework.stereotype.Service;

import com.prueba.tecnica.dto.LibrosDTO;
import com.prueba.tecnica.dto.LibrosDTOList;
import com.prueba.tecnica.dto.Response;

import fj.data.Either;

@Service
public interface LibrosService {
	
	Either<Exception, Response> crearLibro (LibrosDTO equipoDTO);
	
	Either<Exception, LibrosDTOList> buscarLibro (Long id);
	
	Either<Exception, Response> borrarLibro (Long id);

}
