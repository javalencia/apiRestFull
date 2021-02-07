package com.jav.firstapi.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceptions personalizada de status 404
 * @author: Jhonatan alzate
 */


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiNotFound extends Exception {

	public ApiNotFound(String message) {
		super(message);
	}
	
}
