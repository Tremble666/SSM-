<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/7
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工新增或修改</title>
</head>
<body>
    <form action="/employee/saveOrUpdate" method="post">
        <input type="hidden" name="id" value="${employee.id}"><br/>
        <input type="text" name="name" placeholder="名称" value="${employee.name}"><br/>
        <input type="text" name="password" placeholder="密码" value="${employee.password}"><br/>
        <input type="text" name="email" placeholder="邮箱" value="${employee.email}"><br/>
        <input type="text" name="age" placeholder="年龄" value="${employee.age}"><br/>
        <input type="text" name="admin" placeholder="管理员" value="${employee.admin}"><br/>
        <select name="dept.id">
            <option value="-1">请选择</option>
            <c:forEach items="${depts}" var="dept">
                <option value="${dept.id}" <c:if test="${dept.id == employee.dept.id}">selected</c:if>>${dept.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="保存">
    </form>
</body>
</html>
