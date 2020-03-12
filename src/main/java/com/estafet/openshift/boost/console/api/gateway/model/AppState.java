package com.estafet.openshift.boost.console.api.gateway.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AppState {
	
	private String name;
	
	private State build;

	private State promote;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getBuild() {
		return build;
	}

	public void setBuild(State build) {
		this.build = build;
	}

	public State getPromote() {
		return promote;
	}

	public void setPromote(State promote) {
		this.promote = promote;
	}
	
}
