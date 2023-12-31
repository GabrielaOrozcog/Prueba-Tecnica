package com.prueba.tecnica.exception;

import org.springframework.http.HttpStatus;

public class EntityServiceException extends Exception {
	
	private static final long serialVersionUID = -6990395161113342814L;

	private final String causaError;
	private final HttpStatus status;

	public EntityServiceException(String causaError, HttpStatus status) {
		this.causaError = causaError;
		this.status = status;
	}

	public String getCausaError() {
		return causaError;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
