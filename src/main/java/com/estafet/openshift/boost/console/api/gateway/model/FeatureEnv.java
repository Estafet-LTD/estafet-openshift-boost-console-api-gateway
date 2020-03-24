package com.estafet.openshift.boost.console.api.gateway.model;

import java.util.ArrayList;
import java.util.List;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;

public class FeatureEnv {

	private String name;
	private String updatedDate;
	private Boolean live;
	private Boolean tested;
	
	private List<Feature> features = new ArrayList<Feature>();

	public void addFeature(Feature feature) {
		features.add(feature);
	}
	
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

	public Boolean getTested() {
		return tested;
	}

	public void setTested(Boolean tested) {
		this.tested = tested;
	}

	public Boolean getLive() {
		return live;
	}

	public void setLive(Boolean live) {
		this.live = live;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	public EnvironmentDTO getEnvironmentDTO(EnvState envState) {
		
		String displayName;
		boolean backOutAction = false;
		boolean goLiveAction = false;
		
		if (name.equals("blue") || name.equals("green")) {
			displayName = live ? "Live" : "Staging";
			backOutAction = live;
			goLiveAction = !live;
		} else {
			displayName = name.substring(0, 1).toUpperCase() + name.substring(1);
		}
		
		EnvironmentDTO dto = EnvironmentDTO.builder()
				.setBackOutAction(backOutAction)
				.setBuildAction(name.equals("build"))
				.setGoLiveAction(goLiveAction)
				.setTestAction(testAction())
				.setPromoteAction(promoteAction(envState))
				.setEnvState(envState)
				.setDisplayName(displayName)
				.setIndicatorColour(indicatorColour())
				.setName(name)
				.setTested(tested)
				.setUpdatedDate(updatedDate)
				.build();
		
		for (Feature feature : features) {
			dto.addFeature(feature.getFeatureDTO());
		}
		
		return dto;
	}
	
	private String indicatorColour() {
		if (name.equals("green") || name.equals("blue")) {
			return name;
		} else {
			return null;
		}
	}
		
	private boolean testAction() {
		if (name.equals("build")) {
			return false;
		} else if (name.equals("green") || name.equals("blue")) {
			return !live;
		} else {
			return true;
		}
	}
	
	private boolean promoteAction(EnvState envState) {
		if (envState.getName().equals("build")) {
			return true;
		} else if (envState.getName().equals("test")) {
			return envState.getTest() == State.COMPLETE;
		} else if (envState.getName().equals("green") || envState.getName().equals("blue")) {
			return false;
		} else {
			throw new RuntimeException("Unknown environment - " + envState.getName());
		}
	}
	
}
