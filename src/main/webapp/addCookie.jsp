<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
    String name = request.getParameter("cname");
    String domain = request.getParameter("domain");
    int age = Integer.parseInt(request.getParameter("age"));

    // Create cookie
    Cookie ck = new Cookie(name, "ActiveUser");

    // Set domain and expiry
    ck.setDomain(domain);
    ck.setMaxAge(age);

    // Add cookie to response
    response.addCookie(ck);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Cookie Added</title>
</head>
<body>

<h2>Cookie Created Successfully!</h2>

<p><b>Name:</b> <%= name %></p>
<p><b>Domain:</b> <%= domain %></p>
<p><b>Expiry Time:</b> <%= age %> seconds</p>

<a href="showCookies.jsp">Go to Active Cookie List</a>

</body>
</html>