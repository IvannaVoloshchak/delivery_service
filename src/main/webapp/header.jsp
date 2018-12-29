<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ page isELIgnored="false" %>
<fmt:setBundle basename="pageContent" var="rb"/>
<html>
<head>
<title>Header</title>
</head>
<body>
<fmt:requestEncoding value="UTF-8" />
<h1>
Delivery World
</h1>
<div class="main_header">
    <form method="POST" action='?action=setLocale' name="locale">
        <input type="hidden" name="command" value="setLocale">

        <c:set var="currentPage" value="${currentPage}" scope="request"/>
        <input type="hidden" name="currentPage" value="${currentPage}">

        <button class="change_locale" type="submit" name="locale" value="1">English</button>
        <button class="change_locale" type="submit" name="locale" value="2">Українська</button>
    </form>

        <c:choose>
         <c:when test="${user==null}">
             <a href="?action=login"><input type="submit" value="SIGN IN"/>
             <a href="?action=registration"> Registration </a>
          </c:when>
    <c:otherwise>
         <c:out value="${user.login}" />
         <a href="?action=signOut"><input type="submit" value="SIGN OUT"/></a>
    </c:otherwise>
    </c:choose>
    </div>
   </body>
</html>