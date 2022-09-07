<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 06/09/2022
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<h1>Add User</h1>
<a href="${pageContext.request.contextPath}/site?page=home">Home</a>
<a href="${pageContext.request.contextPath}/operation?page=listusers">User List</a>

<form action="${pageContext.request.contextPath}/operation" method="post">
  Username: <input type="text" name="username" required="required"/>
  Email: <input type="email" name="email" required="required"/>

  <input type="hidden" name="form" value="addUser">

  <input type="submit" value="Add User">

</form>


</body>
</html>
