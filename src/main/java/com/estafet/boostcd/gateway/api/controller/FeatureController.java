package com.estafet.boostcd.gateway.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.estafet.boostcd.gateway.api.dto.EnvironmentDTO;
import com.estafet.boostcd.gateway.api.service.FeatureService;

@RestController
public class FeatureController {

	@Autowired
	private FeatureService featureService;
	
	@GetMapping("/features/{product}")
	public List<EnvironmentDTO> getFeatureEnvironments(@PathVariable String product) {
		return featureService.getFeatureEnvironments(product);
	}
	
}
