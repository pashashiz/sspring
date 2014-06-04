package com.pm.smvc.modelHibernate.dao;

import com.pm.smvc.modelHibernate.persistence.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.inject.Named;

@Repository
public class UserDao {

    @Inject
    @Named("sessionFactory")
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addUser(User user) {
        currentSession().save(user);
    }

    public User getUserById(int id) {
        return (User) currentSession().get(User.class, id);
    }

    public void save(User user) {
        currentSession().update(user);
    }
}
