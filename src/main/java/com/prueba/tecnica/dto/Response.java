package com.prueba.tecnica.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class Response {

	private final String code;
	private final String description;

	public Response(String code, String description) {

		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}
