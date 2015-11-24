<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Каталог</title>
    <style type="text/css">
        td {border: 1px solid black}
    </style>
</head>
<body>
<div>
<h1>Каталог</h1>

<table style="border: 1px solid; text-align:center">
    <thead style="background:#fcf">
    <tr>
        <th>Артикул</th>
        <th>Категория</th>
        <th>Название</th>
        <th>Количество</th>
        <th>Цена</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${items}' var="item">
        <c:url var="buyUrl" value="/catalog/item/buy/${item.id}" />
        <c:url var="itemUrl" value="/catalog/item/${item.id}" />
        <c:url var="catUrl" value="/catalog/${item.category.id}" />
        <tr>
            <td><c:out value="${item.article}" /></td>
            <td><a href="<c:out value="${catUrl}"/>"><c:out value="${item.category.title}" /></a></td>
            <td><a href="<c:out value="${itemUrl}"/>"><c:out value="${item.title}" /></a></td>
            <td><c:out value="${item.quantity}" /></td>
            <td><c:out value="${item.price}" /></td>
            <td><a href="${buyUrl}">Купить</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>

<div>
    <h1>Корзина</h1>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h3>${pageContext.request.userPrincipal.name}</h3>
    </c:if>
    <p>Сумма покупок: <c:out value="${sum}"/></p>
    <p><a href="/basket">Перейти в корзину</a></p>
</div>

</body>
</html>