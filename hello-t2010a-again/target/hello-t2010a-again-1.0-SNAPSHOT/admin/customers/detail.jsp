<%@ page import="com.t2010a.hellot2010aagain.entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 5/12/22
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Customer customer = (Customer) request.getAttribute("customer");
%>
<html>
<head>
    <title>Customer detail</title>
</head>
<body>
    <h1>Customer detail</h1>
    <a href="/admin/customers/list">Back to list</a> &nbsp;
    <a href="/admin/customers/create">Create new customer</a>
    <div>
        CustomerID: <%=customer.getCustomerID()%>
    </div>
    <div>
        Fullname: <%=customer.getFullName()%>
    </div>
</body>
</html>
