package com.bogurov.dao;

import com.bogurov.entity.DepartmentDetail;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDetailDAOImpl implements DepartmentDetailDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveDepartmentDetail(DepartmentDetail departmentDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(departmentDetail);
    }

    @Override
    public DepartmentDetail getDepartmentDetail(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(DepartmentDetail.class, id);
    }

    @Override
    public void deleteDepartmentDetail(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<DepartmentDetail> query = session.createQuery("delete from DepartmentDetail "+
                "where id=:detailsId");
        query.setParameter("detailsId", id);
        query.executeUpdate();

    }
}
