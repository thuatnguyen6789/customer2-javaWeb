<%@ page import="com.t2010a.hellot2010aagain.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 5/12/22
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student student = (Student)request.getAttribute("student");
%>
<html>
<head>
    <title>Student detail</title>
</head>
<body>
    <h1>Student detail</h1>
    <a href="/admin/students/list">Back to list</a> &nbsp;
    <a href="/admin/students/create">Create new student</a>
    <div>
        Rollnumber: <%=student.getRollNumber()%>
    </div>
    <div>
        Fullname: <%=student.getFullName()%>
    </div>
</body>
</html>
