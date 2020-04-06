package com.estafet.openshift.boost.console.api.gateway.model;

import com.estafet.openshift.boost.console.api.gateway.dto.TrelloCardDTO;

public class TrelloCard {

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

	
	public TrelloCardDTO getTrelloCardDTO() {
		return TrelloCardDTO.builder()
			.setId(id)
			.setName(name)
			.setDesc(desc)
			.setStatus(status)
			.setDateLastActivity(dateLastActivity)
			.build();
	}
}
