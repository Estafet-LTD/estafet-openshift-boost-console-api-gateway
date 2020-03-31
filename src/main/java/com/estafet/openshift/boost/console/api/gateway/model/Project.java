package com.estafet.openshift.boost.console.api.gateway.model;

import com.estafet.openshift.boost.console.api.gateway.dto.ProjectDTO;

public class Project {

	private String title;
	
	private String owner;
	
	private String namespace;

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

	public ProjectDTO getProjectDTO() {
		return ProjectDTO.builder()
				.setTitle(title)
				.setOwner(owner)
				.build();
	}
	
}
