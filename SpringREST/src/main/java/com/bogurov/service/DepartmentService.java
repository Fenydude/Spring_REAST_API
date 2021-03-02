package com.bogurov.service;

import com.bogurov.entity.Department;
import com.bogurov.entity.Employee;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAllDepartment();
    public void saveDepartment(Department department);
    public Department getDepartment(int id);
    public void deleteDepartment(int id);
    public Department getEmployeesFromDepartment(int id);
}
