package com.jav.firstapi.validators;

import org.springframework.stereotype.Service;

import com.jav.firstapi.dto.UserRequest;
import com.jav.firstapi.utils.exceptions.ApiUnProcessableEntity;

/**
 * Interface de validación de datos recividos para la creación de usuarios
 * @author: Jhonatan alzate
 */


@Service
public interface UsersValidator {

	void validator(UserRequest request) throws ApiUnProcessableEntity;
	
}
