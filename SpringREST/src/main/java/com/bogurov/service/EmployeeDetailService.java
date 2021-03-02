package com.bogurov.service;

import com.bogurov.entity.EmployeeDetail;

public interface EmployeeDetailService {
    public void saveEmployeeDetail(EmployeeDetail employeeDetail);
    public EmployeeDetail getEmployeeDetail(int id);
    public void deleteEmployeeDetail(int id);
}
