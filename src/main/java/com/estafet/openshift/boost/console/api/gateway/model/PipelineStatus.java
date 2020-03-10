package com.estafet.openshift.boost.console.api.gateway.model;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentActionResponseDTO;
import com.estafet.openshift.boost.console.api.gateway.dto.MicroserviceActionResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class PipelineStatus {

	private String name;
	private String startTime;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	@JsonIgnore
	public EnvironmentActionResponseDTO getEnvironmentActionResponseDTO(String env) {
		return EnvironmentActionResponseDTO.builder()
				.setEnvironment(env)
				.setStatus("success")
				.build();
	}

	public MicroserviceActionResponseDTO getMicroserviceActionResponseDTO(String env, String app) {
		return MicroserviceActionResponseDTO.builder()
				.setEnvironment(env)
				.setMicroservice(app)
				.setStatus("success")
				.build();
	}

}
