<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page isELIgnored="false" %>

<c:if test="${locale == 1}"><fmt:setLocale value="en_US" scope="session"/></c:if>
<c:if test="${locale == 2}"><fmt:setLocale value="uk_UA" scope="session"/></c:if>
<fmt:setBundle basename="pageContent" var="rb"/>
<html>
<head>
    <c:set var="currentPage" value="path.page.pay" scope="request"/>
    <title>Payment</title>
</head>
<body>
<%@ include file="header.jspf" %>
<div class="wrapper container">
<form style="width:1000px" method="POST" action="?action=paid&id=<c:out value="${delivery.id}"/>" name="frmPayment"></a>
    <p>
        <label class="control-label col-sm-2" for="cardHolder"><fmt:message key="pay.label.cardHolder" bundle="${rb}"/>:</label>
        <input type="text" name="cardHolder"/>
    </p>
    <p>
        <label class="control-label col-sm-2" for="price"><fmt:message key="pay.label.price" bundle="${rb}"/>:</label>
        <input type="text" name="price" value="<c:out value="${delivery.price}" />"/>
    </p>
    <p>
        <label class="control-label col-sm-2" for="cardNumber"><fmt:message key="pay.label.cardNumber" bundle="${rb}"/>:</label>
        <input type="text" name="cardNumber"/>
    </p>
    <p>
        <label class="control-label col-sm-2"  for="validity"><fmt:message key="pay.label.validity" bundle="${rb}"/>: </label>
        <input type="text" name="validity"/>
    </p>
    <p>
        <label class="control-label col-sm-2" for="cvv2"><fmt:message key="pay.label.cvv2" bundle="${rb}"/>:</label>
        <input type="text" name="CVV2"/>
    </p>
    <p>
        <fmt:message key="pay.button.pay" bundle="${rb}" var="buttonValue"/>
        <input type="submit"  class="btn btn-primary" value="${buttonValue}"/>
    </p>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
            <c:out value="${errorMessage}"/>
        </div>
    </c:if>
</form>
</div>
</body>
</html>