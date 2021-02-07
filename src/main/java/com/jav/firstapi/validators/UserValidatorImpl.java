package com.jav.firstapi.validators;

import org.springframework.stereotype.Component;

import com.jav.firstapi.dto.UserRequest;
import com.jav.firstapi.utils.exceptions.ApiUnProcessableEntity;

@Component
public class UserValidatorImpl implements UsersValidator {

	@Override
	public void validator(UserRequest request) throws ApiUnProcessableEntity {
		
		if(request.getFirstname() == null || request.getFirstname().isEmpty() ) {
			message("El nombre es obligatorio");
		}
		
		if(request.getFirstname().length() < 3 ) {
			message("El nombre es muy corto debe tener minimo 3 caracteres");
		}
		
		if(request.getLastname() == null || request.getLastname().isEmpty() ) {
			message("El apellido es obligatorio");
		}
		
		if(request.getLastname().length() < 3 ) {
			message("El apellido es muy corto debe tener minimo 3 caracteres");
		}
		
		if(request.getUsername() == null || request.getUsername().isEmpty() ) {
			message("El nombre de usuario es obligatorio");
		}
		
		if(request.getUsername().length() < 3 ) {
			message("El nombre de usuario es muy corto debe tener minimo 3 caracteres");
		}
		
		if(request.getPassword() == null || request.getPassword().isEmpty() ) {
			message("La contraseña es obligatorio");
		}
		
		if(request.getPassword().length() < 6 ) {
			message("La contaseña es muy corta debe tener minimo 6 caracteres");
		}
		
	}
	

	
	private void message(String message) throws ApiUnProcessableEntity {
		throw new ApiUnProcessableEntity(message);
	}

}
