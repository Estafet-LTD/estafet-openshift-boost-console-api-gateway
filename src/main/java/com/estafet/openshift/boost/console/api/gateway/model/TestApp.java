package com.estafet.openshift.boost.console.api.gateway.model;

import com.estafet.openshift.boost.console.api.gateway.dto.MicroserviceDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class TestApp {

	private String name;
	private String version;
	private String testStatus;
	private String deployedDate;
	private String errors;
	private boolean deployed;
	private String updatedDate;

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getDeployedDate() {
		return deployedDate;
	}

	public void setDeployedDate(String deployedDate) {
		this.deployedDate = deployedDate;
	}

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

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
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

	@JsonIgnore
	public MicroserviceDTO getMicroservice(EnvState envState) {
		return MicroserviceDTO.builder()
				.setDeployed(deployed)
				.setDeployedDate(deployedDate)
				.setName(name)
				.setPromoteAction(!testStatus.equals("Untested"))
				.setVersion(version)
				.setAppState(envState.appState(name))
				.build();
	}

}
