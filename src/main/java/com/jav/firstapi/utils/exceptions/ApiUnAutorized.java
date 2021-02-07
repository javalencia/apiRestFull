package com.jav.firstapi.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceptions personalizada de status 401
 * @author: Jhonatan alzate
 */


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiUnAutorized extends Exception {

	public ApiUnAutorized (String message) {
		super(message);
	}
}
