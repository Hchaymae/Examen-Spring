package org.arch.springexam.controller;

import org.arch.springexam.entity.Employee;
import org.arch.springexam.entity.EmployeeProjectId;
import org.arch.springexam.entity.EmployeeSkill;
import org.arch.springexam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public int addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployeeService(employee);
    }

    @GetMapping("/affectation")
    public String showAffectationPage(Model model) {
        List<Employee> employees = employeeService.findAllService();
        model.addAttribute("employees", employees);
        return "affectation";
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAllService();
    }

    @PostMapping("/assignProject")
    public int assignProject(@RequestParam int employeeId, @RequestParam int projectId, @RequestParam double charge) {
        return employeeService.affecterprojectService(employeeId, projectId, charge);
    }

    @DeleteMapping("/deleteSkill/{skillId}")
    public void deleteSkill(@PathVariable int skillId) {
        employeeService.deleteSkillService(skillId);
    }

    @DeleteMapping("/deleteProject")
    public void deleteProject(@RequestBody EmployeeProjectId projectId) {
        employeeService.deleteProjectService(projectId);
    }

    @DeleteMapping("/{employeeId}")
    public int deleteEmployee(@PathVariable int employeeId) {
        return employeeService.deleteEmployeeService(employeeId);
    }

    @GetMapping("/findByName/{name}")
    public int findEmployeeIdByName(@PathVariable String name) {
        return employeeService.findEmployeeIdByNameService(name);
    }

    @GetMapping("/allDetails")
    public List<Employee> findAllEmployeesSkillsProjects() {
        return employeeService.findAllEmployeesSkillsProjectsService();
    }

    @GetMapping("/skills/{employeeId}")
    public List<EmployeeSkill> findSkillsByEmployeeId(@PathVariable int employeeId) {
        return employeeService.findSkillsEmployeeById(employeeId);
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return employeeService.findEmployeeByIdService(id);
    }
}