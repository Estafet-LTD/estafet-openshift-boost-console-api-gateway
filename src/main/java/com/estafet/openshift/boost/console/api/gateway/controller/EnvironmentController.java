package com.estafet.openshift.boost.console.api.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;
import com.estafet.openshift.boost.console.api.gateway.service.EnvironmentService;

@RestController
public class EnvironmentController {

	@Autowired
	private EnvironmentService environmentService;

	@PostMapping("/environment/{env}/{action}")
	public ResponseEntity<EnvironmentDTO> doAction(@PathVariable String env,
			@PathVariable String action) {
		return new ResponseEntity<EnvironmentDTO>(environmentService.doAction(env, action),
				HttpStatus.OK);
	}

}
