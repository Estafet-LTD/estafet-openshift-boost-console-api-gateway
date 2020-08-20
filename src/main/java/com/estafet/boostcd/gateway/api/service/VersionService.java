package com.estafet.boostcd.gateway.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.estafet.boostcd.gateway.api.model.Version;
import com.estafet.boostcd.gateway.api.util.ENV;

@Component
public class VersionService {

	@Autowired
	private RestTemplate restTemplate;

	public Version getVersion() {
		return restTemplate.getForObject(ENV.ENVIRONMENT_SERVICE_API + "/version", Version.class);
	}

}
