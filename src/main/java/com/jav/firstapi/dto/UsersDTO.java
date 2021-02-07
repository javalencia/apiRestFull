package com.jav.firstapi.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Data;


@Data


public class UsersDTO implements Serializable {
	
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private Date createdAt;
	private Date updatedAt;
	
}
