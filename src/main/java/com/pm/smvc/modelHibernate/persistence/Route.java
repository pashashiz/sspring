package com.pm.smvc.modelHibernate.persistence;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "routes")
@NamedQueries({
        @NamedQuery(name = "Route.getRouteById", query = "from Route where id = :id"),
})
public class Route {

    private int id;
    private int number;
    private String name;
    private Set<Bus> busses;
    private RouteDetail routeDetail;

    public Route() {}

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    public Set<Bus> getBusses() {
        return busses;
    }

    public void setBusses(Set<Bus> busses) {
        this.busses = busses;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "routes_detail_id")
    public RouteDetail getRouteDetail() {
        return routeDetail;
    }

    public void setRouteDetail(RouteDetail routeDetail) {
        this.routeDetail = routeDetail;
    }

    @Override
    public String toString() {
        return String.format("Route %d: {number: %d, name: %s, detail: %s, buses count: %d}",
                getId(), getNumber(), getName(), getRouteDetail(), getBusses().size());
    }
}