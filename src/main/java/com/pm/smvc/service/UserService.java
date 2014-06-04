package com.pm.smvc.service;

import com.pm.smvc.modelHibernate.dao.UserDao;
import com.pm.smvc.modelHibernate.persistence.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserService {

    @Inject
    private UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public void save(User user) {
        userDao.save(user);
    }

}
