package com.springreact.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.demo.Project;
import com.springreact.demo.service.ErrorMapping;
import com.springreact.demo.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	ErrorMapping errorMapping;
	
	@PostMapping("/create")
	public ResponseEntity<?> createProject(@Valid @RequestBody Project project,BindingResult result) {
		
		
		ResponseEntity<?> errormap = errorMapping.mapErrors(result);
		if(errormap != null) {
			return errormap;
		}
		Project projectCreated = projectService.saveProject(project);
		return new ResponseEntity<Project>(projectCreated,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/fetch/{projectId}")
	public ResponseEntity<?> getProjectByIdentifier(@PathVariable String projectId){
		
		return new ResponseEntity<Project>(projectService.getProjectByIdentifier(projectId), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Project> getAllProjects(){
		return (List<Project>) projectService.getAllProject();
	}

}
