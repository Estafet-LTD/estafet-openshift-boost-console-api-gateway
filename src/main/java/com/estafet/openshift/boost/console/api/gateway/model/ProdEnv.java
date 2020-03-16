package com.estafet.openshift.boost.console.api.gateway.model;

import java.util.ArrayList;
import java.util.List;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProdEnv {

	private String name;
	private List<ProdApp> prodApps = new ArrayList<ProdApp>();
	private boolean tested;
	private boolean live;
	private String updatedDate;

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<ProdApp> getProdApps() {
		return prodApps;
	}
	
	public void setProdApps(List<ProdApp> prodApps) {
		this.prodApps = prodApps;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProdApp> getApps() {
		return prodApps;
	}

	public void setApps(List<ProdApp> prodApps) {
		this.prodApps = prodApps;
	}

	public boolean isTested() {
		return tested;
	}

	public void setTested(boolean tested) {
		this.tested = tested;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	@JsonIgnore
	public EnvironmentDTO getEnvironmentDTO(EnvState envState) {
		EnvironmentDTO dto = EnvironmentDTO.builder()
				.setBackOutAction(live)
				.setBuildAction(false)
				.setGoLiveAction(!live)
				.setTestAction(!live)
				.setPromoteAction(false)
				.setDisplayName(live ? "Live" : "Staging")
				.setName(name)
				.setEnvState(envState)
				.setTested(live ? null : tested)
				.setIndicatorColour(name)
				.setUpdatedDate(updatedDate)
				.build();
		for (ProdApp prodApp : prodApps) {
			dto.addMicroservice(prodApp.getMicroservice(live, envState));
		}
		return dto;
	}

}
