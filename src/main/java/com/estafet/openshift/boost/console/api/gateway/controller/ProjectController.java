package com.estafet.openshift.boost.console.api.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estafet.openshift.boost.console.api.gateway.dto.ProjectDTO;
import com.estafet.openshift.boost.console.api.gateway.model.Project;
import com.estafet.openshift.boost.console.api.gateway.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/projects")
	public List<ProjectDTO> getProjects() {
		return projectService.getProjects();
	}
	
	@GetMapping("/project/{namespace}")
	public ProjectDTO getProject(@PathVariable String namespace) {
		return projectService.getProject(namespace);
	}

	@PostMapping("/project")
	public ResponseEntity<String> createProject(@RequestBody Project project) {
		return new ResponseEntity<String>(projectService.createProject(project), HttpStatus.OK);
	}
	
	@DeleteMapping("/project/{project}")
	public ResponseEntity<String> deleteProject(@PathVariable String project) {
		return new ResponseEntity<String>(projectService.deleteProject(project), HttpStatus.OK);
	}
	
	@PutMapping("/project/{namespace}")
	public ResponseEntity<String> editProject(@PathVariable String namespace, @RequestBody Project project) {
		return new ResponseEntity<String>(projectService.editProject(project, namespace), HttpStatus.OK);
	}

	
}
