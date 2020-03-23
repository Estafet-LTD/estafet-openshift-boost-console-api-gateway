package com.estafet.openshift.boost.console.api.gateway.service;

import com.estafet.openshift.boost.messages.environments.Environment;

public class BaseService {

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

}