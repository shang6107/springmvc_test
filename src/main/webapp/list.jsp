<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/5 0005
  Time: 下午 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Title</title>
    <script src="file/jquery.min.js"></script>
    <script>
        $(function () {
            $(".delete").click(function () {
                $("form").attr("action",$(this).attr("href")).submit();
                return false;
            });
        })
    </script>
</head>
<body>
<form method="post" action="">
    <input type="hidden" value="DELETE" name="_method"/>
</form>
<c:if test="${empty requestScope.emps}" var="nobody">
    <h3>没有任何员工信息</h3>
</c:if>
<c:if test="${!nobody}">
    <table border="1" cellspacing="0" cellpadding="0">
        <tr>
            <th>ID</th>
            <th>lastName</th>
            <th>birth</th>
            <th>email</th>
            <th>gender</th>
            <th>update</th>
            <th>delete</th>
        </tr>
        <c:forEach items="${requestScope.emps}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.birth}</td>
                <td>${emp.email}</td>
                <td>${emp.gender}</td>
                <td><a href="${pageContext.request.contextPath}/emp/${emp.id}">update</a></td>
                <td><a class="delete" href="${pageContext.request.contextPath}/emp/${emp.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="${pageContext.request.contextPath}/emp">add</a>
</body>
</html>
