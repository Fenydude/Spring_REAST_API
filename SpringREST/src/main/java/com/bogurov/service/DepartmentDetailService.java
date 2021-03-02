package com.bogurov.service;

import com.bogurov.entity.DepartmentDetail;

public interface DepartmentDetailService {
    public void saveDepartmentDetail(DepartmentDetail departmentDetail);
    public DepartmentDetail getDepartmentDetail(int id);
    public void deleteDepartmentDetail(int id);
}
