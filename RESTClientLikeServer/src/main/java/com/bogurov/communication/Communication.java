package com.bogurov.communication;

import com.bogurov.entity.Department;
import com.bogurov.entity.Employee;
import com.bogurov.entity.EmployeeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

    // Reference for work with REST API
    private final String EMP_URL = "http://localhost:8080/api/employees";
    private final String DEP_URL = "http://localhost:8080/api/departments";



    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(EMP_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});
        return responseEntity.getBody();
    }

    public Employee getEmployee(int id) {
        Employee employee = restTemplate.getForObject(EMP_URL + "/" + id,Employee.class);
        return employee;

    }

    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if (id == 0){
            // If id = 0, that means a new Employee
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(EMP_URL, employee, String.class);
            System.out.println("New employee was added to DB");
            System.out.println(responseEntity.getBody());
        }else{
            // Just update Employee from BD
            restTemplate.put(EMP_URL,employee);
            System.out.println("Employee was updated");
        }
    }
    public void deleteEmployee(int id){
        restTemplate.delete(EMP_URL + "/" + id);
        System.out.println("Employee with ID = " + id + "was deleted from DB");
    }

    public List<Department> getAllDepartments() {
        ResponseEntity<List<Department>> responseEntity =
                restTemplate.exchange(DEP_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Department>>() {});
        return responseEntity.getBody();
    }

    public Department getDepartment(int id) {
        Department department = restTemplate.getForObject(DEP_URL + "/" + id,Department.class);
        return department;

    }

    public void saveDepartment(Department department) {
        int id = department.getId();
        if (id == 0){
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(DEP_URL, department, String.class);
        }else{
            restTemplate.put(DEP_URL,department);
        }
    }
    public void deleteDepartment(int id){
        restTemplate.delete(DEP_URL + "/" + id);
    }

    public List<Employee> getEmployeeFromDepartment(int id){
        EmployeeList response = restTemplate.getForObject(DEP_URL + "/" + id + "/employees",
                EmployeeList.class);
        List<Employee> employees = response.getEmployeeList();
        return employees;
    }

}
