package org.arch.springexam.controller;


import org.arch.springexam.entity.Project;
import org.arch.springexam.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public int addProject(@RequestBody Project project) {
        return projectService.addProjectService(project);
    }

    @GetMapping
    public List<Project> findAll() {
        return projectService.findAllService();
    }

    @GetMapping("/findByName/{name}")
    public int findProjectIdByName(@PathVariable String name) {
        return projectService.findProjectIdByNameService(name);
    }

    @GetMapping("/find/{id}")
    public Project findProjectById(@PathVariable int id) {
        return projectService.findProjectByIdService(id);
    }

    @GetMapping("/employee/{employeeId}")
    public List<Project> findAllProjectsByEmployee(@PathVariable int employeeId) {
        return projectService.findAllProjectsEmployeesService(employeeId);
    }
}