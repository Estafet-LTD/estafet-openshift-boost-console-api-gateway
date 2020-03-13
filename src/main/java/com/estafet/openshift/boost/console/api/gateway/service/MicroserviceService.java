package com.estafet.openshift.boost.console.api.gateway.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;
import com.estafet.openshift.boost.console.api.gateway.dto.MicroserviceDTO;
import com.estafet.openshift.boost.console.api.gateway.model.BuildApp;
import com.estafet.openshift.boost.console.api.gateway.model.BuildEnv;
import com.estafet.openshift.boost.console.api.gateway.model.EnvState;
import com.estafet.openshift.boost.console.api.gateway.model.ProdEnv;
import com.estafet.openshift.boost.console.api.gateway.model.TestApp;
import com.estafet.openshift.boost.console.api.gateway.model.TestEnv;
import com.estafet.openshift.boost.console.api.gateway.util.ENV;

@Service
public class MicroserviceService {

	@Autowired RestTemplate restTemplate;
	
	@Autowired
	private StateService stateService;

	public List<EnvironmentDTO> getMicroserviceEnvironments() {
		Map<String, EnvState> states = stateService.getStates();
		List<EnvironmentDTO> response = new ArrayList<EnvironmentDTO>();
		EnvironmentDTO buildEnvironmentDTO = getBuildEnv().getEnvironmentDTO(states.get("build"));
		EnvironmentDTO testEnvironmentDTO = getTestEnv().getEnvironmentDTO(states.get("test"));
		response.add(buildEnvironmentDTO);
		response.add(testEnvironmentDTO);
		ProdEnv blue = getBlueEnv();
		ProdEnv green = getGreenEnv();
		EnvironmentDTO blueEnvironmentDTO = blue.getEnvironmentDTO(states.get("blue"));
		EnvironmentDTO greenEnvironmentDTO = green.getEnvironmentDTO(states.get("green"));
		response.add(!blue.isLive() ? blueEnvironmentDTO : greenEnvironmentDTO);
		response.add(blue.isLive() ? blueEnvironmentDTO : greenEnvironmentDTO);
		return response;
	}
	
	private BuildEnv getBuildEnv() {
		return restTemplate.getForObject(ENV.BUILD_SERVICE_API + "/environment", BuildEnv.class);
	}

	private TestEnv getTestEnv() {
		return restTemplate.getForObject(ENV.TEST_SERVICE_API + "/environment", TestEnv.class);
	}

	private ProdEnv getBlueEnv() {
		return restTemplate.getForObject(ENV.PROD_SERVICE_API + "/environment/blue", ProdEnv.class);
	}

	private ProdEnv getGreenEnv() {
		return restTemplate.getForObject(ENV.PROD_SERVICE_API + "/environment/green", ProdEnv.class);
	}

	public MicroserviceDTO doAction(String env, String app, String action) {
		if (env.equals("build")) {
			if (action.equals("build")) {
				return restTemplate.postForObject(ENV.BUILD_SERVICE_API + "/build/app/" + app, null, BuildApp.class)
						.getMicroserviceDTO(stateService.getState(env));
			} else if (action.equals("promote")) {
				return restTemplate.postForObject(ENV.BUILD_SERVICE_API + "/release/app/" + app, null, BuildApp.class)
						.getMicroserviceDTO(stateService.getState(env));
			} 
		} else if (env.equals("test")) {
			if (action.equals("promote")) {
				return restTemplate.postForObject(ENV.TEST_SERVICE_API + "/promote/app/" + app, null, TestApp.class)
						.getMicroserviceDTO(stateService.getState(env));
			} 
		} 
		throw new RuntimeException("Unknown action " + action + " for environment " + env + " and microservice " + app);
	}

}
