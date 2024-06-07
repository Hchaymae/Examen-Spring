package org.arch.springexam.service;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import org.arch.springexam.dao.EmployeeDAO;
import org.arch.springexam.dao.jpa.EmployeeDAOJPA;
import org.arch.springexam.entity.Employee;
import org.arch.springexam.entity.EmployeeProjectId;
import org.arch.springexam.entity.EmployeeSkill;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private EmployeeDAO employeeDAO;
    private Employee employee;

    public EmployeeService() {
        employee = new Employee();
        this.employeeDAO = new EmployeeDAOJPA();
    }

    public int addEmployeeService(Employee employee) {
        int result = employeeDAO.addEmployee(employee);
        if (result > 0) {
            addSuccessMessage("Employee added successfully");
        } else {
            addErrorMessage("Error adding employee");
        }
        return result;
    }


    public List<Employee> findAllService() {
        return employeeDAO.findAll();
    }

    public int affecterprojectService(int employeeid, int projectid, double charge) {
        int result = employeeDAO.affecterproject(employeeid, projectid, charge);
        if (result > 0) {
            addSuccessMessage("Project assigned successfully");
        } else {
            addErrorMessage("Error assigning project");
        }
        return result;
    }

    public void deleteSkillService(int skillId) {
        employeeDAO.deleteSkill(skillId);
    }

    public void deleteProjectService(EmployeeProjectId projectId) {
         employeeDAO.deleteProject(projectId);
    }

    public int deleteEmployeeService(int employeeId) {
        int result = employeeDAO.deleteEmployee(employeeId);
        if (result > 0) {
            addSuccessMessage("Employee deleted successfully");
        } else {
            addErrorMessage("Error deleting employee");
        }
        return result;
    }


    public List<Employee> findAllByRole(String role) {
        return employeeDAO.findAllByRole(role);
    }
    public int findEmployeeIdByNameService(String name) {
        return employeeDAO.findEmployeeIdByName(name);
    }

    public List<Employee> findAllEmployeesSkillsProjectsService() {
        return employeeDAO.findAllEmployeesSkillsProjects();
    }

    public List<EmployeeSkill> findSkillsEmployeeById(int employeeid) {
        return employeeDAO.findSkillsByEmployeeId(employeeid);
    }

    public Employee findEmployeeByIdService(int id) {
        return employeeDAO.findEmployeeById(id);
    }

    /**
     * Adds an error message to the FacesContext.
     *
     * @param message The error message to be added.
     */
    private void addErrorMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

    /**
     * Adds a warning message to the FacesContext.
     *
     * @param message The warning message to be added.
     */
    private void addWarningMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, null));
    }

    /**
     * Adds a success message to the FacesContext.
     *
     * @param message The success message to be added.
     */
    private void addSuccessMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }
}
