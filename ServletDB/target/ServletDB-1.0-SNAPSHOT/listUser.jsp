<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 05/09/2022
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ease.entity.User" %>

<html>
<head>
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<a href="${pageContext.request.contextPath}/site?page=home">Home</a>
<a href="${pageContext.request.contextPath}/operation?page=adduser">Add User</a>

<table>
    <thead>
    <th>User ID</th>
    <th>Username</th>
    <th>Email</th>
    <th>Operation</th>
    </thead>
    <%!String deleteURL;%>
    <%
        List<User> listUsers = (List<User>) request.getAttribute("listUsers");
        String updateURL;
        for (int i = 0; i < listUsers.size(); i ++) {
            out.print("<tr>");
            out.print("<td>"+listUsers.get(i).getUsers_id()+"</td>");
            out.print("<td>"+listUsers.get(i).getUsers_name()+"</td>");
            out.print("<td>"+listUsers.get(i).getUsers_email()+"</td>");
            updateURL = request.getContextPath() + "/operation?page=updateUser"+
                    "&usersId=" + listUsers.get(i).getUsers_id()+
                    "&username=" + listUsers.get(i).getUsers_name()+
                    "&email=" + listUsers.get(i).getUsers_email();
            deleteURL = request.getContextPath() + "/operation?page=deleteUser"+
                    "&usersId=" + listUsers.get(i).getUsers_id();
            out.print("<td><a href ="+ updateURL +">update</a> | ");
    %>
    <a href="<%=deleteURL%>" onclick="if(!confirm('Are you sure you want to delete the user?')) return false">delete</a>
    </td>
  </tr>
    <%
        }
    %>
</table>

</body>
</html>
