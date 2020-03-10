package com.estafet.openshift.boost.console.api.gateway.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;
import com.estafet.openshift.boost.console.api.gateway.model.FeatureEnv;
import com.estafet.openshift.boost.console.api.gateway.util.ENV;

@Service
public class FeatureService {

	@Autowired
	private RestTemplate restTemplate;

	public List<EnvironmentDTO> getFeatureEnvironments() {
		List<EnvironmentDTO> response = new ArrayList<EnvironmentDTO>();
		response.add(getFeatureEnv("build").getEnvironmentDTO());
		response.add(getFeatureEnv("test").getEnvironmentDTO());
		FeatureEnv blue = getFeatureEnv("blue");
		FeatureEnv green = getFeatureEnv("green");
		response.add(!blue.isLive() ? blue.getEnvironmentDTO() : green.getEnvironmentDTO());
		response.add(blue.isLive() ? blue.getEnvironmentDTO() : green.getEnvironmentDTO());
		return response;
	}

	private FeatureEnv getFeatureEnv(String env) {
		return restTemplate.getForObject(ENV.getBuildServiceAPI() + "/environment/" + env, FeatureEnv.class);
	}

}
