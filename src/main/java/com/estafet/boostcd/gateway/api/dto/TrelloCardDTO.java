package com.estafet.boostcd.gateway.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TrelloCardDTO {

	private String id;
	
	private String name;
	
	private String desc;
	
	private String dateLastActivity;
	
	private String status;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDateLastActivity() {
		return dateLastActivity;
	}

	public void setDateLastActivity(String dateLastActivity) {
		this.dateLastActivity = dateLastActivity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static TrelloCardDTOBuilder builder() {
		return new TrelloCardDTOBuilder();
	}

	public static class TrelloCardDTOBuilder {
		private String id;		
		private String name;		
		private String desc;		
		private String dateLastActivity;		
		private String status;


		public TrelloCardDTOBuilder setId(String id) {
			this.id = id;
			return this;
		}
		
		public TrelloCardDTOBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public TrelloCardDTOBuilder setDesc(String desc) {
			this.desc = desc;
			return this;
		}
		
		public TrelloCardDTOBuilder setDateLastActivity(String dateLastActivity) {
			this.dateLastActivity = dateLastActivity;
			return this;
		}
		
		public TrelloCardDTOBuilder setStatus(String status) {
			this.status = status;
			return this;
		}
		
		public TrelloCardDTO build() {
			TrelloCardDTO dto = new TrelloCardDTO();
			dto.setId(id);
			dto.setName(name);
			dto.setDesc(desc);
			dto.setDateLastActivity(dateLastActivity);
			dto.setStatus(status);
			return dto;
		}
	}
}
