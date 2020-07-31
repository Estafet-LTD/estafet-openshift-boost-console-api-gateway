package com.estafet.boostcd.gateway.api.controller;

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

import com.estafet.boostcd.gateway.api.dto.ProjectDTO;
import com.estafet.boostcd.gateway.api.model.Project;
import com.estafet.boostcd.gateway.api.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/projects/{product}")
	public List<ProjectDTO> getProjects(@PathVariable String product) {
		return projectService.getProjects(product);
	}
	
	@GetMapping("/project/{product}/{namespace}")
	public ProjectDTO getProject(@PathVariable String product, @PathVariable String namespace) {
		return projectService.getProject(product, namespace);
	}

	@PostMapping("/project/{product}")
	public ResponseEntity<String> createProject(@PathVariable String product, @RequestBody Project project) {
		return new ResponseEntity<String>(projectService.createProject(product, project), HttpStatus.OK);
	}
	
	@DeleteMapping("/project/{product}/{project}")
	public ResponseEntity<String> deleteProject(@PathVariable String product, @PathVariable String project) {
		return new ResponseEntity<String>(projectService.deleteProject(product, project), HttpStatus.OK);
	}
	
	@PutMapping("/project/{product}/{namespace}")
	public ResponseEntity<String> editProject(@PathVariable String product, @PathVariable String namespace, @RequestBody Project project) {
		return new ResponseEntity<String>(projectService.editProject(product, project, namespace), HttpStatus.OK);
	}

	
}
