package com.estafet.openshift.boost.console.api.gateway.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;
import com.estafet.openshift.boost.console.api.gateway.model.EnvState;
import com.estafet.openshift.boost.console.api.gateway.model.FeatureEnv;
import com.estafet.openshift.boost.console.api.gateway.util.ENV;

@Service
public class FeatureService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private StateService stateService;

	public List<EnvironmentDTO> getFeatureEnvironments() {
		Map<String, EnvState> states = stateService.getStates();
		List<EnvironmentDTO> response = new ArrayList<EnvironmentDTO>();
		EnvironmentDTO buildEnvironmentDTO = getFeatureEnv("build").getEnvironmentDTO(states.get("build"));
		EnvironmentDTO testEnvironmentDTO = getFeatureEnv("test").getEnvironmentDTO(states.get("test"));
		FeatureEnv blue = getFeatureEnv("blue");
		FeatureEnv green = getFeatureEnv("green");
		EnvironmentDTO blueEnvironmentDTO = blue.getEnvironmentDTO(states.get("blue"));
		EnvironmentDTO greenEnvironmentDTO = green.getEnvironmentDTO(states.get("green"));
		response.add(buildEnvironmentDTO);
		response.add(testEnvironmentDTO);
		response.add(!blue.isLive() ? blueEnvironmentDTO : greenEnvironmentDTO);
		response.add(blue.isLive() ? blueEnvironmentDTO : greenEnvironmentDTO);
		return response;
	}

	private FeatureEnv getFeatureEnv(String env) {
		return restTemplate.getForObject(ENV.FEATURE_SERVICE_API + "/environment/" + env, FeatureEnv.class);
	}

}
