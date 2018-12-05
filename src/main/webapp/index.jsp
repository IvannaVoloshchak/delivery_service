<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Delivery</title>
</head>
<body>
<h1>
Delivery World
</h1>
<input type="submit" value="SIGN IN"/> <a href="?action=registration"> Registration </a>
<p><a href="?action=listDelivery"> Deliveries </a></p>

<h2><strong> Delivery  calculator</strong></h2>
<p> <strong>Weight: </strong></p>
 <input type="text" name="weight"
            value=" ${delivery.weight} " /> kg<br />
<p><strong>Goods type: </strong></p>
<select name="goods_type">
 <c:forEach items="${types}" var="type">
         <option value="${type.idGoodsType}">${type.name}</option>
     </c:forEach>
  </select>
  <p><strong>Direction: </strong></p>
  <p>From: </p>
  <select name="from">
  <c:forEach items="${cities}" var="city">
           <option value="${city.id}">${city.name}</option>
       </c:forEach>
    </select>
    <p>To: </p>
     <select name="to">
     <c:forEach items="${cities}" var="city">
                <option value="${city.id}">${city.name}</option>
            </c:forEach>
     </select><br/>
  <p><input type="submit" value="Calculate"/></p>
  <p><strong>Total price:</strong> <input type="text" name="price" /> </p>
</body>
</html>