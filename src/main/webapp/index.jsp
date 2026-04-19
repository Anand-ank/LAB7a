<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Cookie</title>
</head>
<body>

<h2>Cookie Management</h2>

<form action="addCookie.jsp">
    Name: <input type="text" name="cname" required><br/><br/>
    Domain: <input type="text" name="domain" required><br/><br/>
    Max Expiry Age (sec): <input type="number" name="age" required><br/><br/>

    <input type="submit" value="Add Cookie">
</form>

</body>
</html>