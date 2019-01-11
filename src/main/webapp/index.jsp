<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<c:if test="${locale == 1}"><fmt:setLocale value="en_US" scope="session"/></c:if>
<c:if test="${locale == 2}"><fmt:setLocale value="uk_UA" scope="session"/></c:if>
<fmt:setBundle basename="pageContent" var="rb"/>

<html>
<head>
    <c:set var="currentPage" value="path.page.index" scope="request"/>
    <title>Delivery</title>
</head>
<body>
<%@ include file="header.jspf" %>
<!--<jsp:include page="header.jspf"/>-->

<c:if test="${user!=null}">
    <p><a href="?action=listDelivery"> <fmt:message key="index.deliveries" bundle="${rb}"/> </a></p>
</c:if>

<h2>
    <fmt:message key="index.labelDeliveryCalc" bundle="${rb}"/>
</h2>

<form method="POST" action='?action=calculate' name="price">
    <p>
        <strong><fmt:message key="index.weight" bundle="${rb}"/>: </strong>
    </p>
    <input type="text" name="weight" value="${weight}"/> kg<br/>
    <p>
        <strong><fmt:message key="index.goodsType" bundle="${rb}"/> </strong>
    </p>
    <select name="goods_type">
        <c:forEach items="${types}" var="type">
            <option value="${type.idGoodsType}" ${type.idGoodsType==idGoodsType ? 'selected' : ''} >${type.name}</option>
        </c:forEach>
    </select>
    <p>
        <strong><fmt:message key="index.direction" bundle="${rb}"/></strong>
    </p>
    <p>
        <fmt:message key="index.from" bundle="${rb}"/>:
    </p>
    <select name="from">
        <c:forEach items="${cities}" var="city">
            <option value="${city.id}" ${city.id==from ? 'selected' : ''}>${city.name}</option>
        </c:forEach>
    </select>
    <p>
        <fmt:message key="index.to" bundle="${rb}"/>:
    </p>
    <select name="to">
        <c:forEach items="${cities}" var="city">
            <option value="${city.id}" ${city.id==to ? 'selected' : ''}>${city.name}</option>
        </c:forEach>
    </select><br/>
    <fmt:message key="index.button.calculate" bundle="${rb}" var="buttonValue"/>
    <p>
        <a href="/"> <input type="submit" value="${buttonValue}"/></a>
    </p>
    <p>
        <strong><fmt:message key="index.totalPrice" bundle="${rb}"/></strong>
        <input value="${price}" type="text" name="price"/>
    </p>
</form>
<h2>
    <strong> <fmt:message key="index.deliveryTariffs" bundle="${rb}"/>:</strong>
</h2>
<li><fmt:message key="index.letterTariffs" bundle="${rb}"/></li>
<li><fmt:message key="index.boxTariffs" bundle="${rb}"/></li>
<li><fmt:message key="index.parcelTariffs" bundle="${rb}"/></li>
<li><fmt:message key="index.containerTariffs" bundle="${rb}"/></li>
</ul>
</body>
</html>