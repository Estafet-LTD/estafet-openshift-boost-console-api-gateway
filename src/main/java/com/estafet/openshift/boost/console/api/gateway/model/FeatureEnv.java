package com.estafet.openshift.boost.console.api.gateway.model;

import java.util.ArrayList;
import java.util.List;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;

public class FeatureEnv {

	private String name;
	private String displayName;
	private String updatedDate;
	private Boolean live;
	private Boolean tested;
	
	private List<Feature> features = new ArrayList<Feature>();

	public void addFeature(Feature feature) {
		features.add(feature);
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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
		
		EnvironmentDTO dto = EnvironmentDTO.builder()
				.setBackOutAction(backOutAction())
				.setBuildAction(buildAction())
				.setGoLiveAction(goLiveAction())
				.setTestAction(testAction())
				.setPromoteAction(promoteAction())
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

	public boolean buildAction() {
		return name.equals("build");
	}
	
	private boolean backOutAction() {
		return name.equals("blue") || name.equals("green") ? live : false;
	}
	
	private boolean goLiveAction() {
		return name.equals("blue") || name.equals("green") ? !live && tested.booleanValue() : false;
	}
	
	private String indicatorColour() {
		if (name.equals("green") || name.equals("blue")) {
			return name;
		} else {
			return "black";
		}
	}
		
	private boolean testAction() {
		if (buildAction()) {
			return false;
		} else if (name.equals("green") || name.equals("blue")) {
			return !live;
		} else {
			return true;
		}
	}
	
	private boolean promoteAction() {
		if (buildAction()) {
			return false;
		} else if (name.equals("green") || name.equals("blue")) {
			return false;
		} else {
			return tested == null ? false : tested && allFeaturesDone();
		}
	}

	private boolean allFeaturesDone() {
		for (Feature feature : features) {
			if (!feature.getStatus().equals("Done")) {
				return false;
			}
		}
		return true;
	}
	
}
