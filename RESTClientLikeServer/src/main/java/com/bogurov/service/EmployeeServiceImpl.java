package com.bogurov.service;

import com.bogurov.communication.Communication;
import com.bogurov.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private Communication communication;

    @Override
    public List<Employee> getAllEmployees() {
        return communication.getAllEmployees();
    }

    @Override
    public Employee getEmployee(int id) {
        return communication.getEmployee(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        communication.saveEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        communication.deleteEmployee(id);
    }

}
