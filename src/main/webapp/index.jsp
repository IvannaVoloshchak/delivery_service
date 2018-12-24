<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:if test="${locale == 1}"><fmt:setLocale value="en_US" scope="session"/></c:if>
<c:if test="${locale == 2}"><fmt:setLocale value="uk_UA" scope="session"/></c:if>
<fmt:setBundle basename="pagecontent" var="rb"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Delivery</title>
</head>
<body>
<h1>
Delivery World
</h1>
<c:choose>
    <c:when test="${user==null}">
       <a href="?action=login"><input type="submit" value="SIGN IN"/>
       <a href="?action=registration"> Registration </a>
    </c:when>
    <c:otherwise>
      <c:out value="${user.login}" />
      <a href="?action=signOut"><input type="submit" value="SIGN OUT"/>
      <p><a href="?action=listDelivery"> Deliveries </a></p>
    </c:otherwise>
</c:choose>

<h2><strong> Delivery  calculator</strong></h2>

<form method="POST" action='?action=calculate' name="price">

<p> <strong>Weight: </strong></p>
         <input type="text" name="weight"  value="${weight}" /> kg<br />

<p><strong>Goods type: </strong></p>
<select name="goods_type">
 <c:forEach items="${types}" var="type">
         <option value="${type.idGoodsType}" ${type.idGoodsType==idGoodsType ? 'selected' : ''} >${type.name}</option>
     </c:forEach>
  </select>

  <p><strong>Direction: </strong></p>
  <p>From: </p>
  <select name="from">
  <c:forEach items="${cities}" var="city">
           <option value="${city.id}" ${city.id==from ? 'selected' : ''}>${city.name}</option>
       </c:forEach>
    </select>

    <p>To: </p>
     <select name="to">
     <c:forEach items="${cities}" var="city">
                <option value="${city.id}" ${city.id==to ? 'selected' : ''}>${city.name}</option>
            </c:forEach>
     </select><br/>


<p><a href="/"> <input type="submit" value="Calculate"/> </a></p>
 <p><strong>Total price:</strong> <input value= "${price}" type="text" name="price" /> </p>
  </form>

  <h2><strong> Delivery  tariffs </strong></h2>
   <p>
  	  <strong>Delivery tariffs </strong><br>
  	   <li> Letter - 30 uan + 0.01 for each kilometers of road; </li>
  	   <li> Box - 40 uan + 0.1 for each kilometers of road + 1 uan for each kilograms of weight; </li>
  	   <li> Parcel - 50 uan + 0.1 for each kilometers of road + 1 uan for each kilograms of weight; </li>
  	   <li> Container - 100 uan + 0.1 for each kilometers of road + 1 uan for each kilograms of weight. </li>
  	   </ul>

</body>
</html>