package com.estafet.boostcd.gateway.api.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.boostcd.gateway.api.model.EnvState;
import com.estafet.boostcd.gateway.api.util.ENV;

@Service
public class StateService {

	@Autowired
	private RestTemplate restTemplate;

	public Map<String, EnvState> getStates(String productId) {
		EnvState[] states = restTemplate.getForObject(ENV.JENKINS_SERVICE_API + "/states/" + productId, EnvState[].class);
		Map<String, EnvState> map = new HashMap<String, EnvState>();
		for (EnvState envState : states) {
			map.put(envState.getName(), envState);
		}
		return map;
	}
	
	public EnvState getState(String productId, String env) {
		return restTemplate.getForObject(ENV.JENKINS_SERVICE_API + "/state/" + productId + "/" + env, EnvState.class);
	}
	
}
