<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: misch
  Date: 15.12.2017
  Time: 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users</title>
</head>
<body>
<!-- html код -->
<%
    List<String> names = (List<String>) request.getAttribute("UN");

    if (names != null && !names.isEmpty()) {
        out.println("<ui>");
        for (String s : names) {
            out.println("<li>" + s + "</li>");
        }
        out.println("</ui>");
    } else out.println("<p>There are no users yet!</p>");
%>
<!-- html код -->
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
