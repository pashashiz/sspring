package com.pm.smvc.modelHibernate.dao;

import com.pm.smvc.modelHibernate.persistence.Bus;
import com.pm.smvc.modelHibernate.persistence.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Repository
@Transactional
public class DriverDao {

    @Inject
    @Named("sessionFactory")
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Bus> getDrivers() {
        return currentSession().createCriteria(Driver.class).list();
    }

}
