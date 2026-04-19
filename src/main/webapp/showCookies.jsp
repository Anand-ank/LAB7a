<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="javax.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
%>
            <p>
                <b>Name:</b> <%= c.getName() %> <br>
                <b>Value:</b> <%= c.getValue() %> <br><br>
            </p>
<%
        }
    } else {
%>
        <p>No active cookies found.</p>
<%
    }
%>

</body>
</html>