package com.estafet.openshift.boost.console.api.gateway.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.openshift.boost.console.api.gateway.dto.ProjectDTO;
import com.estafet.openshift.boost.console.api.gateway.model.Project;
import com.estafet.openshift.boost.console.api.gateway.util.ENV;
import com.estafet.openshift.boost.messages.users.User;

@Service
public class ProjectService {

	@Autowired
	private RestTemplate restTemplate;


	public List<ProjectDTO> getProjects() {
		List<ProjectDTO> projectsDTO = new ArrayList<ProjectDTO>();
		Project[] projects = restTemplate.getForObject(ENV.PROJECT_SERVICE_API + "/projects", Project[].class);
		for (Project project : projects) {
			ProjectDTO projectDTO = new ProjectDTO();
			projectDTO.setTitle(project.getTitle());
			projectDTO.setOwner(project.getOwner());
			projectDTO.setNamespace(project.getNamespace());
			projectsDTO.add(projectDTO);
		}
		return projectsDTO;
	}
			
	public String createProject(Project project) {
		String response = restTemplate.postForObject(ENV.PROJECT_SERVICE_API + "/project", project, String.class);
		return response;
	}
	
	public String deleteProject(String project) {
		
		String response = (restTemplate.exchange(ENV.PROJECT_SERVICE_API + "/project/{project}" ,  HttpMethod.DELETE, null, String.class, project )).getBody();
		return response;
	}
	
	public String editProject(Project project, String namespace) {
	    HttpHeaders headers = new HttpHeaders();
	    HttpEntity<Project> entity = new HttpEntity<Project>(project, headers);
		String response = (restTemplate.exchange(ENV.PROJECT_SERVICE_API + "/project/{namespace}" ,  HttpMethod.PUT, entity, String.class, namespace )).getBody();
		return response;
	}
}
