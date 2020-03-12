package com.estafet.openshift.boost.console.api.gateway.model;

import java.util.ArrayList;
import java.util.List;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BuildEnv {

	private String name;
	private String updatedDate;
	private List<BuildApp> buildApps = new ArrayList<BuildApp>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<BuildApp> getBuildApps() {
		return buildApps;
	}

	public void setBuildApps(List<BuildApp> buildApps) {
		this.buildApps = buildApps;
	}
	
	@JsonIgnore
	public EnvironmentDTO getEnvironmentDTO(EnvState envState) {
		EnvironmentDTO dto = EnvironmentDTO.builder()
				.setBackOutAction(false)
				.setBuildAction(true)
				.setGoLiveAction(false)
				.setTestAction(false)
				.setPromoteAction(true)
				.setDisplayName("Build")
				.setEnvState(envState)
				.setName(name)
				.setUpdatedDate(updatedDate)
				.build();
		for (BuildApp buildApp : buildApps) {
			dto.addMicroservice(buildApp.getMicroservice(envState));
		}
		return dto;
	}

}
