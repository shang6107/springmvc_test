<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/18 0018
  Time: 下午 3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/emps">go</a>
    <hr>
    <h3>测试 自定义类型转换器 ： 将字符串转为bean</h3>
<form action="${pageContext.request.contextPath}/emp" method="post">
    <input type="text" name="employee" placeholder="lastName-email-gender-birth"/><br>
    <input type="submit"/>
</form>
</body>
</html>
