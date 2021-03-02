package com.bogurov.controller;

import com.bogurov.entity.Department;
import com.bogurov.entity.Employee;
import com.bogurov.service.DepartmentService;
import com.bogurov.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainEmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    // Methods for work with employees
    @GetMapping("/showDepartments/{depId}/showEmployee/{empId}")
    public String showEmployee(@PathVariable int depId, @PathVariable int empId, Model model) {
        Employee employee = employeeService.getEmployee(empId);
        model.addAttribute("emp", employee);
        model.addAttribute("depId", depId);
        return "infoEmployee";
    }

    @PostMapping("/showDepartments/{depId}/showEmployees")
    public String saveEmployee(@PathVariable int depId, @ModelAttribute("emp") Employee employee) {
        Department department = departmentService.getDepartment(depId);
        employee.setDepartment(department);
        employeeService.saveEmployee(employee);
        return "redirect:/showDepartments";
    }

    @PostMapping("/showDepartments/{depId}/showEmployee/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/showDepartments";
    }

    @GetMapping("/showDepartments/{depId}/showEmployee/addEmployee")
    public String addEmployee(@PathVariable int depId, Model model) {
        Employee employee = new Employee();
        model.addAttribute("emp", employee);
        model.addAttribute("depId", depId);
        return "addEmployee";
    }


    // Code for work with Departments
    @GetMapping("/showDepartments")
    public String showAllDepartments(Model model) {
        List<Department> departments = departmentService.getAllDepartment();
        model.addAttribute("departments", departments);
        return "allDepartments";
    }

    @GetMapping("/showDepartments/{id}")
    public String showDepartment(@PathVariable int id, Model model) {
        Department department = departmentService.getDepartment(id);
        model.addAttribute("department", department);
        return "infoDepartment";
    }

    @GetMapping("/showDepartments/{id}/showEmployees")
    public String showEmployees(@PathVariable int id, Model model) {
        List<Employee> employees = departmentService.getEmployeeFromDepartment(id);
        model.addAttribute("employees", employees);
        model.addAttribute("depId", id);
        return "showEmployeesFromDepartment";
    }

    @PostMapping("/showDepartments")
    public String saveOrUpdate(@ModelAttribute("department") Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/showDepartments";
    }

    @GetMapping("/showDepartments/addDepartment")
    public String addDepartment(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "addDepartment";
    }

    @PostMapping("/showDepartments/delete/{id}")
    public String deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
        return "redirect:/showDepartments";
    }


}
