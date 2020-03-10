package com.estafet.openshift.boost.console.api.gateway.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;
import com.estafet.openshift.boost.console.api.gateway.dto.MicroserviceActionResponseDTO;
import com.estafet.openshift.boost.console.api.gateway.model.BuildEnv;
import com.estafet.openshift.boost.console.api.gateway.model.ProdEnv;
import com.estafet.openshift.boost.console.api.gateway.model.TestEnv;
import com.estafet.openshift.boost.console.api.gateway.util.ENV;

@Service
public class MicroserviceService {

	@Autowired
	private RestTemplate restTemplate;

	public List<EnvironmentDTO> getMicroserviceEnvironments() {
		List<EnvironmentDTO> response = new ArrayList<EnvironmentDTO>();
		response.add(getBuildEnv().getEnvironmentDTO());
		response.add(getTestEnv().getEnvironmentDTO());
		ProdEnv blue = getBlueEnv();
		ProdEnv green = getGreenEnv();
		response.add(!blue.isLive() ? blue.getEnvironmentDTO() : green.getEnvironmentDTO());
		response.add(blue.isLive() ? blue.getEnvironmentDTO() : green.getEnvironmentDTO());
		return response;
	}

	private BuildEnv getBuildEnv() {
		return restTemplate.getForObject(ENV.BUILD_SERVICE_API() + "/environment", BuildEnv.class);
	}

	private TestEnv getTestEnv() {
		return restTemplate.getForObject(ENV.TEST_SERVICE_API() + "/environment", TestEnv.class);
	}

	private ProdEnv getBlueEnv() {
		return restTemplate.getForObject(ENV.PROD_SERVICE_API() + "/environment/blue", ProdEnv.class);
	}

	private ProdEnv getGreenEnv() {
		return restTemplate.getForObject(ENV.PROD_SERVICE_API() + "/environment/green", ProdEnv.class);
	}

	public MicroserviceActionResponseDTO doAction(String env, String app, String action) {
		// TODO Auto-generated method stub
		return null;
	}

}
