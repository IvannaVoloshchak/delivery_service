<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<c:if test="${locale == 1}"><fmt:setLocale value="en_US" scope="session"/></c:if>
<c:if test="${locale == 2}"><fmt:setLocale value="uk_UA" scope="session"/></c:if>
<fmt:setBundle basename="pageContent" var="rb"/>
<html>
<head>
 <c:set var="currentPage" value="path.page.insertOrEdit" scope="request"/>
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new delivery</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=sentDate]').datepicker();
                $('input[name=deliveryDate]').datepicker();
        });
    </script>

    <form method="POST" action='?action=save' name="frmAddDelivery">
 <input type="hidden" readonly="readonly" name="id"
                        value="<c:out value="${delivery.id}" />" /> <br />
           <input type="hidden"  name="user_id"
                        value="<c:out value="${delivery.userId}" />" /> <br />

         Senders_first_name : <input type="text" name="senders_first_name"
                    value="<c:out value="${delivery.sendersFirstName}" />" /> <br />

         Senders_last_name : <input type="text" name="senders_last_name"
                     value="<c:out value="${delivery.sendersLastName}" />" /> <br />

          Recipient_first_name : <input type="text" name="recipient_first_name"
                     value="<c:out value="${delivery.recipientFirstName}" />" /> <br />

          Recipient_last_name : <input type="text" name="recipient_last_name"
                    value="<c:out value="${delivery.recipientLastName}" />" /> <br />

       From_city :  <select name="city_from_id">
                    <c:forEach items="${cities}" var="city">
                    <option value="${city.id}" ${city.id==delivery.fromCity ? 'selected' : ''}>${city.name}</option>
                     </c:forEach>
                     </select><br/>
       To_city:  <select name="city_to_id">
                     <c:forEach items="${cities}" var="city">
                     <option value="${city.id}" ${city.id==delivery.toCity ? 'selected' : ''}>${city.name}</option>
                     </c:forEach>
                      </select><br/>
       Goods_type :  <select name="goods_type_id">
                     <c:forEach items="${types}" var="type">
                      <option value="${type.idGoodsType}" ${type.idGoodsType==delivery.goodsType ? 'selected' : ''} >${type.name}</option>
                      </c:forEach>
                      </select><br />

        Weight : <input type="text" name="weight"
                       value="<c:out value="${delivery.weight}" />" /> <br />
      Senders_phone : <input type="text" name="senders_phone"
                    value="<c:out value="${delivery.sendersPhone}" />" /> <br />
        Recipient_phone : <input type="text" name="recipient_phone"
                   value="<c:out value="${delivery.recipientPhone}" />" /> <br />

        Sent_date : <input   type="text" name="sent_date"
                 value="<fmt:formatDate pattern="yyyy-MM-dd" value="${delivery.sentDate}" />" /> <br />

        Delivery_date : <input    type="text" name="delivery_date"
                  value="<fmt:formatDate pattern="yyyy-MM-dd" value="${delivery.deliveryDate}" />" /> <br />
          <input type="hidden" name="paymentStatus"
                   value="<c:out value="${delivery.paymentStatus}" />" /> <br />
     <input type="submit" value="Save"/>
    </form>
</body>
</html>