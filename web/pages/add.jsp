<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<%--
  Created by IntelliJ IDEA.
  User: misch
  Date: 15.12.2017
  Time: 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<form method="post">
    <label>Name:
        <input type="text" name="name"><br />
    </label>

    <label>Password:
        <input type="password" name="password"><br />
    </label>
    <button type="submit">Submit</button>
</form>
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
