package com.pm.smvc.controllers;

import com.pm.smvc.modelHibernate.dao.BussDao;
import com.pm.smvc.modelHibernate.dao.DriverDao;
import com.pm.smvc.modelHibernate.dao.RouteDao;
import com.pm.smvc.modelHibernate.persistence.User;
import com.pm.smvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
public class LessonHibernateController {

    @Inject
    UserService userService;
    @Inject
    BussDao bussDao;
    @Inject
    RouteDao routeDao;
    @Inject
    DriverDao driverDao;

    @RequestMapping(value = {"lessons/hibernate/get_user"})
    public String getUserById(@RequestParam("id") int id, Model model) {
        id = (id > 0) ? id : 1;
        System.out.println("Start getting user, id: " + id);
        User user = userService.getUserById(id);
        System.out.println("Finish getting user: " + user);
        return "lessons/beans";
    }

    @RequestMapping(value = {"lessons/hibernate/get_busses"})
    public String getBusses(Model model) {
        System.out.println("Busses: " + bussDao.getBusses());
        return "lessons/beans";
    }

    @RequestMapping(value = {"lessons/hibernate/get_routes"})
    public String getRoutes(Model model) {
        System.out.println("Busses: " + routeDao.getRoutes());
        return "lessons/beans";
    }

    @RequestMapping(value = {"lessons/hibernate/get_drivers"})
    public String getDrivers(Model model) {
        System.out.println("Drivers: " + driverDao.getDrivers());
        return "lessons/beans";
    }

    @RequestMapping(value = {"lessons/hibernate/test_flush"})
    public String testFlush(Model model) {
        System.out.println("Bus before: " + bussDao.getBus(1));
        bussDao.testFlush(1, 11111);
        System.out.println("Bus test flush (change number)...");
        System.out.println("Bus after: " + bussDao.getBus(1));
        return "lessons/beans";
    }

    @RequestMapping(value = {"lessons/hibernate/test_hq"})
    public String testHQ(Model model) {
        System.out.println("Route by id = 1 (was getting by named query): " + routeDao.getHQRouteById(1));
        System.out.println("Bus by route number = 404 (was getting by named query): " + bussDao.getHQBusByRouteNumber(404));
        return "lessons/beans";
    }

    @RequestMapping(value = {"lessons/hibernate/test_nq"})
    public String testNQ(Model model) {
        System.out.println("Bus by id = 1 (was getting by named native query): " + bussDao.getNQBusById(1));
        return "lessons/beans";
    }



}
