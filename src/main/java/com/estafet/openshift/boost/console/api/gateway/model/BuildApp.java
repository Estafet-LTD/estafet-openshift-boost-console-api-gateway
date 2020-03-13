package com.estafet.openshift.boost.console.api.gateway.model;

import com.estafet.openshift.boost.console.api.gateway.dto.MicroserviceDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BuildApp {

	private String name;
	private String version;
	private boolean canRelease;
	private String deployedDate;
	private String errors;
	private boolean deployed;
	private String updatedDate;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCanRelease() {
		return canRelease;
	}

	public void setCanRelease(boolean canRelease) {
		this.canRelease = canRelease;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public boolean isDeployed() {
		return deployed;
	}

	public void setDeployed(boolean deployed) {
		this.deployed = deployed;
	}

	public String getDeployedDate() {
		return deployedDate;
	}

	public void setDeployedDate(String deployedDate) {
		this.deployedDate = deployedDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@JsonIgnore
	public MicroserviceDTO getMicroserviceDTO(EnvState envState) {
		AppState appState = envState.appState(name);
		return MicroserviceDTO.builder()
				.setDeployed(deployed)
				.setDeployedDate(deployedDate)
				.setName(name)
				.setPromoteAction(isComplete(appState.getBuild()))
				.setBuildAction(true)
				.setVersion(version)
				.setAppState(appState)
				.build();
	}
	
	
	private boolean isComplete(State state) {
		if (state != null) {
			return state == State.COMPLETE;
		} else {
			return false;
		}
	}

}
