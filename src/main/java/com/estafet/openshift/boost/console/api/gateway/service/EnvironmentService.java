package com.estafet.openshift.boost.console.api.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;
import com.estafet.openshift.boost.console.api.gateway.model.BuildEnv;
import com.estafet.openshift.boost.console.api.gateway.model.ProdEnv;
import com.estafet.openshift.boost.console.api.gateway.model.TestEnv;
import com.estafet.openshift.boost.console.api.gateway.util.ENV;

@Service
public class EnvironmentService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StateService stateService;

	public EnvironmentDTO doAction(String env, String action) {
		if (env.equals("build")) {
			if (action.equals("build")) {
				return restTemplate.postForObject(ENV.BUILD_SERVICE_API + "/build/apps", null, BuildEnv.class)
						.getEnvironmentDTO(stateService.getState(env));
			} else if (action.equals("promote")) {
				return restTemplate.postForObject(ENV.BUILD_SERVICE_API + "/release/apps", null, BuildEnv.class)
						.getEnvironmentDTO(stateService.getState(env));
			} 
		} else if (env.equals("test")) {
			if (action.equals("test")) {
				return restTemplate.postForObject(ENV.TEST_SERVICE_API + "/tests", null, TestEnv.class)
						.getEnvironmentDTO(stateService.getState(env));
			} else if (action.equals("promote")) {
				return restTemplate.postForObject(ENV.TEST_SERVICE_API + "/promote/apps", null, TestEnv.class)
						.getEnvironmentDTO(stateService.getState(env));
			} 
		} else if (env.equals("blue") || env.equals("green")) {
			if (action.equals("test")) {
				return restTemplate.postForObject(ENV.PROD_SERVICE_API + "/tests", null, ProdEnv.class)
						.getEnvironmentDTO(stateService.getState(env));
			} else if (action.equals("go-live") || action.equals("back-out")) {
				return restTemplate.postForObject(ENV.PROD_SERVICE_API + "/promoteToLive", null, ProdEnv.class)
						.getEnvironmentDTO(stateService.getState(env));
			}
		}
		throw new RuntimeException("Unknown action " + action + " for environment " + env);
	}

}
