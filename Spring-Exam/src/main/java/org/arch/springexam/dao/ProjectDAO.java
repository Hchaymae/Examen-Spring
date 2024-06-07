package org.arch.springexam.dao;

import org.arch.springexam.entity.EmployeeProject;
import org.arch.springexam.entity.Project;

import java.util.List;

public interface ProjectDAO {
    public int addProject(Project project);
    public List<Project> findAll();

    public int findProjectIdByName(String name);
    public Project findProjectByName(String name);
    public Project findProjectById(int id);
    public List<EmployeeProject> findProjectsByEmployeeId(int employeeId);
}
