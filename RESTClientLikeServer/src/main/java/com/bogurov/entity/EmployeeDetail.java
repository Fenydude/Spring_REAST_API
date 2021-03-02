package com.bogurov.entity;


public class EmployeeDetail {
    private int details_id;
    private String city;
    private String phoneNumber;
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
