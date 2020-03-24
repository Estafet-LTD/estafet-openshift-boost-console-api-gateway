package com.estafet.openshift.boost.console.api.gateway.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;
import com.estafet.openshift.boost.console.api.gateway.model.EnvState;
import com.estafet.openshift.boost.messages.environments.Environment;

public class BaseService {

	private static final Logger log = LoggerFactory.getLogger(BaseService.class);
	
	protected boolean testAction(Environment environment) {
		if (environment.getName().equals("build")) {
			return false;
		} else if (environment.getName().equals("green") || environment.getName().equals("blue")) {
			return !environment.getLive();
		} else {
			return true;
		}
	}

	protected boolean promoteAction(Environment environment) {
		if (environment.getName().equals("build") || environment.getName().equals("green") || environment.getName().equals("blue")) {
			return false;
		} else {
			return environment.getTested();
		}
	}

	protected boolean buildAction(Environment environment) {
		return environment.getName().equals("build");
	}

	protected boolean goLiveAction(Environment environment) {
		if (environment.getName().equals("green") || environment.getName().equals("blue")) {
			return environment.getLive() ? true : false; 
		} else {
			return false;
		}
	}

	protected boolean backOutAction(Environment environment) {
		if (environment.getName().equals("green") || environment.getName().equals("blue")) {
			return environment.getLive() ? false : true; 
		} else {
			return false;
		}
	}

	protected String indicatorColour(Environment environment) {
		if (environment.getName().equals("green") || environment.getName().equals("blue")) {
			return environment.getName();
		} else {
			return "black";
		}
	}

	protected EnvironmentDTO convertToDTO(Map<String, EnvState> states, Environment environment) {
		log.info(environment.toString());
		log.info(states.toString());
		return EnvironmentDTO.builder()
				.setName(environment.getName())
				.setEnvState(states.get(environment.getName()))
				.setDisplayName(environment.getDisplayName())
				.setIndicatorColour(indicatorColour(environment))
				.setBackOutAction(backOutAction(environment))
				.setGoLiveAction(goLiveAction(environment))
				.setBuildAction(buildAction(environment))
				.setPromoteAction(promoteAction(environment))
				.setTestAction(testAction(environment))
				.setUpdatedDate(environment.getUpdatedDate())
				.build();
	}

}