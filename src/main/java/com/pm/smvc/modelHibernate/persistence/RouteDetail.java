package com.pm.smvc.modelHibernate.persistence;

import javax.persistence.*;

@Entity
@Table(name = "routes_detail")
public class RouteDetail {

    private int id;
    private String info;

    public RouteDetail() {}

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return String.format("Routes detail %d: {info: %s}", getId(), getInfo());
    }
}
