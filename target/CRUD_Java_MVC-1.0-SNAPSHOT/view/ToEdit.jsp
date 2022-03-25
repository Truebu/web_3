<%@ page import="com.example.crud_java_mvc.model.dto.UserDto" %>
<%@ page import="com.example.crud_java_mvc.model.entites.User" %><%--
  Created by IntelliJ IDEA.
  User: juanc
  Date: 11/03/2022
  Time: 03:56 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="col-lg-6">
        <%
            UserDto userDto= new UserDto();
            int id = Integer.parseInt((String) request.getAttribute("idUser"));
            User user = userDto.getById(id);
        %>
        <h1>Modificar usuario</h1>
        <form action="UserController">
            <dr>DNI:</dr>
            <input class="form-control" type="text" name="txtDni" value="<%=user.getDni() %>">
            <dr>Nombre:</dr>
            <input class="form-control" type="text" name="txtName" value="<%=user.getName() %>">
            <input type="hidden" name="txtId" value="<%=user.getId() %>">
            <input class="btn btn-primary" type="submit" name="action" value="actualizar">
            <a href="UserController?action=ToList">Regresar</a>
        </form>
    </div>
</div>
</body>
</html>
