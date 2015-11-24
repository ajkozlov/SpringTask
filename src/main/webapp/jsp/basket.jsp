<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Корзина</title>
</head>
<body>
<h1>Корзина</h1>
<c:if test="${pageContext.request.userPrincipal.name != null}">
  <h3>${pageContext.request.userPrincipal.name}</h3>
</c:if>
<p>Название  |  шт.  |  Сумма</p>
<c:forEach items="${rows}" var="row">
  <p><c:out value="${row}"/></p>
</c:forEach>
<p>Всего: </p>
<p><a href="/catalog">Назад</a> <a href="/basket/buy">Заказать</a></p>
</body>
</html>
