<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Session Input</title>
</head>
<body>

<h2>Session Management</h2>

<form action="welcome.jsp">
    Enter Your Name:
    <input type="text" name="uname" required><br/><br/>

    Enter Session Expiry Time (in minutes):
    <input type="number" name="time" required><br/><br/>

    <input type="submit" value="Start Session">
</form>

</body>
</html>