package com.estafet.openshift.boost.console.api.gateway.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.estafet.openshift.boost.console.api.gateway.dto.TrelloCardDTO;
import com.estafet.openshift.boost.console.api.gateway.service.TrelloService;

@RestController
public class TrelloController {

	@Autowired
	private TrelloService trelloService;
	

	@GetMapping("/card/{url_extension}")
	public TrelloCardDTO getTrelloCardDetails(@PathVariable String url_extension ) {
		return trelloService.getTrelloCardDetails(url_extension);
	}
	
}
