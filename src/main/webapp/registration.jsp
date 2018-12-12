<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Registration</title>
</head>
<body>
<form action = "registration" method = "POST">
<p>  Login : <input type = "text" name = "login"> <br /></p>
<p>  Password : <input type = "text" name = "password"> <br /></p>
       <p>  First name : <input type = "text" name = "first_name"> <br /></p>
        <p> Last name: <input type = "text" name = "last_name" /></p>
        <p> Phone number : <input type = "text" name = "phone_number" /></p>
        <p> Email : <input type = "text" name = "Email" /></p>

       <p><a href="/">  <input type = "submit" value = "Enter" /></a></p>

      </form>

   </body>
</html>