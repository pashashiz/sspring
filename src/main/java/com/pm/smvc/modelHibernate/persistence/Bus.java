package com.pm.smvc.modelHibernate.persistence;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "busses")
@NamedQueries({
        @NamedQuery(name = "Bus.getBusByRouteNumber",  query = "from Bus as b where b.route.number = :routeNumber")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "Bus.getBusById", query = "SELECT * FROM busses where id = :id", resultClass = Bus.class)
})
public class Bus {

    private int id;
    private int number;
    private Route route;
    private Set<Driver> drivers;

    public Bus() {}

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id")
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @ManyToMany(mappedBy = "busses", fetch = FetchType.EAGER)
    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return String.format("Bus %d: {number: %d, route: %s, drivers count: %d}",
                getId(), getNumber(), getRoute(), getDrivers().size());
    }
}
