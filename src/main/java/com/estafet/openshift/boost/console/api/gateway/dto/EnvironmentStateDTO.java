package com.estafet.openshift.boost.console.api.gateway.dto;

import com.estafet.openshift.boost.console.api.gateway.model.EnvState;
import com.estafet.openshift.boost.console.api.gateway.model.State;

public class EnvironmentStateDTO {

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

	public static EnvironmentStateDTOBuilder builder() {
		return new EnvironmentStateDTOBuilder();
	}
	
	public static class EnvironmentStateDTOBuilder {
		
		private EnvState state;

		public EnvironmentStateDTOBuilder setState(EnvState state) {
			this.state = state;
			return this;
		}
		
		public EnvironmentStateDTO build() {
			EnvironmentStateDTO dto = new EnvironmentStateDTO();
			dto.setBuild(isRunning(state.getBuild()));
			dto.setBackOut(isRunning(state.getBackOut()));
			dto.setGoLive(isRunning(state.getGoLive()));
			dto.setPromote(isRunning(state.getPromote()));
			dto.setTest(isRunning(state.getTest()));
			return dto;
		}
		
		private boolean isRunning(State state) {
			if (state != null) {
				return state == State.RUNNING || state == State.NEW;
			} else {
				return false;
			}
		}
		
	}
	
}
