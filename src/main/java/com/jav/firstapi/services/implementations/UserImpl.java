package com.jav.firstapi.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jav.firstapi.dto.UserRequest;
import com.jav.firstapi.dto.UsersDTO;
import com.jav.firstapi.entities.Users;
import com.jav.firstapi.repository.UsersRepository;
import com.jav.firstapi.services.interfaces.IUsersService;
import com.jav.firstapi.utils.hash.BCrypt;
import com.jav.firstapi.utils.helpers.MHelpers;


@Component
public class UserImpl implements IUsersService {

	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public List<UsersDTO> findAll() {
		
		List<UsersDTO> dto = new ArrayList<>();
		
		Iterable<Users> users = this.usersRepository.findAll();
		
		for(Users user : users) {
			
			UsersDTO usersDTO = MHelpers.modelMaper().map(user, UsersDTO.class);
			
			dto.add( usersDTO );
		}
		
		return dto;
	}

	@Override
	public UsersDTO findByUsername(String username) {
		
		Optional<Users> users = this.usersRepository.findByUsername(username);
		
		if ( !users.isPresent()) {
			return null;
		}
		
		return MHelpers.modelMaper().map(users.get(), UsersDTO.class);
	}

	@Override
	public UsersDTO findByUserId(int userId) {
		
		Optional<Users> users = this.usersRepository.findById(userId);
		
		if ( !users.isPresent()) {
			return null;
		}
		
		return MHelpers.modelMaper().map(users.get(), UsersDTO.class);
		
	}

	@Override
	public void save(UserRequest user) {
		
		Users users = MHelpers.modelMaper().map(user, Users.class);
		
		users.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		
		this.usersRepository.save(users);
		
	}

	@Override
	public void saveAll(List<UserRequest> users) {
		
		List<Users> u = new ArrayList<>();
		
		for(UserRequest user :  users) {
			
			Users us = MHelpers.modelMaper().map(user, Users.class);
			
		}
		
		this.usersRepository.saveAll(u);
		
	}

	@Override
	public void deleteById(int userId) {
		
		this.usersRepository.deleteById(userId);
		
	}
	
	@Override
	public void update(UserRequest request, int userId) {
		
		Optional<Users> users = this.usersRepository.findById(userId);
		
		Users user = users.get();
		
		user.setFirstname(request.getFirstname());
		user.setLastname(request.getLastname());
		user.setUsername(request.getUsername());
		
		if( !request.getPassword().isEmpty() ) {
			
			user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
		}
		
		this.usersRepository.save(user);
	}
	
	private UsersDTO convertToUsersDTO(final Users users) {
		return MHelpers.modelMaper().map(users, UsersDTO.class);
	}

}
