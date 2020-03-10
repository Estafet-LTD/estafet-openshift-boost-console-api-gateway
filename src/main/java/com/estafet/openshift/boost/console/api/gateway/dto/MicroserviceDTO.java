package com.estafet.openshift.boost.console.api.gateway.dto;

public class MicroserviceDTO {

	private String version;
	private String name;
	private String deployedDate;
	private boolean deployed;

	private MicroserviceActionsDTO actions;

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

	public String getDeployedDate() {
		return deployedDate;
	}

	public void setDeployedDate(String deployedDate) {
		this.deployedDate = deployedDate;
	}

	public boolean isDeployed() {
		return deployed;
	}

	public void setDeployed(boolean deployed) {
		this.deployed = deployed;
	}

	public MicroserviceActionsDTO getActions() {
		return actions;
	}

	public void setActions(MicroserviceActionsDTO actions) {
		this.actions = actions;
	}
	
	public static MicroserviceDTOBuilder builder() {
		return new MicroserviceDTOBuilder();
	}

	public static class MicroserviceDTOBuilder {

		private String version;
		private String name;
		private String deployedDate;
		private boolean deployed;		
		private Boolean promoteAction;

		public MicroserviceDTOBuilder setPromoteAction(Boolean promoteAction) {
			this.promoteAction = promoteAction;
			return this;
		}

		public MicroserviceDTOBuilder setVersion(String version) {
			this.version = version;
			return this;
		}

		public MicroserviceDTOBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public MicroserviceDTOBuilder setDeployedDate(String deployedDate) {
			this.deployedDate = deployedDate;
			return this;
		}

		public MicroserviceDTOBuilder setDeployed(boolean deployed) {
			this.deployed = deployed;
			return this;
		}
		
		public MicroserviceDTO build() {
			MicroserviceDTO dto = new MicroserviceDTO();
			MicroserviceActionsDTO actions = new MicroserviceActionsDTO();
			dto.setVersion(version);
			dto.setName(name);
			dto.setDeployedDate(deployedDate);
			dto.setDeployed(deployed);
			dto.setActions(actions);
			if (promoteAction != null) {
				actions.setPromote(promoteAction);	
			}
			return dto;
		}

	}

}
