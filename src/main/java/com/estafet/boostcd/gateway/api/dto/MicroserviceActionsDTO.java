package com.estafet.boostcd.gateway.api.dto;

public class MicroserviceActionsDTO {

	private boolean build;
	private boolean promote;

	public boolean getBuild() {
		return build;
	}

	public void setBuild(Boolean build) {
		if (build != null) {
			this.build = build;	
		}
	}

	public boolean getPromote() {
		return promote;
	}

	public void setPromote(Boolean promote) {
		if (promote != null) {
			this.promote = promote;	
		}
	}

}
