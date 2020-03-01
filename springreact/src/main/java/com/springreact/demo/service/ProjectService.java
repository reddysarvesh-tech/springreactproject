package com.springreact.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreact.demo.Project;
import com.springreact.demo.exceptions.ProjectIDException;
import com.springreact.demo.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
    public Project saveProject(Project project) {
    	
    	try {
    	return projectRepository.save(project);
    	}catch(Exception e) {
    		throw new ProjectIDException("Project ID "+project.getProjectIdentifier()+" already exists");
    	}
    }
    
    public Project getProjectByIdentifier(String projectid) {
    	
    	Project project = projectRepository.findByProjectIdentifier(projectid);
    	
    	if(project == null) {
    		throw new ProjectIDException("Project with id "+projectid+" not found");
    	}

    	return projectRepository.findByProjectIdentifier(projectid);
    }
}
