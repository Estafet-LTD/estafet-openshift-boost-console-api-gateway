package com.estafet.boostcd.gateway.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estafet.boostcd.gateway.api.dto.EnvironmentDTO;
import com.estafet.boostcd.gateway.api.service.FeatureService;

@RestController
public class FeatureController {

	@Autowired
	private FeatureService featureService;
	
	@GetMapping("/features")
	public List<EnvironmentDTO> getFeatureEnvironments() {
		return featureService.getFeatureEnvironments();
	}
	
}
