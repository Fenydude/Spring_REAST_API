package com.bogurov.dao;

import com.bogurov.entity.EmployeeDetail;

public interface EmployeeDetailDAO {
    public void saveEmployeeDetail(EmployeeDetail employeeDetail);
    public EmployeeDetail getEmployeeDetail(int id);
    public void deleteEmployeeDetail(int id);
}
