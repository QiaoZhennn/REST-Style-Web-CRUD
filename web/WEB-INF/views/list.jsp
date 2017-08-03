<%--
  Created by IntelliJ IDEA.
  User: qiaoz
  Date: 2017/7/19
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AllEmps</title>
    <script type="text/javascript" src="/script/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var $empName=$(this).parents("tr").children().eq(1).text();
                var flag=confirm("确认删除"+$empName);
                if(flag){
                    var href=$(this).attr("href");
                    $("#deleteForm").attr("action",href).submit();
                }
                return false;
            });
        });
    </script>
</head>
<body>
<form id="deleteForm" action="" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>
<h1 align="center">员工信息列表</h1>
<table align="center" border="1px" cellspacing="0px" width="70%">
    <tr>
        <th>ID</th>
        <th>LastName</th>
        <th>Email</th>
        <th>Gender</th>
        <th>DeptName</th>
        <th>Operation</th>
    </tr>

    <c:forEach items="${requestScope.emps}" var="emp">
        <tr align="center">
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender=="M"?"Male":"Female"}</td>
            <td>${emp.department.departmentName}</td>
            <td>
                <a class="delete" href="emp/${emp.id}">删除</a> |
                <a href="emp/${emp.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<a href="/emp">Add a new employee</a>
</body>
</html>
