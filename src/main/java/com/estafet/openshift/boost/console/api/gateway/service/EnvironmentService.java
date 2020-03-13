package com.estafet.openshift.boost.console.api.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentActionResponseDTO;
import com.estafet.openshift.boost.console.api.gateway.model.PipelineStatus;
import com.estafet.openshift.boost.console.api.gateway.util.ENV;

@Service
public class EnvironmentService {

	@Autowired
	private RestTemplate restTemplate;

	public EnvironmentActionResponseDTO doAction(String env, String action) {
		if (env.equals("build")) {
			if (action.equals("build")) {
				return restTemplate.postForObject(ENV.BUILD_SERVICE_API + "/build/apps", null, PipelineStatus.class)
						.getEnvironmentActionResponseDTO(env);
			} else if (action.equals("promote")) {
				return restTemplate.postForObject(ENV.BUILD_SERVICE_API + "/release/apps", null, PipelineStatus.class)
						.getEnvironmentActionResponseDTO(env);
			} 
		} else if (env.equals("test")) {
			if (action.equals("test")) {
				return restTemplate.postForObject(ENV.TEST_SERVICE_API + "/tests", null, PipelineStatus.class)
						.getEnvironmentActionResponseDTO(env);
			} else if (action.equals("promote")) {
				return restTemplate.postForObject(ENV.TEST_SERVICE_API + "/promote/apps", null, PipelineStatus.class)
						.getEnvironmentActionResponseDTO(env);
			} 
		} else if (env.equals("blue") || env.equals("green")) {
			if (action.equals("test")) {
				return restTemplate.postForObject(ENV.PROD_SERVICE_API + "/tests", null, PipelineStatus.class)
						.getEnvironmentActionResponseDTO(env);
			} else if (action.equals("go-live") || action.equals("back-out")) {
				return restTemplate.postForObject(ENV.PROD_SERVICE_API + "/promoteToLive", null, PipelineStatus.class)
						.getEnvironmentActionResponseDTO(env);
			}
		}
		throw new RuntimeException("Unknown action " + action + " for environment " + env);
	}

}
