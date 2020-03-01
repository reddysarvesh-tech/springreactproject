package com.springreact.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.springreact.demo.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>  {
	
	
	Project findByProjectIdentifier(String projectIdentifier);
	

}
