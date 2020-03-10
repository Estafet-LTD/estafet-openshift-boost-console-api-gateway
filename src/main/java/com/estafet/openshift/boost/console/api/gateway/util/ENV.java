package com.estafet.openshift.boost.console.api.gateway.util;

public final class ENV {

	private ENV( ) {}
		
	public static final String getTestServiceAPI() {
		return System.getenv("TEST_API_SERVICE_URI");
	}

	public static final String getBuildServiceAPI() {
		return System.getenv("BUILD_API_SERVICE_URI");
	}
	
	public static final String getProdServiceAPI() {
		return System.getenv("PROD_API_SERVICE_URI");
	}

}
