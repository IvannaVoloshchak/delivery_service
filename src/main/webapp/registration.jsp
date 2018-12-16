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
<form method="POST" action='?action=addUser' name="frmUsers">



<p>  Login : <input type="text" name="login"
                                 value="<c:out value="${user.login}" />" /> <br /></p>

<p>  Password :<input type="text" name="password"
                                   value="<c:out value="${user.password}" />" /> <br /></p>

       <p>  First name : <input type="text" name="first_name"
                                      value="<c:out value="${user.firstName}" />" /> <br /></p>

        <p> Last name: <input type="text" name="last_name"
                                      value="<c:out value="${user.lastName}" />" /> <br /></p>

        <p> Phone number : <input type="text" name="phone_number"
                                     value="<c:out value="${user.phoneNumber}" />" /> <br /></p>

        <p> Email : <input type="text" name="email"
                                      value="<c:out value="${user.email}" />" /> <br /></p>

            <input type="submit" value="Save"/>

      </form>

   </body>
</html>