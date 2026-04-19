<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Check</title>
</head>
<body>

<h2>Display the session value</h2>

<%
    String name = (String) session.getAttribute("user");

    if (name == null) {
        out.print("<h3 style='color:red;'>Sorry, session has expired!</h3>");
        out.print("<a href='index.html'>Start Again</a>");
    } else {
        out.print("<h3>Hello " + name + ", your session is active!</h3>");
    }
%>

</body>
</html>