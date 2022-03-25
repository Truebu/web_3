package com.example.crud_java_mvc.business.service;

import com.example.crud_java_mvc.model.entites.User;

import java.util.List;

public interface CRUD {

    public List<User> toList();
    public User getById(int id);
    public boolean add(User user);
    public boolean edit(User use);
    public boolean delete(int id);
}
