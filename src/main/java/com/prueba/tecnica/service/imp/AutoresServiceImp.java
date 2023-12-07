package com.prueba.tecnica.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.tecnica.entities.Autores;
import com.prueba.tecnica.entities.AutoresPK;
import com.prueba.tecnica.dto.AutoresDTO;
import com.prueba.tecnica.dto.AutoresDTOList;
import com.prueba.tecnica.dto.Response;
import com.prueba.tecnica.exception.EntityServiceException;
import com.prueba.tecnica.repository.AutoresRepository;
import com.prueba.tecnica.service.AutoresService;

import fj.data.Either;

@Service
public class AutoresServiceImp implements AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	@Override
	public Either<Exception, Response> crearAutor (AutoresDTO autoresDTO) {
		try {
			Response response;
			if (null == autoresDTO.getId() || null == autoresDTO.getNombre()
					|| null == autoresDTO.getNacionalidad() || null == autoresDTO.getLibros()) {
				return Either.left(new EntityServiceException(
						"Los campos id, nombre, descripcion nacionalidad y libros son Mandatorios",
						HttpStatus.BAD_REQUEST));
			}

			AutoresPK autoresPK = new AutoresPK();
			autoresPK.setId(autoresDTO.getId());

			Optional<Autores> autoresPersistence = autoresRepository.findById(autoresPK);

			ObjectMapper mapper = new ObjectMapper();
			Autores autores = mapper.convertValue(autoresDTO, new TypeReference<Autores>() {
			});
			autoresRepository.save(autores);

			if (autoresPersistence.isPresent()) {
				response = new Response("200", "Autor actualizado exitosamente");
			} else {
				response = new Response("200", "Autor creado Exitosamente");
			}

			return Either.right(response);
		} catch (Exception e) {
			return Either.left(new Exception("No se pudo crear el Equipo"));
		}
	}
	
	@Override
	public Either<Exception, AutoresDTOList> buscarAutor(Long id) {
		try {
			if (null == id) {
				return Either.left(new EntityServiceException(
						"El parametro id es mandatorio", HttpStatus.BAD_REQUEST));
			}

			AutoresPK autoresPK = new AutoresPK();
			autoresPK.setId(id);

			Optional<Autores> autorPersistence = autoresRepository.findById(autoresPK);

			if (autorPersistence.isPresent()) {
				ObjectMapper mapper = new ObjectMapper();
				AutoresDTOList autoresDto = mapper.convertValue(autorPersistence.get(), new TypeReference<AutoresDTOList>() {
				});				
				return Either.right(autoresDto);
			} else {
				return Either.left(new EntityServiceException("autor no encontrado con el parametro enviado",
						HttpStatus.BAD_REQUEST));
			}

		} catch (Exception e) {
			return Either.left(new Exception("No se pudo crear el Jugador"));
		}
	}
	
	@Override
	public Either<Exception, Response> borrarAutor (Long id) {
		try {
			Response response = null;
			if (null == id) {
				return Either.left(new EntityServiceException(
						"El parametro id es mandatorio", HttpStatus.BAD_REQUEST));
			}

			AutoresPK autoresPK = new AutoresPK();
			autoresPK.setId(id);

			Optional<Autores> autoresPersistence = autoresRepository.findById(autoresPK);

			ObjectMapper mapper = new ObjectMapper();
			Autores autores = mapper.convertValue(autoresPersistence.get(), new TypeReference<Autores>() {
			});
			autoresRepository.delete(autores);

			if (autoresPersistence.isPresent()) {
				response = new Response("200", "Autor Borrado Exitosamente");
			}

			return Either.right(response);
		} catch (Exception e) {
			return Either.left(new Exception("No se pudo borrar el Autor"));
		}
	}

}
