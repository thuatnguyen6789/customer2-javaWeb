<%@ page import="com.t2010a.hellot2010aagain.entity.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 5/12/22
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Student> listStudent = (List<Student>)request.getAttribute("listStudent");
%>
<html>
<head>
    <title>List student</title>
</head>
<body>
    <h1>List student</h1>
    <a href="/admin/students/create">Create new student</a>
    <ul>
        <%for (Student st : listStudent) {
        %>
            <li>
                <%=st.getRollNumber()%> - <%=st.getFullName()%>
                <a href="/admin/students/detail?id=<%=st.getRollNumber()%>">Detail</a>&nbsp;&nbsp;
                <a href="/admin/students/edit?id=<%=st.getRollNumber()%>">Edit</a>&nbsp;&nbsp;
                <a href="/admin/students/delete?id=<%=st.getRollNumber()%>" onclick="confirm('Are you sure?')">Delete</a>
            </li>
        <%}%>
    </ul>
</body>
</html>
