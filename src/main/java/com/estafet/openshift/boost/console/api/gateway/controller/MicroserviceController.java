package com.estafet.openshift.boost.console.api.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estafet.openshift.boost.console.api.gateway.dto.MicroserviceActionResponseDTO;
import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;
import com.estafet.openshift.boost.console.api.gateway.service.MicroserviceService;

@RestController
public class MicroserviceController {

	@Autowired
	private MicroserviceService microserviceService;

	@GetMapping("/microservices")
	public List<EnvironmentDTO> getMicroserviceEnvironments() {
		return microserviceService.getMicroserviceEnvironments();
	}

	@PostMapping("/environment/{env}/app/{app}/{action}")
	public ResponseEntity<MicroserviceActionResponseDTO> doAction(@PathVariable String env, @PathVariable String app,
			@PathVariable String action) {
		return new ResponseEntity<MicroserviceActionResponseDTO>(microserviceService.doAction(env, app, action),
				HttpStatus.OK);
	}

}
