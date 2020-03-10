package com.estafet.openshift.boost.console.api.gateway.model;

import java.util.ArrayList;
import java.util.List;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class TestEnv {

	private String name;
	private boolean tested;
	private List<TestApp> testApps = new ArrayList<TestApp>();
	private String updatedDate;

	public List<TestApp> getTestApps() {
		return testApps;
	}

	public void setTestApps(List<TestApp> testApps) {
		this.testApps = testApps;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TestApp> getApps() {
		return testApps;
	}

	public void setApps(List<TestApp> testApps) {
		this.testApps = testApps;
	}

	public boolean isTested() {
		return tested;
	}

	public void setTested(boolean tested) {
		this.tested = tested;
	}
	
	@JsonIgnore
	public EnvironmentDTO getEnvironmentDTO() {
		EnvironmentDTO dto = EnvironmentDTO.builder()
				.setBackOutAction(false)
				.setBuildAction(false)
				.setGoLiveAction(false)
				.setTestAction(tested)
				.setPromoteAction(tested)
				.setDisplayName("Test")
				.setName(name)
				.setUpdatedDate(updatedDate)
				.build();
		for (TestApp testApp : testApps) {
			dto.addMicroservice(testApp.geMicroservice());
		}
		return dto;
	}

}
