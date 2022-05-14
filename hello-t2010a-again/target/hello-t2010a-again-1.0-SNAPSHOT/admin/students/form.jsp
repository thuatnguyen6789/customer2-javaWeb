<%@ page import="com.t2010a.hellot2010aagain.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 5/12/22
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student student = (Student) request.getAttribute("student");
    int action = (int) request.getAttribute("action");
    String url = "/admin/students/create";
    if(action == 2){
        url = "/admin/students/edit";
    }
%>
<html>
<head>
    <title>Create new student</title>
</head>
<body>
    <h1>Create student</h1>
    <a href="/admin/students/list">Back to list</a>
    <form action="<%=url%>" method="post">
        <div>Rollnumber
            <input type="text" name="rollNumber" value="<%=student.getRollNumber()%>" <%=action == 2 ? "readonly":""%>></div>
        <div>Fullname <input type="text" name="fullName" value="<%=student.getFullName()%>"></div>
        <div>Email <input type="email" name="email" value="<%=student.getEmail()%>"></div>
        <div>Phone <input type="text" name="phone" value="<%=student.getPhone()%>"></div>
        <div>Birthday <input type="date" name="birthday" value="<%=student.getDobString()%>"></div>
        <div>
            <input type="submit" value="Save">
            <input type="reset" value="Reset">
        </div>
    </form>
</body>
</html>
