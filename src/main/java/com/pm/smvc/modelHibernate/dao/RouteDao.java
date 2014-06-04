package com.pm.smvc.modelHibernate.dao;

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
public class RouteDao {

    private Logger logger = Logger.getLogger(getClass());

    @Inject
    @Named("sessionFactory")
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Route> getRoutes() {
        return currentSession().createCriteria(Route.class).list();
    }

    public Route getHQRouteById(int id) {
        Route route = null;
        Query query = currentSession().getNamedQuery("Route.getRouteById").setInteger("id", 1);
        List result = query.list();
        if (result != null && result.size() > 0)
            route = (Route) result.get(0);
        return route;
    }

}
