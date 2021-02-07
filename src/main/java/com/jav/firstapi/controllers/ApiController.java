package com.jav.firstapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jav.firstapi.dto.UserRequest;
import com.jav.firstapi.dto.UsersDTO;
import com.jav.firstapi.services.interfaces.IUsersService;
import com.jav.firstapi.utils.exceptions.ApiUnProcessableEntity;
import com.jav.firstapi.validators.UserValidatorImpl;


@CrossOrigin("*")
@RequestMapping("/users")
@RestController()
public class ApiController {

	@Autowired
	private IUsersService usersService;

	@Autowired
	private UserValidatorImpl userValidator;
	
	@GetMapping(value = "/all", produces = "application/json")
	public ResponseEntity<Object> Index(){
		
		return ResponseEntity.ok(this.usersService.findAll());
	}
	
	@GetMapping(value = "/by/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findByUsername(@PathVariable("username") String username){
		
		UsersDTO user = this.usersService.findByUsername(username);
		
		return ResponseEntity.ok(user);
	}
	
	@PostMapping( value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveUser(@RequestBody UserRequest request) throws ApiUnProcessableEntity{
		
		this.userValidator.validator(request);
		this.usersService.save(request);
		 
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
	
	@DeleteMapping(value = "/{userId}/delete")
	public ResponseEntity<Object> deleteUser (@PathVariable int userId) {
		
		this.usersService.deleteById(userId);
		
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
	@PutMapping( value = "/{userId}/update")
	public ResponseEntity<Object> updateUser(@RequestBody UserRequest request,@PathVariable int userId) throws ApiUnProcessableEntity{
		
		this.usersService.update(request, userId);
		 
		return ResponseEntity.ok(Boolean.TRUE);
	}
	 
}
