package com.estafet.openshift.boost.console.api.gateway.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.estafet.openshift.boost.console.api.gateway.model.EnvState;
import com.estafet.openshift.boost.console.api.gateway.util.ENV;

public class StateService {

	@Autowired
	private RestTemplate restTemplate;

	public Map<String, EnvState> getStates() {
		EnvState[] states = restTemplate.getForObject(ENV.JENKINS_SERVICE_API + "/states", EnvState[].class);
		Map<String, EnvState> map = new HashMap<String, EnvState>();
		for (EnvState envState : states) {
			map.put(envState.getName(), envState);
		}
		return map;
	}
	
}
