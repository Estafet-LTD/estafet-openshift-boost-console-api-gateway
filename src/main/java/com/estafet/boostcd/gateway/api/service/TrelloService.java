package com.estafet.boostcd.gateway.api.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.boostcd.gateway.api.dto.TrelloCardDTO;
import com.estafet.boostcd.gateway.api.model.TrelloCard;
import com.estafet.boostcd.gateway.api.util.ENV;

@Service
public class TrelloService {

	@Autowired
	private RestTemplate restTemplate;


	public TrelloCardDTO getTrelloCardDetails(String url_extension) {	
		TrelloCard trelloCard = restTemplate.getForObject(ENV.TRELLO_SERVICE_API + "/card/" + url_extension, TrelloCard.class);
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
