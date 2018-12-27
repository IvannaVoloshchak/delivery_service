<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Sign in</title>
    </head>
        <body>
        <jsp:include page="header.jsp"/>
            <form action = "?action=signIn" method = "POST">
            <p>  <label for="login"><fmt:message key="login.label.login" />:</label> <input type = "text" name = "login"> <br /></p>
            <p> <label for="password"><fmt:message key="login.label.password" />:</label> <input type = "text" name = "password" /></p>
                    <fmt:message key="login.button.submit" var="buttonValue" />

             <p>  <input type = "submit" value = "${buttonValue}" /></a></p>
            </form>
     <c:if test="${not empty errorMessage}">
     <c:out value="${errorMessage}"/>
     </c:if>
     </body>
    </html>