<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<c:if test="${locale == 1}"><fmt:setLocale value="en_US" scope="session"/></c:if>
<c:if test="${locale == 2}"><fmt:setLocale value="uk_UA" scope="session"/></c:if>
<fmt:setBundle basename="pageContent" var="rb"/>
<html>
<head>
    <c:set var="currentPage" value="path.page.login" scope="request"/>
    <title>Sign in</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%@ include file="header.jspf" %>
<div class="wrapper container">
<form style="width:600px" action="?action=signIn" method="POST">
    <p>
        <label class="control-label col-sm-2" for="login"><fmt:message key="login.label.login" bundle="${rb}"/>:</label>
        <input type="text" name="login"><br/>
    </p>
    <p>
        <label class="control-label col-sm-2" for="password"><fmt:message key="login.label.password" bundle="${rb}"/>:</label>
        <input type="password" name="password"/>
    </p>
    <p>
        <fmt:message key="login.button.enter" bundle="${rb}" var="buttonValue"/>
        <input type="submit" class="control-label col-sm-2" value="${buttonValue}"/>
    </p>
</form>
<c:if test="${not empty errorMessage}">
    <c:out value="${errorMessage}"/>
</c:if>
</div>
</body>
</html>