package org.arch.springexam.dao;

import org.arch.springexam.entity.Employee;
import org.arch.springexam.entity.EmployeeProjectId;
import org.arch.springexam.entity.EmployeeSkill;

import java.util.List;

public interface EmployeeDAO {
    public int addEmployee(Employee employee);
    public List<Employee> findAll();
    public int affecterproject(int employeeid, int projectid, double charge);
    public List<Employee> findAllByRole(String role) ;
    public int findEmployeeIdByName(String name);
    public Employee findEmployeeById(int id);
    public List<Employee> findAllEmployeesSkillsProjects();
    public int deleteProject(EmployeeProjectId id);
    public int deleteSkill(int skillId);
    public int deleteEmployee(int employeeId);
   public  List<EmployeeSkill> findSkillsByEmployeeId(int employeeId);
}
