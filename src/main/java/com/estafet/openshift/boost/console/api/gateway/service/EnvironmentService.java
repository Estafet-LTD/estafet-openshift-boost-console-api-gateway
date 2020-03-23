package com.estafet.openshift.boost.console.api.gateway.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;
import com.estafet.openshift.boost.console.api.gateway.model.EnvState;
import com.estafet.openshift.boost.console.api.gateway.util.ENV;
import com.estafet.openshift.boost.messages.environments.Environment;

@Service
public class EnvironmentService extends BaseService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StateService stateService;

	public EnvironmentDTO doAction(String env, String action) {
		Environment environment = restTemplate.postForObject(ENV.ENVIRONMENT_SERVICE_API + 
				"/environment/"	+ env + "/" + action, null, Environment.class);
		Map<String, EnvState> states = stateService.getStates();
		return convertToDTO(states, environment);
	}

}
