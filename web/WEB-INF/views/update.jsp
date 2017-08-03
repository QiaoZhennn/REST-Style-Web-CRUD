<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: qiaoz
  Date: 2017/7/19
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form:form action="/emp" method="post" modelAttribute="employee">
<table>
    <tr>
        <td>LastName</td>
        <td>
            <c:if test="${empty employee.id}">
                <form:input path="lastName"/>
            </c:if>
            <c:if test="${not empty employee.id}">
                <span>${employee.lastName}</span>
                <form action="/emp" method="post">
                    <input type="hidden" name="_method" value="PUT">
                </form>
                <form:hidden path="id"/>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>Email</td>
        <td>
            <form:input path="email"/>
        </td>
    </tr>
    <tr>
        <td>Gender</td>
        <%
            Map<String, String> gender = new HashMap<String, String>();
            gender.put("M", "Male");
            gender.put("F", "Female");
            request.setAttribute("gender", gender);
        %>
        <td>
            <form:radiobuttons path="gender" items="${requestScope.gender}"/>
        </td>
    </tr>
    <tr>
        <td>Department</td>
        <td>
            <form:select path="department.id" items="${requestScope.departments}" itemLabel="departmentName"
                         itemValue="id"/>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${empty employee.lastName}">
                <input type="submit" value="添加员工">
            </c:if>
            <c:if test="${not empty employee.lastName}">
                <input type="submit" value="修改员工">
            </c:if>
        </td>
    </tr>
    </table>
</form:form>
</body>
</html>
