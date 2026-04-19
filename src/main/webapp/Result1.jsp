<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<body>

<h2>Student Result</h2>

<%
    if (request.getAttribute("error") != null) {
%>
    <p style="color:red;"><%= request.getAttribute("error") %></p>
<%
    } else {
%>

Roll No: <%= request.getAttribute("rollno") %><br>
Name: <%= request.getAttribute("name") %><br>

Marks:
<ul>
<li>Sub1: <%= request.getAttribute("s1") %></li>
<li>Sub2: <%= request.getAttribute("s2") %></li>
<li>Sub3: <%= request.getAttribute("s3") %></li>
<li>Sub4: <%= request.getAttribute("s4") %></li>
<li>Sub5: <%= request.getAttribute("s5") %></li>
</ul>

Average: <%= request.getAttribute("average") %><br>
Result: <b><%= request.getAttribute("result") %></b><br><br>

<%
    }
%>

<a href="index1.jsp">Back to Form</a>

</body>
</html>