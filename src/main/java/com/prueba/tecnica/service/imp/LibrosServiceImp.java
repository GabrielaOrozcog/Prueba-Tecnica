package com.prueba.tecnica.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.tecnica.entities.Libros;
import com.prueba.tecnica.entities.LibrosPK;
import com.prueba.tecnica.dto.LibrosDTO;
import com.prueba.tecnica.dto.LibrosDTOList;
import com.prueba.tecnica.dto.Response;
import com.prueba.tecnica.exception.EntityServiceException;
import com.prueba.tecnica.repository.LibrosRepository;
import com.prueba.tecnica.service.LibrosService;

import fj.data.Either;

@Service
public class LibrosServiceImp implements LibrosService {
	
	@Autowired
	private LibrosRepository librosRepository;
	
	@Override
	public Either<Exception, Response> crearLibro (LibrosDTO librosDTO) {
		try {
			Response response;
			if (null == librosDTO.getId() || null == librosDTO.getAutor()
					|| null == librosDTO.getGenero() || null == librosDTO.getTitulo() || null == librosDTO.getAñoPublicacion()) {
				return Either.left(new EntityServiceException(
						"Los campos id, autor, genero, titulo y año de publicacion son Mandatorios",
						HttpStatus.BAD_REQUEST));
			}

			LibrosPK librosPK = new LibrosPK();
			librosPK.setId(librosDTO.getId());

			Optional<Libros> librosPersistence = librosRepository.findById(librosPK);

			ObjectMapper mapper = new ObjectMapper();
			Libros libros = mapper.convertValue(librosDTO, new TypeReference<Libros>() {
			});
			librosRepository.save(libros);

			if (librosPersistence.isPresent()) {
				response = new Response("200", "Libro actualizado Correctamente");
			} else {
				response = new Response("200", "Libro creado Exitosamente");
			}

			return Either.right(response);
		} catch (Exception e) {
			return Either.left(new Exception("No se pudo crear el Libro"));
		}
	}
	
	@Override
	public Either<Exception, LibrosDTOList> buscarLibro(Long id) {
		try {
			if (null == id) {
				return Either.left(new EntityServiceException(
						"El parametro id es Mandatorio", HttpStatus.BAD_REQUEST));
			}

			LibrosPK librosPK = new LibrosPK();
			librosPK.setId(id);

			Optional<Libros> libroPersistence = librosRepository.findById(librosPK);

			if (libroPersistence.isPresent()) {
				ObjectMapper mapper = new ObjectMapper();
				LibrosDTOList librosDTOList = mapper.convertValue(libroPersistence.get(), new TypeReference<LibrosDTOList>() {
				});
				return Either.right(librosDTOList);
			} else {
				return Either.left(new EntityServiceException("Libro no encontrado con el parametro enviado",
						HttpStatus.BAD_REQUEST));
			}

		} catch (Exception e) {
			return Either.left(new Exception("No se encontro el Libro"));
		}
	}
	
	@Override
	public Either<Exception, Response> borrarLibro(Long id) {
		try {
			Response response = null;
			if (null == id) {
				return Either.left(new EntityServiceException(
						"El parametro id es Mandatorio", HttpStatus.BAD_REQUEST));
			}

			LibrosPK librosPK = new LibrosPK();
			librosPK.setId(id);

			Optional<Libros> libroPersistence = librosRepository.findById(librosPK);

			ObjectMapper mapper = new ObjectMapper();
			Libros libro = mapper.convertValue(libroPersistence.get(), new TypeReference<Libros>() {
			});
			librosRepository.delete(libro);

			if (libroPersistence.isPresent()) {
				response = new Response("200", "Libro Borrado Exitosamente");
			}

			return Either.right(response);
		} catch (Exception e) {
			return Either.left(new Exception("No se pudo Borrar el Libri"));
		}
	}

}
