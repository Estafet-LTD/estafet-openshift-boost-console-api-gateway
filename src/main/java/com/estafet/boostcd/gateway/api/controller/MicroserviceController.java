package com.estafet.boostcd.gateway.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estafet.boostcd.gateway.api.dto.EnvironmentDTO;
import com.estafet.boostcd.gateway.api.dto.MicroserviceDTO;
import com.estafet.boostcd.gateway.api.service.MicroserviceService;

@RestController
public class MicroserviceController {

	@Autowired
	private MicroserviceService microserviceService;

	@GetMapping("/microservices/{product}")
	public List<EnvironmentDTO> getMicroserviceEnvironments(@PathVariable String product) {
		return microserviceService.getMicroserviceEnvironments(product);
	}
	
	@GetMapping("/environment/{product}/{env}/app/{app}")
	public MicroserviceDTO getMicroservice(@PathVariable String product, @PathVariable String env, @PathVariable String app) {
		return microserviceService.getMicroservice(product, env, app);
	}

	@PostMapping("/environment/{product}/{env}/app/{app}/{action}")
	public ResponseEntity<MicroserviceDTO> doAction(@PathVariable String product, @PathVariable String env, @PathVariable String app,
			@PathVariable String action) {
		return new ResponseEntity<MicroserviceDTO>(microserviceService.doAction(product, env, app, action),
				HttpStatus.OK);
	}

}
