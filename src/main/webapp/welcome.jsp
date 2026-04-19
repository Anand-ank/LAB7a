<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<%
    String name = request.getParameter("uname");

    out.print("<h2>Hello " + name + "!</h2>");
    out.print("<p>Session has started...</p>");

    // Store in session
    session.setAttribute("user", name);

    out.print("<p>Your name has been stored in session object.</p>");

    // Set session expiry to 1 minute (60 seconds)
    session.setMaxInactiveInterval(60);

    out.print("<p>Session expiry time is set to 1 minute.</p>");
    out.print("<p>Click below link within 1 minute or wait to see session expiry.</p>");
%>

<a href="second.jsp">Display the value</a>

</body>
</html>