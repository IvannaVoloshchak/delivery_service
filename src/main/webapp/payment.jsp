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
 <form method="POST" action="?action=paid&id=<c:out value="${delivery.id}"/>" name="frmPayment">

        <p> Card holder full name : <input type = "text" name = "card holder full name"> <br /></p>

       <p> Price : <input type="text" name="price"
                                      value="<c:out value="${delivery.price}" />" /> <br />
        <p> Card number : <input type = "text" name = "card number" /></p>
        <p>  Validity: <input type = "text" name = "validity" /></p>
        <p>  CVV2: <input type = "text" name = "CVV2" /></p>


       <p><input type = "submit" value = "Pay" /></p>

      </form>

   </body>
</html>