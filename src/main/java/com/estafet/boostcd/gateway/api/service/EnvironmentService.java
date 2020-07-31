package com.estafet.boostcd.gateway.api.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.boostcd.gateway.api.dto.EnvironmentDTO;
import com.estafet.boostcd.gateway.api.model.EnvState;
import com.estafet.boostcd.gateway.api.util.ENV;
import com.estafet.openshift.boost.messages.environments.Environment;

@Service
public class EnvironmentService extends BaseService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StateService stateService;

	public EnvironmentDTO doAction(String productId, String env, String action) {
		Environment environment = restTemplate.postForObject(ENV.ENVIRONMENT_SERVICE_API + 
				"/environment/" + productId + "/" + env + "/" + action, null, Environment.class);
		Map<String, EnvState> states = stateService.getStates(productId);
		return convertToDTO(states, environment);
	}

}
