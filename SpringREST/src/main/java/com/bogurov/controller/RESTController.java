package com.bogurov.controller;

import com.bogurov.entity.Department;
import com.bogurov.entity.Employee;
import com.bogurov.entity.EmployeeList;
import com.bogurov.entity.View;
import com.bogurov.exception_handing.NoSuchEmployeeException;
import com.bogurov.service.DepartmentService;
import com.bogurov.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    // Methods for work with employees

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    // We have to mark methods that Json uses
    @JsonView(View.EmployeeFromDepartment.class)
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);

        if (employee == null){
            throw new NoSuchEmployeeException("There is no employee with ID = "
                    + id + " in Database");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if (employee == null){
            throw new NoSuchEmployeeException("There is no employee with ID = "
                    + id + " in DataBase");
        }
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }




    // Methods for work with Departments

    @JsonView(View.Summary.class)
    @GetMapping("/departments")
    public List<Department> showAllDepartments(){
        List<Department> departments = departmentService.getAllDepartment();
        return departments;
    }

    @JsonView(View.Summary.class)
    @GetMapping("/departments/{id}")
    public Department getDepartments(@PathVariable int id){
        Department department = departmentService.getDepartment(id);

        if (department == null){
            throw new NoSuchEmployeeException("There is no department with ID = " + id + " in Database");
        }
        return department;
    }

    @PostMapping("/departments")
    public Department addNewDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return department;
    }

    @PutMapping("/departments")
    public Department updateDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return department;
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable int id){
        Department department = departmentService.getDepartment(id);
        if (department == null){
            throw new NoSuchEmployeeException("There is no department with ID = "
                    + id + " in DataBase");
        }
        departmentService.deleteDepartment(id);
        return "Department with ID = " + id + " was deleted";
    }

    @JsonView(View.SummaryWithEmployee.class)
    @GetMapping("/departments/{id}/employees")
    public EmployeeList getEmployees(@PathVariable int id){
        Department department = departmentService.getEmployeesFromDepartment(id);
        EmployeeList employeeList = new EmployeeList(department.getEmployeeList());
        return employeeList;
    }


}
