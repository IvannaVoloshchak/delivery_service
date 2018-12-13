<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Payment</title>
</head>
<body>
<form action = "payment" method = "POST">
<p> First name : <input type = "text" name = "first name"> <br /></p>
<p> Last name : <input type = "text" name = "last name"> <br /></p>
<p> Email : <input type = "text" name = "Email" /></p>
       <p> Price : <input type = "text" name = "price"> <br /></p>
        <p> Card type: <input type = "text" name = " card type" /></p>
        <p> Card number : <input type = "text" name = "card number" /></p>
        <p>  Validity: <input type = "text" name = "validity" /></p>
        <p>  CVV2: <input type = "text" name = "CVV2" /></p>


       <p><a href="?action=listDelivery">  <input type = "submit" value = "Pay" /></a></p>

      </form>

   </body>
</html>