package com.bogurov.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @JsonView({View.SummaryWithEmployee.class, View.EmployeeFromDepartment.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonView({View.SummaryWithEmployee.class, View.EmployeeFromDepartment.class})
    private String name;
    @JsonView({View.SummaryWithEmployee.class, View.EmployeeFromDepartment.class})
    private String surname;
    @JsonView({View.SummaryWithEmployee.class, View.EmployeeFromDepartment.class})
    private int salary;
    @JsonView({View.SummaryWithEmployee.class, View.EmployeeFromDepartment.class})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private EmployeeDetail employeeDetail;

    @JsonView(View.EmployeeFromDepartment.class)
    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {
    }

    public Employee(String name, String surname, int salary, EmployeeDetail employeeDetail, Department department) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.employeeDetail = employeeDetail;
        this.department = department;
    }

  

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public EmployeeDetail getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(EmployeeDetail employeeDetail) {
        this.employeeDetail = employeeDetail;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
