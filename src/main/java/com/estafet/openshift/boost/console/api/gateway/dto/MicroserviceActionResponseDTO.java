package com.estafet.openshift.boost.console.api.gateway.dto;

public class MicroserviceActionResponseDTO {

	private String environment;
	private String microservice;
	private String status;

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	public String getMicroservice() {
		return microservice;
	}

	public void setMicroservice(String microservice) {
		this.microservice = microservice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public static MicroserviceActionResponseDTOBuilder builder() {
		return new MicroserviceActionResponseDTOBuilder();
	}
	
	public static class MicroserviceActionResponseDTOBuilder {
		
		private String environment;
		private String status;
		private String microservice;
		
		public MicroserviceActionResponseDTOBuilder setMicroservice(String microservice) {
			this.microservice = microservice;
			return this;
		}

		public MicroserviceActionResponseDTOBuilder setEnvironment(String environment) {
			this.environment = environment;
			return this;
		}
		
		public MicroserviceActionResponseDTOBuilder setStatus(String status) {
			this.status = status;
			return this;
		}
		
		public MicroserviceActionResponseDTO build() {
			MicroserviceActionResponseDTO dto = new MicroserviceActionResponseDTO();
			dto.setEnvironment(environment);
			dto.setStatus(status);
			dto.setMicroservice(microservice);
			return dto;
		}
		
	}
	
}
