package com.estafet.openshift.boost.console.api.gateway.dto;

import com.estafet.openshift.boost.console.api.gateway.model.AppState;
import com.estafet.openshift.boost.console.api.gateway.model.State;

public class MicroserviceStateDTO {

	private boolean build;
	private boolean promote;

	public boolean isBuild() {
		return build;
	}

	public void setBuild(boolean build) {
		this.build = build;
	}

	public boolean isPromote() {
		return promote;
	}

	public void setPromote(boolean promote) {
		this.promote = promote;
	}
	
	public static MicroserviceStateDTOBuilder builder() {
		return new MicroserviceStateDTOBuilder();
	}

	public static class MicroserviceStateDTOBuilder {
		
		private AppState state;

		public MicroserviceStateDTOBuilder setState(AppState state) {
			this.state = state;
			return this;
		}
		
		public MicroserviceStateDTO build() {
			MicroserviceStateDTO dto = new MicroserviceStateDTO();
			dto.setBuild(isRunning(state.getBuild()));
			dto.setPromote(isRunning(state.getPromote()));
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
