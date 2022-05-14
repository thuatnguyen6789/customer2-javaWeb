<%@ page import="com.t2010a.hellot2010aagain.entity.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 5/12/22
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Customer> listCustomer = (List<Customer>)request.getAttribute("listCustomer");
%>
<html>
<head>
    <title>List customer</title>
</head>
<body>
    <h1>List customer</h1>
    <a href="/admin/customers/create">Create new customer</a>
    <ul>
        <%for (Customer st : listCustomer) {
        %>
            <li>
                <%=st.getCustomerID()%> - <%=st.getFullName()%>
                <a href="/admin/customers/detail?id=<%=st.getCustomerID()%>">Detail</a>&nbsp;&nbsp;
                <a href="/admin/customers/edit?id=<%=st.getCustomerID()%>">Edit</a>&nbsp;&nbsp;
                <a href="/admin/customers/delete?id=<%=st.getCustomerID()%>" onclick="confirm('Are you sure?')">Delete</a>
            </li>
        <%}%>
    </ul>
</body>
</html>
