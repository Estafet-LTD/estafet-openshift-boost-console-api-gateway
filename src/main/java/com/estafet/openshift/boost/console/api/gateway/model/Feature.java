package com.estafet.openshift.boost.console.api.gateway.model;

import com.estafet.openshift.boost.console.api.gateway.dto.FeatureDTO;

public class Feature {

	private String featureId;

	private String title;

	private String description;

	private String status;

	private boolean promoted;

	private String waitingSince;

	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isPromoted() {
		return promoted;
	}

	public void setPromoted(boolean promoted) {
		this.promoted = promoted;
	}

	public String getWaitingSince() {
		return waitingSince;
	}

	public void setWaitingSince(String waitingSince) {
		this.waitingSince = waitingSince;
	}

	public FeatureDTO getFeatureDTO() {
		return FeatureDTO.builder()
				.setDescription(description)
				.setFeatureId(featureId)
				.setPromoted(promoted)
				.setStatus(status)
				.setTitle(title)
				.setWaitingSince(waitingSince)
				.setUrl("http://trello.com")
				.build();
	}

}
