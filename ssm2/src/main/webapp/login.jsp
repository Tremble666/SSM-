<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/7
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <span style="color: red">${error}</span>
    <form action="/login" method="post">
        用户:<input type="text" name="name"><br/>
        密码:<input type="text" name="password"> <br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
