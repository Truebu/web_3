package com.example.crud_java_mvc.model.dto;

import com.example.crud_java_mvc.business.service.CRUD;
import com.example.crud_java_mvc.config.ConnectionDB;
import com.example.crud_java_mvc.model.entites.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements CRUD {

    ConnectionDB cn = new ConnectionDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    User u = new User();

    @Override
    public List<User> toList() {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from user";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("Id"));
                user.setDni(rs.getInt("DNI"));
                user.setName(rs.getString("Name"));
                list.add(user);
            }
        }catch (Exception ex){

        }
        return list;
    }

    @Override
    public User getById(int id) {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from user where id = "+ id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                u.setId(rs.getInt("Id"));
                u.setDni(rs.getInt("DNI"));
                u.setName(rs.getString("Name"));
            }
        }catch (Exception ex){

        }
        return u;
    }

    @Override
    public boolean add(User user) {

        String sql = "insert into user(dni, name) values ('"+user.getDni()+"', '"+ user.getName()+"')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean edit(User user) {
        String sql = "update user set dni ='"+user.getDni()+"', name ='"+ user.getName()+"' where id ="+user.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from user where id ="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }catch (Exception e){

        }
        return false;
    }
}
