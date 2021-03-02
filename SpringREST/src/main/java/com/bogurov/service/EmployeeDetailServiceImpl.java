package com.bogurov.service;

import com.bogurov.dao.EmployeeDetailDAO;
import com.bogurov.entity.EmployeeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeDetailServiceImpl implements EmployeeDetailService{

    @Autowired
    private EmployeeDetailDAO employeeDetailDAO;

    @Override
    @Transactional
    public void saveEmployeeDetail(EmployeeDetail employeeDetail) {
        employeeDetailDAO.saveEmployeeDetail(employeeDetail);
    }

    @Override
    @Transactional
    public EmployeeDetail getEmployeeDetail(int id) {
        return employeeDetailDAO.getEmployeeDetail(id);
    }

    @Override
    @Transactional
    public void deleteEmployeeDetail(int id) {
        employeeDetailDAO.deleteEmployeeDetail(id);
    }
}
