package com.bogurov.service;

import com.bogurov.dao.DepartmentDetailDAO;
import com.bogurov.entity.DepartmentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentDetailServiceImpl implements DepartmentDetailService{
    @Autowired
    private DepartmentDetailDAO departmentDetailDAO;
    @Override
    @Transactional
    public void saveDepartmentDetail(DepartmentDetail departmentDetail) {
        departmentDetailDAO.saveDepartmentDetail(departmentDetail);
    }

    @Override
    @Transactional
    public DepartmentDetail getDepartmentDetail(int id) {
        return departmentDetailDAO.getDepartmentDetail(id);
    }

    @Override
    @Transactional
    public void deleteDepartmentDetail(int id) {
        departmentDetailDAO.deleteDepartmentDetail(id);
    }
}
