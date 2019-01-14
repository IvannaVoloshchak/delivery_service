<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<c:if test="${locale == 1}"><fmt:setLocale value="en_US" scope="session"/></c:if>
<c:if test="${locale == 2}"><fmt:setLocale value="uk_UA" scope="session"/></c:if>
<fmt:setBundle basename="pageContent" var="rb"/>
<html>
<head>
    <c:set var="currentPage" value="path.page.registration" scope="request"/>
    <title>Registration</title>
</head>
<body>
<%@ include file="header.jspf" %>
<div class="wrapper container">
<form style="width:800px"  method="POST" action='?action=addUser' name="frmUsers">
    <p>
        <label class="control-label col-sm-2"  for="login"><fmt:message key="registration.label.login" bundle="${rb}"/>:</label>
        <input type="text" name="login" value="<c:out value="${user.login}" />"/><br/>
    </p>
    <p>
        <label class="control-label col-sm-2"  for="password"><fmt:message key="registration.label.password" bundle="${rb}"/>:</label>
        <input type="password" name="password" value="<c:out value="${user.password}" />"/><br/>
    </p>
    <p>
        <label  class="control-label col-sm-2" for="first_name"><fmt:message key="registration.label.firstName" bundle="${rb}"/>:</label>
        <input type="text" name="first_name" value="<c:out value="${user.firstName}" />"/><br/>
    </p>
    <p>
        <label  class="control-label col-sm-2" for="last_name"><fmt:message key="registration.label.lastName" bundle="${rb}"/>:</label>
        <input type="text" name="last_name" value="<c:out value="${user.lastName}" />"/><br/>
    </p>
    <p>
        <label class="control-label col-sm-2" for="phone_number"> <fmt:message key="registration.label.phoneNum" bundle="${rb}"/>:</label>
        <input type="tel" id="phone_number" name="phone_number" pattern="(\+?\d[- .]*){7,13}" required value="<c:out value="${user.phoneNumber}" />"/>
    </p>

    <p>
        <label class="control-label col-sm-2" for="email"><fmt:message key="registration.label.email" bundle="${rb}"/>:</label>
        <input type="email"  id="email" pattern=".+@globex.com" size="45" required name="email" value="<c:out value="${user.email}" />"/><br/>
    </p>
    <p>
        <fmt:message key="registration.button.save" bundle="${rb}" var="buttonValue"/>
        <input type="submit"  class="btn btn-primary" value="${buttonValue}"/>
    </p>
</form>
<c:if test="${not empty errorMessage}">
    <c:out value="${errorMessage}"/>
</c:if>
</div>
</body>
</html>