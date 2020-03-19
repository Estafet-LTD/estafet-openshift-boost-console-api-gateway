package com.estafet.openshift.boost.console.api.gateway.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserDTO {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static class UserDTOBuilder {
		private String name;

		public UserDTOBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public UserDTO build() {
			UserDTO dto = new UserDTO();
			dto.setName(name);
			return dto;
		}
	}
}
