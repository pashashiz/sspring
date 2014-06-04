package com.pm.smvc.modelHibernate.persistence;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "drivers")
public class Driver {

    private int id;
    private String name;
    private String surname;
    private int age;
    private Set<Bus> busses;

    public Driver() {}

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bus_driver_link", joinColumns = {@JoinColumn(name = "driver_id")},
            inverseJoinColumns = {@JoinColumn(name = "bus_id")})
    public Set<Bus> getBusses() {
        return busses;
    }

    public void setBusses(Set<Bus> busses) {
        this.busses = busses;
    }

    @Override
    public String toString() {
        return String.format("Driver %d: {name: %s, surname: %s, age: %d, busses: %s}",
                getId(), getName(), getSurname(), getAge(), getBusses());
    }
}
