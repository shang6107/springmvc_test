<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/18 0018
  Time: 下午 4:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Title</title>
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">
        <c:if test="${employee.id == 0}" var="noid">
        lastName:<form:input path="lastName"/><form:errors path="lastName"></form:errors><br/>
        </c:if>
        <c:if test="${!noid}">
            <form:hidden path="id"/>
            <input type="hidden" name="_method" value="PUT"/>
        </c:if>
        email:<form:input path="email"/><form:errors path="email"></form:errors><br/>
        birth:<form:input path="birth"/><form:errors path="birth"></form:errors><br/>
        gender:<form:radiobuttons path="gender" items="${requestScope.genders}"/><br/>
        department:<form:select path="department.id" itemValue="id"
                                items="${requestScope.depts}"
                                itemLabel="dname"/><br/>
        <input type="submit"/>
    </form:form>


</body>
</html>
