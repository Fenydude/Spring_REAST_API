package com.bogurov.entity;

import java.util.List;

public class Department {
    private int id;
    private String name;
    private String department;
    private DepartmentDetail departmentDetail;

    private List<Employee> employeeList;
    public Department() {
    }

    public Department(String name, String department, DepartmentDetail departmentDetail, List<Employee> employeeList) {
        this.name = name;
        this.department = department;
        this.departmentDetail = departmentDetail;
        this.employeeList = employeeList;
    }


    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public DepartmentDetail getDepartmentDetail() {
        return departmentDetail;
    }

    public void setDepartmentDetail(DepartmentDetail departmentDetail) {
        this.departmentDetail = departmentDetail;
    }

    public List<Employee> getEmployee() {
        return employeeList;
    }

    public void setEmployee(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", departmentDetail=" + departmentDetail +
                ", employeeList=" + employeeList +
                '}';
    }
}
