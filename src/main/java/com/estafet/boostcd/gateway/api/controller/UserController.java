package com.estafet.boostcd.gateway.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estafet.boostcd.gateway.api.dto.UserDTO;
import com.estafet.boostcd.gateway.api.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		return userService.getUsers();
	}
	
}
