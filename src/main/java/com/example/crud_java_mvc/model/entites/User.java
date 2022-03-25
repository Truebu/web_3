package com.example.crud_java_mvc.model.entites;

public class User {

    int id;
    int dni;
    String name;

    public User(int id, int dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
