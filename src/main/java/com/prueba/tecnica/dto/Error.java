package com.prueba.tecnica.dto;

import org.springframework.http.HttpStatus;

public class Error {

	private final String code;
	private final String description;
	private final HttpStatus status;

	public Error(String code, String description, HttpStatus status) {

		this.code = code;
		this.description = description;
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
