<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
</head>
<body>
<ul>
    <c:forEach items="${items}" var="item">
        <li><c:out value="${item.title}"/> <c:out value="${item.quantity}"/></li>
    </c:forEach>
</ul>
</body>
</html>
