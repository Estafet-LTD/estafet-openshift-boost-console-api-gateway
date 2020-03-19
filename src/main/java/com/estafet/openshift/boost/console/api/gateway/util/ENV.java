package com.estafet.openshift.boost.console.api.gateway.util;

public final class ENV {

	private ENV( ) {}
		
	public static final String TEST_SERVICE_API = System.getenv("TEST_API_SERVICE_URI");
	public static final String BUILD_SERVICE_API = System.getenv("BUILD_API_SERVICE_URI");
	public static final String PROD_SERVICE_API = System.getenv("PROD_API_SERVICE_URI");
	public static final String FEATURE_SERVICE_API = System.getenv("FEATURE_API_SERVICE_URI");
	public static final String JENKINS_SERVICE_API = System.getenv("JENKINS_API_SERVICE_URI");
	public static final String USER_SERVICE_API = System.getenv("USER_API_SERVICE_URI");

}
