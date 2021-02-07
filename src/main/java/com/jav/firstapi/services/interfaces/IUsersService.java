package com.jav.firstapi.services.interfaces;

import java.util.List;
import org.springframework.stereotype.Service;

import com.jav.firstapi.dto.UserRequest;
import com.jav.firstapi.dto.UsersDTO;

@Service
public interface IUsersService {
	
	List<UsersDTO> findAll();
	
	UsersDTO findByUsername(String username);
	
	UsersDTO findByUserId(int userID);
	
	void save(UserRequest user);
	
	void saveAll(List<UserRequest> users);
	
	void update(UserRequest user, int userId);
	
	void deleteById(int userId);

}
