<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>部门</title>
</head>
<body>
    <div>
        <div>
            <h2>部门列表</h2>
        </div>
        <a href="/department/input">新增</a>
        <table width="50%" border="1" cellpadding="0" cellspacing="0">
            <tr align="center">
                <td>ID</td>
                <td>名称</td>
                <td>编号</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${departments}" var="department">
                <tr align="center">
                    <td>${department.id}</td>
                    <td>${department.name}</td>
                    <td>${department.sn}</td>
                    <td><a href="/department/delete?id=${department.id}">删除</a> <a href="/department/input?id=${department.id}">修改</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
