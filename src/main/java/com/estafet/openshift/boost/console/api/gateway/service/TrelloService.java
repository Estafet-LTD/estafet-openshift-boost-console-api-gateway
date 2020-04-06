package com.estafet.openshift.boost.console.api.gateway.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.openshift.boost.console.api.gateway.dto.TrelloCardDTO;
import com.estafet.openshift.boost.console.api.gateway.model.TrelloCard;
import com.estafet.openshift.boost.console.api.gateway.model.TrelloUrl;
import com.estafet.openshift.boost.console.api.gateway.util.ENV;

@Service
public class TrelloService {

	@Autowired
	private RestTemplate restTemplate;


	public TrelloCardDTO getTrelloCardDetails(TrelloUrl url) {
		
		TrelloCard trelloCard = restTemplate.getForObject(ENV.TRELLO_SERVICE_API + "/card", TrelloCard.class, url);

		return convertToDTO(trelloCard);
	}
	

	
	private TrelloCardDTO convertToDTO(TrelloCard trelloCard) {
		return TrelloCardDTO.builder()
				.setId(trelloCard.getId())
				.setName(trelloCard.getName())
				.setDesc(trelloCard.getDesc())
				.setDateLastActivity(trelloCard.getDateLastActivity())
				.setStatus(trelloCard.getStatus())
				.build();
	}
	
}
