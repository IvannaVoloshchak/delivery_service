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
            $('input[name=sent_date]').datepicker();
$('input[name=delivery_date]').datepicker();
        });
    </script>

    <form method="POST" action='DeliveryController' name="frmAddDelivery">

    Id : <input type="text" readonly="readonly" name="id"
                value="<c:out value="${delivery.id}" />" /> <br />

         Senders_name : <input type="text" name="senders_name"
            value="<c:out value="${delivery.senders_name}" />" /> <br />

          Recipient_name : <input type="text" name="recipient_name"
                        value="<c:out value="${delivery.recipient_name}" />" /> <br />

        Senders_address : <input  type="text" name="senders_address"
            value="<c:out value="${delivery.senders_address}" />" /> <br />

        Recipient_address : <input type="text" name="recipient_address"
            value="<c:out value="${delivery.recipient_address}" />" /> <br />

       Delivery_type : <input     type="text" name="delivery_type"
                         value="<c:out value="${delivery.delivery_type}" />" /> <br />

        Weight : <input type="text" name="weight"
                       value="<c:out value="${delivery.weight}" />" /> <br />

        Sent_date : <input   type="text" name="sent_date"
            value="<fmt:formatDate pattern="yyyy-MM-dd" value="${delivery.sent_date}" />" /> <br />

        Delivery_date : <input    type="text" name="delivery_date"
                        value="<fmt:formatDate pattern="yyyy-MM-dd" value="${delivery.delivery_date}" />" /> <br />


     <input type="submit" value="Save"/>
    </form>
</body>
</html>