package com.estafet.openshift.boost.console.api.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;
import com.estafet.openshift.boost.console.api.gateway.dto.UserDTO;
import com.estafet.openshift.boost.console.api.gateway.service.FeatureService;
import com.estafet.openshift.boost.console.api.gateway.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/features")
	public List<UserDTO> getUsers() {
		return userService.getUsers();
	}
	
}
