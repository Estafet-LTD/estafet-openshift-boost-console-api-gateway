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
		for (FeatureEnv featureEnv : getFeatureEnvs()) {
			response.add(featureEnv.getEnvironmentDTO(states.get(featureEnv.getName())));
		}
		return response;
	}

	private FeatureEnv[] getFeatureEnvs() {
		return restTemplate.getForObject(ENV.FEATURE_SERVICE_API + "/environments", FeatureEnv[].class);
	}

}
