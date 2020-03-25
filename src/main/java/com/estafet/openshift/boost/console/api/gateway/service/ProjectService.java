package com.estafet.openshift.boost.console.api.gateway.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
			ProjectDTO projectDTO = new ProjectDTO();
			projectDTO.setTitle(project.getTitle());
			projectDTO.setOwner(project.getOwner());
			projectDTO.setNamespace(project.getNamespace());
			projectsDTO.add(projectDTO);
		}
		return projectsDTO;
	}
			
	
}
