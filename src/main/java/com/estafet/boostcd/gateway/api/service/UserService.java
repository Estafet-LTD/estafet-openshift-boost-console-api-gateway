package com.estafet.boostcd.gateway.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.boostcd.gateway.api.dto.UserDTO;
import com.estafet.boostcd.gateway.api.util.ENV;
import com.estafet.openshift.boost.messages.users.User;

@Service
public class UserService {

	@Autowired
	private RestTemplate restTemplate;


	public List<UserDTO> getUsers() {
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();;
		User[] users = restTemplate.getForObject(ENV.USER_SERVICE_API + "/users", User[].class);
		for (User user : users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setName(user.getName());
			usersDTO.add(userDTO);
		}
		return usersDTO;
	}
			
	
}
