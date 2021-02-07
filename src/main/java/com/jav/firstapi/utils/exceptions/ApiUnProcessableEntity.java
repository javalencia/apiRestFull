package com.jav.firstapi.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Exceptions personalizada de status 422
 * @author: Jhonatan alzate
 */

 
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnProcessableEntity extends Exception {

	public ApiUnProcessableEntity(String message) {
		super(message);
	}
	
}
