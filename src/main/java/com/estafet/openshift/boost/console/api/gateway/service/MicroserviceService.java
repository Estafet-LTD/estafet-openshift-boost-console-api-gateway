package com.estafet.openshift.boost.console.api.gateway.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;
import com.estafet.openshift.boost.console.api.gateway.dto.MicroserviceDTO;
import com.estafet.openshift.boost.console.api.gateway.model.AppState;
import com.estafet.openshift.boost.console.api.gateway.model.EnvState;
import com.estafet.openshift.boost.console.api.gateway.model.State;
import com.estafet.openshift.boost.console.api.gateway.util.ENV;
import com.estafet.openshift.boost.messages.environments.Environment;
import com.estafet.openshift.boost.messages.environments.EnvironmentApp;

@Service
public class MicroserviceService extends BaseService {

	private static final Logger log = LoggerFactory.getLogger(MicroserviceService.class);
	
	@Autowired RestTemplate restTemplate;
	
	@Autowired
	private StateService stateService;

	public List<EnvironmentDTO> getMicroserviceEnvironments() {
		Map<String, EnvState> states = stateService.getStates();
		List<EnvironmentDTO> response = new ArrayList<EnvironmentDTO>();
		for (Environment environment : getEnvs()) {
			EnvironmentDTO env = convertToDTO(states, environment);
			for (EnvironmentApp app : environment.getApps()) {
				AppState appState = states.get(environment.getName()).appState(app.getName());
				env.addMicroservice(convertToDTO(environment, appState, app));
			}
			response.add(env);
		}
		return response;
	}

	private Boolean msTested(Environment env, EnvironmentApp app, AppState appState) {
		if (env.getName().equals("build")) {
			return testStatus(appState);
		} else {
			return null;	
		}
	}

	public boolean testStatus(AppState appState) {
		return appState.getBuild() != State.FAILED && appState.getBuild() != State.CANCELLED;
	}

	private boolean msPromoteAction(Environment env, EnvironmentApp app, AppState appState) {
		if (env.getName().equals("build")) {
			return testStatus(appState);
		} else if (env.getName().equals("green") || env.getName().equals("blue")) {
			return false;
		} else {
			return env.getTested();
		}
	}

	private boolean msBuildAction(Environment env) {
		return env.getName().equals("build");
	}
	
	private Environment[] getEnvs() {
		return restTemplate.getForObject(ENV.ENVIRONMENT_SERVICE_API + "/microservices", Environment[].class);
	}

	public MicroserviceDTO doAction(String env, String app, String action) {
		Environment environment = restTemplate.postForObject(ENV.ENVIRONMENT_SERVICE_API + 
				"/environment/"	+ env + "/app/" + app +"/" + action, 
				null, Environment.class);
		AppState appState = stateService.getState(env).appState(app);
		EnvironmentApp environmentApp = environment.getEnvironmentApp(app);
		return convertToDTO(environment, appState, environmentApp);
	}

	private MicroserviceDTO convertToDTO(Environment environment, AppState appState, EnvironmentApp environmentApp) {
		log.info(environment.toString());
		log.info(appState.toString());
		log.info(environmentApp.toString());
		return MicroserviceDTO.builder()
				.setAppState(appState)
				.setBuildAction(msBuildAction(environment))
				.setDeployed(environmentApp.isDeployed())
				.setDeployedDate(environmentApp.getDeployedDate())
				.setName(environmentApp.getName())
				.setPromoteAction(msPromoteAction(environment, environmentApp, appState))
				.setTested(msTested(environment, environmentApp, appState))
				.setVersion(environmentApp.getVersion())
				.build();
	}
}
