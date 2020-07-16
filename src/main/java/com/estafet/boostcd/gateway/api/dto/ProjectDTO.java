package com.estafet.boostcd.gateway.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProjectDTO {

	private String title;
	
	private String owner;
	
	private String namespace;
	
	private String status;

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public static ProjectDTOBuilder builder() {
		return new ProjectDTOBuilder();
	}

	public static class ProjectDTOBuilder {
		private String title;
		private String owner;
		private String namespace;
		private String status;


		public ProjectDTOBuilder setTitle(String title) {
			this.title = title;
			return this;
		}
		
		public ProjectDTOBuilder setOwner(String owner) {
			this.owner = owner;
			return this;
		}
		
		public ProjectDTOBuilder setNamespace(String namespace) {
			this.namespace = namespace;
			return this;
		}
		
		public ProjectDTOBuilder setStatus(String status) {
			this.status = status;
			return this;
		}
		
		public ProjectDTO build() {
			ProjectDTO dto = new ProjectDTO();
			dto.setTitle(title);
			dto.setOwner(owner);
			dto.setNamespace(namespace);
			dto.setStatus(status);

			return dto;
		}
	}
}
