package com.prueba.tecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.tecnica.dto.LibrosDTO;
import com.prueba.tecnica.dto.LibrosDTOList;
import com.prueba.tecnica.dto.Error;
import com.prueba.tecnica.dto.Response;
import com.prueba.tecnica.service.LibrosService;
import com.prueba.tecnica.service.ErrorLibrosService;

import fj.data.Either;

@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@RequestMapping(path = "${controller.properties.base-path}")
@RestController
@Controller
public class LibrosController {
	
	@Autowired
	private ErrorLibrosService errorLibrosService;

	@Autowired
	private LibrosService librosService;
	
	@PostMapping(value = "/crearLibro")
	public ResponseEntity<?> crearLibro (@RequestBody LibrosDTO librosDTO) {

		Either<Exception, Response> resultEither = librosService.crearLibro(librosDTO);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorLibrosService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, error.getStatus());
	}
	
	@GetMapping(value = "/buscarLibro")
	public ResponseEntity<?> buscarLibro (@RequestParam(value = "id", required = true) Long id) {

		Either<Exception, LibrosDTOList> resultEither = librosService.buscarLibro(id);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorLibrosService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, error.getStatus());
	}
	
	@PostMapping(value = "/borrarLibro")
	public ResponseEntity<?> borrarEquipo (@RequestParam(value = "id", required = true) Long id) {

		Either<Exception, Response> resultEither = librosService.borrarLibro(id);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorLibrosService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, error.getStatus());
	}
}
