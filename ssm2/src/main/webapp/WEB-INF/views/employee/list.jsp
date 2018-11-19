<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工</title>
    <script>
        function page(currentPage) {
            document.getElementById('currentPage').value = currentPage;
            document.getElementById('employee_form').submit();
        }
    </script>
</head>
<body>
    <form id="employee_form" action="/employee/list" method="post">
        <input type="hidden" id="currentPage" name="currentPage" value="1">
        <div>
            <div>
                <h2>员工列表</h2>
            </div>
            <div> <a href="/employee/input">新增</a></div>
            <div>
                关键字：<input type="text" name="keyword" value="${qo.keyword}">
                <select name="deptId">
                    <option value="-1">请选择</option>
                    <c:forEach items="${depts}" var="dept">
                        <option value="${dept.id}" <c:if test="${qo.deptId == dept.id}">selected</c:if>>${dept.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="查询">
            </div>
            <table width="50%" border="1" cellpadding="0" cellspacing="0">
                <tr align="center">
                    <td>ID</td>
                    <td>名称</td>
                    <td>密码</td>
                    <td>email</td>
                    <td>年龄</td>
                    <td>管理员</td>
                    <td>部门</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${pageResult.data}" var="employee">
                    <tr align="center">
                        <td>${employee.id}</td>
                        <td>${employee.name}</td>
                        <td>${employee.password}</td>
                        <td>${employee.email}</td>
                        <td>${employee.age}</td>
                        <td>${employee.admin}</td>
                        <td>${employee.dept.name}</td>
                        <td><a href="/employee/delete?id=${employee.id}">删除</a> <a href="/employee/input?id=${employee.id}">修改</a></td>
                    </tr>
                </c:forEach>
            </table>
            <div>
                当前页：${pageResult.currentPage} / 总页数：${pageResult.totalPage}  总条数：${pageResult.totalCount}
                <button onclick="page(1)">首页</button>
                <button onclick="page(${pageResult.prevPage})">上一页</button>
                <button onclick="page(${pageResult.nextPage})">下一页</button>
                <button onclick="page(${pageResult.totalPage})">末页</button>
                <select name="pageSize">
                    <option value="5" <c:if test="${pageResult.pageSize == 5}">selected</c:if>>5</option>
                    <option value="10" <c:if test="${pageResult.pageSize == 10}">selected</c:if>>10</option>
                </select>
            </div>
        </div>
    </form>
</body>
</html>
