package com.estafet.boostcd.gateway.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.boostcd.gateway.api.util.ENV;
import com.estafet.openshift.boost.messages.github.GitHubHook;

@Service
public class GitHubService {
	
	@Autowired
	private RestTemplate restTemplate;

	public String webhook(GitHubHook hook) {
		return restTemplate.postForObject(ENV.ENVIRONMENT_SERVICE_API + 
				"/github/hooks", hook, String.class);
	}

}
