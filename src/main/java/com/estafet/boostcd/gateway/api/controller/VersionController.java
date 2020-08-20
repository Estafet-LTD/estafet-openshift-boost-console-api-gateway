package com.estafet.boostcd.gateway.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estafet.boostcd.gateway.api.model.Version;
import com.estafet.boostcd.gateway.api.service.VersionService;

@RestController
public class VersionController {

	@Autowired
	private VersionService versionService;

	@GetMapping("/version")
	public Version getVersion() {
		return versionService.getVersion();
	}

}
