package com.estafet.openshift.boost.console.api.gateway.dto;

public class EnvironmentActionsDTO {

	private boolean build;
	private boolean test;

	private boolean promote;
	private boolean goLive;
	private boolean backOut;

	public boolean isBuild() {
		return build;
	}

	public void setBuild(boolean build) {
		this.build = build;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	public boolean isPromote() {
		return promote;
	}

	public void setPromote(boolean promote) {
		this.promote = promote;
	}

	public boolean isGoLive() {
		return goLive;
	}

	public void setGoLive(boolean goLive) {
		this.goLive = goLive;
	}

	public boolean isBackOut() {
		return backOut;
	}

	public void setBackOut(boolean backOut) {
		this.backOut = backOut;
	}

}
