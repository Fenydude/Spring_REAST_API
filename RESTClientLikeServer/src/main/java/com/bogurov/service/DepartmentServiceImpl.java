package com.bogurov.service;

import com.bogurov.communication.Communication;
import com.bogurov.entity.Department;
import com.bogurov.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private Communication communication;

    @Override
    public List<Department> getAllDepartment() {
        return communication.getAllDepartments();
    }

    @Override
    public void saveDepartment(Department department) {
        communication.saveDepartment(department);
    }

    @Override
    public Department getDepartment(int id) {
        return communication.getDepartment(id);
    }

    @Override
    public void deleteDepartment(int id) {
        communication.deleteDepartment(id);
    }

    @Override
    public List<Employee> getEmployeeFromDepartment(int id) {
        return communication.getEmployeeFromDepartment(id);
    }

}
