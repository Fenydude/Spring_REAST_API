package com.bogurov.entity;

import java.util.LinkedList;
import java.util.List;

public class EmployeeList {
    private List<Employee> employeeList;

    public EmployeeList(){
        employeeList = new LinkedList<>();
    }

    public EmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
