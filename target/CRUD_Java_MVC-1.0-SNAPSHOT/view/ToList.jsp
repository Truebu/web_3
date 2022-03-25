<%--
  Created by IntelliJ IDEA.
  User: juanc
  Date: 11/03/2022
  Time: 03:56 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page import="com.example.crud_java_mvc.model.dto.UserDto" %>
<%@ page import="com.example.crud_java_mvc.model.entites.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>JSP Page</title>
</head>
<body>
<div class = "container">
    <H1>Usuarios</H1>
    <a class="btn btn-success" href="UserController?action=ToAdd"> agregar usuarios</a>
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th class="text-center">ID</th>
            <th class="text-center">CEDULA</th>
            <th class="text-center">NOMBRES</th>
            <th class="text-center">ACCIONES</th>
        </tr>
        </thead>
        <%
            UserDto UserDto = new UserDto();
            List<User> listUser = UserDto.toList();
            Iterator<User> iter = listUser.iterator();
            User user = null;
            while(iter.hasNext()){
                user = iter.next();
        %>
        <tbody>
        <tr>
            <td class="text-center"><%=user.getId()%></td>
            <td class="text-center"><%=user.getDni()%></td>
            <td class="text-center"><%=user.getName()%></td>
            <td>
                <a class="btn btn-warning" href="UserController?action=ToEdit&id=<%=user.getId()%>">Edite</a>
                <a class="btn btn-danger" href="UserController?action=ToDelete&id=<%=user.getId()%>">Remove</a>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
