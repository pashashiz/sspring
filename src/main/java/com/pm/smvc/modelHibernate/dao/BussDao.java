package com.pm.smvc.modelHibernate.dao;

import com.pm.smvc.modelHibernate.persistence.Bus;
import com.pm.smvc.modelHibernate.persistence.Route;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Repository
@Transactional
public class BussDao {

    @Inject
    @Named("sessionFactory")
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Bus> getBusses() {
        return currentSession().createCriteria(Bus.class).list();
    }

    public Bus getBus(int id) {
        return (Bus) currentSession().get(Bus.class, id);
    }

    public void testFlush(int id, int newNumber) {
        Logger.getLogger(getClass()).info("Hello");
        Bus bus = (Bus) currentSession().get(Bus.class, 1);
        bus.setNumber(newNumber);
    }

    public Bus getHQBusByRouteNumber(int routeNumber) {
        Bus bus = null;
        Query query = currentSession().getNamedQuery("Bus.getBusByRouteNumber").setInteger("routeNumber", routeNumber);
        List result = query.list();
        if (result != null && result.size() > 0)
            bus = (Bus) result.get(0);
        return bus;
    }

    public Bus getNQBusById(int id) {
        Bus bus = null;
        Query query = currentSession().getNamedQuery("Bus.getBusById").setInteger("id", id);
        List result = query.list();
        if (result != null && result.size() > 0)
            bus = (Bus) result.get(0);
        return bus;
    }



}
