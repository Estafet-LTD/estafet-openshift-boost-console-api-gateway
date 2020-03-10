package com.estafet.openshift.boost.console.api.gateway.dto;

public class EnvironmentActionResponseDTO {

	private String environment;
	
	private String status;

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public static EnvironmentActionResponseDTOBuilder builder() {
		return new EnvironmentActionResponseDTOBuilder();
	}
	
	public static class EnvironmentActionResponseDTOBuilder {
		
		private String environment;
		private String status;
		
		public EnvironmentActionResponseDTOBuilder setEnvironment(String environment) {
			this.environment = environment;
			return this;
		}
		
		public EnvironmentActionResponseDTOBuilder setStatus(String status) {
			this.status = status;
			return this;
		}
		
		public EnvironmentActionResponseDTO build() {
			EnvironmentActionResponseDTO dto = new EnvironmentActionResponseDTO();
			dto.setEnvironment(environment);
			dto.setStatus(status);
			return dto;
		}
		
	}
	
}
