package com.prueba.tecnica.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.prueba.tecnica.dto.Error;
import com.prueba.tecnica.exception.EntityServiceException;


@Service
public class ErrorLibrosService {
	
	public Error getError(Exception e) {

		if (e instanceof EntityServiceException) {
			return new Error("ManejoException", ((EntityServiceException) e).getCausaError(),
					((EntityServiceException) e).getStatus());
		}

		Map<String, String> params = new HashMap<>();
		params.put("Exception", e.getClass() + "-" + e.getMessage());
		params.put("Time", LocalDateTime.now().toString());

		return new Error("ManejoException", "Unknown Error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
