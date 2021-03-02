package com.bogurov.dao;

import com.bogurov.entity.Department;
import com.bogurov.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Department> getAllDepartment() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Department ",
                Department.class).getResultList();
    }

    @Override
    public void saveDepartment(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(department);
    }

    @Override
    public Department getDepartment(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Department.class, id);
    }

    @Override
    public void deleteDepartment(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Department> query = session.createQuery("delete from Department "+
                "where id =:departId");
        query.setParameter("departId", id);
        query.executeUpdate();
    }

    @Override
    public Department getEmployeesFromDepartment(int id) {
        Session session = sessionFactory.getCurrentSession();
        Department department = session.get(Department.class, id);
        if (!department.getEmployeeList().isEmpty()){
            department.getEmployeeList().get(0);
        }
        return department;
    }
}
