<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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

    Id : <input type="text" readonly="readonly" name="id"
                value="<c:out value="${delivery.id}" />" /> <br />

         Senders_first_name : <input type="text" name="senders_first_name"
                    value="<c:out value="${delivery.sendersFirstName}" />" /> <br />

         Senders_last_name : <input type="text" name="senders_last_name"
                     value="<c:out value="${delivery.sendersLastName}" />" /> <br />

          Recipient_first_name : <input type="text" name="recipient_first_name"
                     value="<c:out value="${delivery.recipientFirstName}" />" /> <br />

          Recipient_last_name : <input type="text" name="recipient_last_name"
                    value="<c:out value="${delivery.recipientLastName}" />" /> <br />

       From_city : <input  type="text" name="from_city"
             value="<c:out value="${delivery.fromCity}" />" /> <br />

       To_city: <input type="text" name="to_city"
            value="<c:out value="${delivery.toCity}" />" /> <br />

       Goods_type : <input     type="text" name="goods_type"
                         value="<c:out value="${delivery.goodsType}" />" /> <br />

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

     <input type="submit" value="Save"/>
    </form>
</body>
</html>