package com.estafet.boostcd.gateway.api.util;

public final class ENV {

	private ENV( ) {}
		
	public static final String ENVIRONMENT_SERVICE_API = System.getenv("ENVIRONMENT_API_SERVICE_URI");
	public static final String FEATURE_SERVICE_API = System.getenv("FEATURE_API_SERVICE_URI");
	public static final String JENKINS_SERVICE_API = System.getenv("JENKINS_API_SERVICE_URI");
	public static final String USER_SERVICE_API = System.getenv("USER_API_SERVICE_URI");
	public static final String PROJECT_SERVICE_API = System.getenv("PROJECT_API_SERVICE_URI");
	public static final String TRELLO_SERVICE_API = System.getenv("TRELLO_API_SERVICE_URI");



}
