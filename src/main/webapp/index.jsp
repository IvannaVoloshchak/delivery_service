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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@ include file="header.jspf" %>
<!--<jsp:include page="header.jspf"/>-->
<div class="wrapper container">
    <h4>
        <c:if test="${user!=null}">
            <p><a href="?action=listDelivery"> <fmt:message key="index.deliveries" bundle="${rb}"/> </a></p>
        </c:if>
    </h4>
    <h3 class="main-header">
        <fmt:message key="index.labelDeliveryCalc" bundle="${rb}"/> </br>
    </h3>

    <form  style="width:500px" method="POST" action='?action=calculate' name="price">
        <p>
            <strong><fmt:message key="index.weight" bundle="${rb}"/>: </strong>
            <input type="text" name="weight" value="${weight}"/> kg
        </p>

        <p>
            <strong><fmt:message key="index.goodsType" bundle="${rb}"/> </strong>

            <select name="goods_type">
                <c:forEach items="${types}" var="type">
                    <option value="${type.idGoodsType}" ${type.idGoodsType==idGoodsType ? 'selected' : ''} >${type.name}</option>
                </c:forEach>
            </select>
        </p>
        <p>
            <strong><fmt:message key="index.direction" bundle="${rb}"/></strong>
        </p>
        <p>
            <fmt:message key="index.from" bundle="${rb}"/>:
            <select name="from">
                <c:forEach items="${cities}" var="city">
                    <option value="${city.id}" ${city.id==from ? 'selected' : ''}>${city.name}</option>
                </c:forEach>
            </select>
        </p>
        <p>
            <fmt:message key="index.to" bundle="${rb}"/>:
            <select name="to">
                <c:forEach items="${cities}" var="city">
                    <option value="${city.id}" ${city.id==to ? 'selected' : ''}>${city.name}</option>

                </c:forEach>
            </select>
        </p>
        <p>
            <fmt:message key="index.button.calculate" bundle="${rb}" var="buttonValue"/>
            <a href="/"> <input type="submit" class="btn btn-primary" value="${buttonValue}"/></a>
        </p>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger" role="alert">
                <c:out value="${errorMessage}"/>
            </div>
        </c:if>
        <p>
            <strong><fmt:message key="index.totalPrice" bundle="${rb}"/>:</strong>
            <input value="${price}" type="text" name="price" disabled/>

        </p>
    </form>
    
    </br>
    <h3 class="main-header">
        <fmt:message key="index.deliveryTariffs" bundle="${rb}"/>:
    </h3>
    <ul class="unstyled">
        <li><fmt:message key="index.letterTariffs" bundle="${rb}"/></li>
        <li><fmt:message key="index.boxTariffs" bundle="${rb}"/></li>
        <li><fmt:message key="index.parcelTariffs" bundle="${rb}"/></li>
        <li><fmt:message key="index.containerTariffs" bundle="${rb}"/></li>
    </ul>
</div>
</body>
</html>