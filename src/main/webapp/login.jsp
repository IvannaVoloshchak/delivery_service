<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Sign in</title>
</head>
<body>
<form action = "?action=signIn" method = "POST">
       <p>  Login: <input type = "text" name = "login"> <br /></p>
        <p> Password: <input type = "text" name = "password" /></p>
       <p>  <input type = "submit" value = "Enter" /></a></p>
      </form>
  <c:if test="${not empty errorMessage}">
     <c:out value="${errorMessage}"/>
  </c:if>
   </body>
</html>