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
    <jsp:include page="header.jsp"/>
<form method="POST" action='?action=addUser' name="frmUsers">

<p><label for="login"><fmt:message key="registration.label.login"  bundle="${rb}"/>:</label> <input type="text" name="login  value="<c:out value="${user.login}" />" />  <br /></p>

<p><label for="password"><fmt:message key="registration.label.password" bundle="${rb}"/>:<input type="text" name="password"
                                   value="<c:out value="${user.password}" />" /> <br /></p>

       <p><label for="firstName"><fmt:message key="registration.label.firstName" bundle="${rb}"/>:<input type="text" name="first_name" value="<c:out value="${user.firstName}" />" /> <br /></p>

        <p><label for="LastName"><fmt:message key="registration.label.lastName" bundle="${rb}"/>: <input type="text" name="last_name"
                                      value="<c:out value="${user.lastName}" />" /> <br /></p>

        <p><label for="phone Number"><fmt:message key="registration.label.phoneNum" bundle="${rb}"/>: <input type="text" name="phone_number"
                                     value="<c:out value="${user.phoneNumber}" />" /> <br /></p>

        <p> <label for="email"><fmt:message key="registration.label.email" bundle="${rb}"/>: <input type="text" name="email"
                                      value="<c:out value="${user.email}" />" /> <br/></p>
            <fmt:message key="registration.button.save" bundle="${rb}"  var="buttonValue" />
            <input type="submit" value="${buttonValue}"/>

      </form>

   </body>
</html>