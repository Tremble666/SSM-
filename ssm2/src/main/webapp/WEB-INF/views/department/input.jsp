<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/7
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门新增或修改</title>
</head>
<body>
    <form action="/department/saveOrUpdate" method="post">
        <input type="hidden" name="id" value="${department.id}"><br/>
        <input type="text" name="name" placeholder="名称" value="${department.name}"><br/>
        <input type="text" name="sn" placeholder="编号" value="${department.sn}"><br/>
        <input type="submit" value="保存">
    </form>
</body>
</html>
