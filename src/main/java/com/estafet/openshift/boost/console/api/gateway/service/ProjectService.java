package com.estafet.openshift.boost.console.api.gateway.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.openshift.boost.console.api.gateway.dto.ProjectDTO;
import com.estafet.openshift.boost.console.api.gateway.model.Project;
import com.estafet.openshift.boost.console.api.gateway.util.ENV;

@Service
public class ProjectService {

	@Autowired
	private RestTemplate restTemplate;


	public List<ProjectDTO> getProjects() {
		List<ProjectDTO> projectsDTO = new ArrayList<ProjectDTO>();
		Project[] projects = restTemplate.getForObject(ENV.PROJECT_SERVICE_API + "/projects", Project[].class);
		for (Project project : projects) {
			projectsDTO.add(convertToDTO(project));
		}
		return projectsDTO;
	}
	
	public ProjectDTO getProject(String namespace) {
		Project project = restTemplate.getForObject(ENV.PROJECT_SERVICE_API + "/project/" + namespace, Project.class);
		return convertToDTO(project);
	}
			
	public String createProject(Project project) {
		String response = restTemplate.postForObject(ENV.PROJECT_SERVICE_API + "/project", project, String.class);
		return response;
	}
	
	public String deleteProject(String project) {
		String response = (restTemplate.exchange(ENV.PROJECT_SERVICE_API + "/project/{project}" , HttpMethod.DELETE, null, String.class, project)).getBody();
		return response;
	}
	
	public String editProject(Project project, String namespace) {
	    HttpHeaders headers = new HttpHeaders();
	    HttpEntity<Project> entity = new HttpEntity<Project>(project, headers);
		String response = (restTemplate.exchange(ENV.PROJECT_SERVICE_API + "/project/{namespace}", HttpMethod.PUT, entity, String.class, namespace)).getBody();
		return response;
	}
	
	private ProjectDTO convertToDTO(Project project) {
		return ProjectDTO.builder()
			.setNamespace(project.getNamespace())
			.setOwner(project.getOwner())
			.setStatus(project.getStatus())
			.setTitle(project.getTitle())
			.build();
	}
	
}
