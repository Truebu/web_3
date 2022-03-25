package com.example.crud_java_mvc.business.controller;

import com.example.crud_java_mvc.model.dto.UserDto;
import com.example.crud_java_mvc.model.entites.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserController", value = "/UserController")
public class UserController extends HttpServlet {

    String toList = "view/ToList.jsp";
    String toAdd = "view/ToAdd.jsp";
    String toEdit = "view/ToEdit.jsp";
    User user = new User();
    UserDto userDto= new UserDto();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String access = "";
        String acttion = request.getParameter("action");
        if (acttion.equalsIgnoreCase("ToList")){
            access = toList;
        }else if (acttion.equalsIgnoreCase("ToAdd")){
            access = toAdd;
        }else if (acttion.equalsIgnoreCase("ToEdit")){
            request.setAttribute("idUser", request.getParameter("id"));
            access = toEdit;
        }else if (acttion.equalsIgnoreCase("agregar")){
            user.setDni(Integer.parseInt(request.getParameter("txtDni")));
            user.setName(request.getParameter("txtName"));
            userDto.add(user);
            access = toList;
        }else if (acttion.equalsIgnoreCase("actualizar")){
            user.setId(Integer.parseInt(request.getParameter("txtId")));
            user.setDni(Integer.parseInt(request.getParameter("txtDni")));
            user.setName(request.getParameter("txtName"));
            userDto.edit(user);
            access = toList;
        }else if (acttion.equalsIgnoreCase("ToDelete")){
            userDto.delete(Integer.parseInt(request.getParameter("id")));
            access = toList;
        }
        RequestDispatcher dispatcher =  request.getRequestDispatcher(access);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
