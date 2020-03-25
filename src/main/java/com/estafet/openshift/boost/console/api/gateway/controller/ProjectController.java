package com.estafet.openshift.boost.console.api.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estafet.openshift.boost.console.api.gateway.dto.ProjectDTO;
import com.estafet.openshift.boost.console.api.gateway.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/projects")
	public List<ProjectDTO> getProjects() {
		return projectService.getProjects();
	}
	
}
