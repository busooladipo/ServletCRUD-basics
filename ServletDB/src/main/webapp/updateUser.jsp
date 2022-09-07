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

    Username: <input type="text" name="username" value="${param.username}" required="required"/>
    Email: <input type="email" name="email" value="${param.email}" required="required"/>
    <input type="hidden" name="usersId" value="${param.usersId}"/>
    <input type="hidden" name="form" value="updateUser"/>

    <input type="submit" value="Update User"/>

</form>


</body>
</html>
