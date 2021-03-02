package com.bogurov.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "employees_details")
public class EmployeeDetail {
    @JsonView(View.EmployeeFromDepartment.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int details_id;
    @JsonView(View.EmployeeFromDepartment.class)
    @Column(name = "city")
    private String city;
    @JsonView(View.EmployeeFromDepartment.class)
    @Column(name = "phone_number")
    private String phoneNumber;
    @JsonView(View.EmployeeFromDepartment.class)
    @Column(name = "email")
    private String email;

    public EmployeeDetail() {
    }

    public EmployeeDetail(String city, String phoneNumber, String email) {
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getDetails_id() {
        return details_id;
    }

    public void setDetails_id(int id) {
        this.details_id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
