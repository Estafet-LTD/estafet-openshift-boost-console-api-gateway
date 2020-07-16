package com.estafet.boostcd.gateway.api.dto;

import com.estafet.boostcd.gateway.api.model.AppState;
import com.estafet.boostcd.gateway.api.model.State;

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
				return state == State.RUNNING || state == State.NEW || state == State.PENDING;
			} else {
				return false;
			}
		}
		
	}
	
}
