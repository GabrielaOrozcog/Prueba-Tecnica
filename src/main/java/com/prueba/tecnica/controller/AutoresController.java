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

import com.prueba.tecnica.dto.Error;
import com.prueba.tecnica.dto.AutoresDTO;
import com.prueba.tecnica.dto.AutoresDTOList;
import com.prueba.tecnica.dto.Response;
import com.prueba.tecnica.service.ErrorAutoresService;
import com.prueba.tecnica.service.AutoresService;

import fj.data.Either;

@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@RequestMapping(path = "${controller.properties.base-path}")
@RestController
@Controller
public class AutoresController {
	
	@Autowired
	private ErrorAutoresService errorAutoresService;

	@Autowired
	private AutoresService autoresService;
	
	@PostMapping(value = "/crearAutor")
	public ResponseEntity<?> crearAutor (@RequestBody AutoresDTO autoresDTO) {

		Either<Exception, Response> resultEither = autoresService.crearAutor(autoresDTO);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorAutoresService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, error.getStatus());
	}
	
	@GetMapping(value = "/buscarAutor")
	public ResponseEntity<?> buscarAutor (@RequestParam(value = "id", required = true) Long id) {

		Either<Exception, AutoresDTOList> resultEither = autoresService.buscarAutor(id);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorAutoresService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, error.getStatus());
	}
	
	@PostMapping(value = "/borrarAutor")
	public ResponseEntity<?> borrarAutor (@RequestParam(value = "id", required = true) Long id) {

		Either<Exception, Response> resultEither = autoresService.borrarAutor(id);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorAutoresService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, error.getStatus());
	}
}
