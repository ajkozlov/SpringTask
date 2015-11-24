<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${item.title}"/></title>
</head>
<body>
  <div>
    <h3><c:out value="${item.title}"/></h3>
    <p>Описание: <c:out value="${item.description}"/></p>
    <p>Цена: <c:out value="${item.price}"/></p>
    <p><a href="/catalog">Назад</a> <a href="/catalog/item/buy?id=<c:out value="${item.id}"/>">Купить</a></p>
  </div>
</body>
</html>
