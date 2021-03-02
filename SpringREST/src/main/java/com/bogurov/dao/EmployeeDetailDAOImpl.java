package com.bogurov.dao;

import com.bogurov.entity.EmployeeDetail;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDetailDAOImpl implements EmployeeDetailDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveEmployeeDetail(EmployeeDetail employeeDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employeeDetail);
    }

    @Override
    public EmployeeDetail getEmployeeDetail(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(EmployeeDetail.class, id);
    }

    @Override
    public void deleteEmployeeDetail(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<EmployeeDetail> query = session.createQuery("delete from EmployeeDetail "+
                "where id =:employeeDetailId");
        query.setParameter("employeeDetailId", id);
        query.executeUpdate();
    }
}
