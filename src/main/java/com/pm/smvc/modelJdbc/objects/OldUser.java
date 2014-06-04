package com.pm.smvc.modelJdbc.objects;

public class OldUser {

    private int id;
    private String name;
    private String role;
    private String password;

    public OldUser(int id, String name, String role, String password) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public OldUser(String name, String role, String password) {
        this.id = -1;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return String.format("OldUser: {id: %s, name: %s, password: %s, role: %s}", id, name, password, role);
    }

}
