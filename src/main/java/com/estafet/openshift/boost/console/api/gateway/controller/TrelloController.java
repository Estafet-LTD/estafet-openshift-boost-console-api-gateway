package com.estafet.openshift.boost.console.api.gateway.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estafet.openshift.boost.console.api.gateway.dto.TrelloCardDTO;
import com.estafet.openshift.boost.console.api.gateway.model.TrelloUrl;
import com.estafet.openshift.boost.console.api.gateway.service.TrelloService;

@RestController
public class TrelloController {

	@Autowired
	private TrelloService trelloService;
	

	@GetMapping("/card")
	public TrelloCardDTO getTrelloCardDetails(@RequestBody TrelloUrl url) {
		return trelloService.getTrelloCardDetails(url);
	}
	
}
