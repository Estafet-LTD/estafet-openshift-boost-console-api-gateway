package com.estafet.boostcd.gateway.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.estafet.boostcd.gateway.api.model.EnvState;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class EnvironmentDTO {

	private String name;
	private String displayName;
	private String updatedDate;
	private Boolean tested;
	private String indicatorColour;
	
	private EnvironmentActionsDTO actions;
	private EnvironmentStateDTO state;

	private List<FeatureDTO> features = new ArrayList<FeatureDTO>();
	private List<MicroserviceDTO> apps = new ArrayList<MicroserviceDTO>();

	public void addFeature(FeatureDTO feature) {
		features.add(feature);
	}

	public void addMicroservice(MicroserviceDTO microservice) {
		apps.add(microservice);
	}

	public String getIndicatorColour() {
		return indicatorColour;
	}

	public void setIndicatorColour(String indicatorColour) {
		this.indicatorColour = indicatorColour;
	}

	public List<MicroserviceDTO> getApps() {
		return apps;
	}

	public void setApps(List<MicroserviceDTO> apps) {
		this.apps = apps;
	}

	public List<FeatureDTO> getFeatures() {
		return features;
	}

	public void setFeatures(List<FeatureDTO> features) {
		this.features = features;
	}

	public EnvironmentStateDTO getState() {
		return state;
	}

	public void setState(EnvironmentStateDTO state) {
		this.state = state;
	}

	public EnvironmentActionsDTO getActions() {
		return actions;
	}

	public void setActions(EnvironmentActionsDTO actions) {
		this.actions = actions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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
	
	public static EnvironmentDTOBuilder builder() {
		return new EnvironmentDTOBuilder();
	}

	public static class EnvironmentDTOBuilder {

		private String name;
		private String displayName;
		private String updatedDate;
		private Boolean tested;
		private String indicatorColour;

		private Boolean buildAction;
		private Boolean testAction;

		private Boolean promoteAction;
		private Boolean goLiveAction;
		private Boolean backOutAction;

		private EnvState envState;

		public EnvironmentDTOBuilder setIndicatorColour(String indicatorColour) {
			this.indicatorColour = indicatorColour;
			return this;
		}

		public EnvironmentDTOBuilder setEnvState(EnvState envState) {
			this.envState = envState;
			return this;
		}

		public EnvironmentDTOBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public EnvironmentDTOBuilder setDisplayName(String displayName) {
			this.displayName = displayName;
			return this;
		}

		public EnvironmentDTOBuilder setUpdatedDate(String updatedDate) {
			this.updatedDate = updatedDate;
			return this;
		}

		public EnvironmentDTOBuilder setTested(Boolean tested) {
			this.tested = tested;
			return this;
		}

		public EnvironmentDTOBuilder setBuildAction(Boolean buildAction) {
			this.buildAction = buildAction;
			return this;
		}

		public EnvironmentDTOBuilder setTestAction(Boolean testAction) {
			this.testAction = testAction;
			return this;
		}

		public EnvironmentDTOBuilder setPromoteAction(Boolean promoteAction) {
			this.promoteAction = promoteAction;
			return this;
		}

		public EnvironmentDTOBuilder setGoLiveAction(Boolean goLiveAction) {
			this.goLiveAction = goLiveAction;
			return this;
		}

		public EnvironmentDTOBuilder setBackOutAction(Boolean backOutAction) {
			this.backOutAction = backOutAction;
			return this;
		}

		public EnvironmentDTO build() {
			EnvironmentDTO dto = new EnvironmentDTO();
			EnvironmentActionsDTO actions = new EnvironmentActionsDTO();
			EnvironmentStateDTO state = EnvironmentStateDTO.builder().setState(envState).build();
			dto.setState(state);
			dto.setUpdatedDate(updatedDate);
			dto.setTested(tested);
			dto.setName(name);
			dto.setDisplayName(displayName);
			dto.setActions(actions);
			dto.setIndicatorColour(indicatorColour);
			actions.setBackOut(backOutAction);
			actions.setBuild(buildAction);
			actions.setGoLive(goLiveAction);
			actions.setPromote(promoteAction);
			actions.setTest(testAction);
			return dto;
		}

	}

}
