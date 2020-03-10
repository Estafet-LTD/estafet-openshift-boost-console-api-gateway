package com.estafet.openshift.boost.console.api.gateway.model;

import java.util.ArrayList;
import java.util.List;

import com.estafet.openshift.boost.console.api.gateway.dto.EnvironmentDTO;

public class FeatureEnv {

	private String name;

	private String updatedDate;

	private boolean live;
	
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

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	public EnvironmentDTO getEnvironmentDTO() {
		
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
				.setTestAction(!(live || name.equals("build")))
				.setPromoteAction(!live)
				.setDisplayName(displayName)
				.setName(name)
				.setUpdatedDate(updatedDate)
				.build();
		
		for (Feature feature : features) {
			dto.addFeature(feature.getFeatureDTO());
		}
		
		return dto;
	}
	
}
