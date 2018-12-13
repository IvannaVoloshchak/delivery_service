<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Deliveries</title>
</head>
<body>
<p><a href="/"> Main </a></p>
    <table border=1>
        <thead>
            <tr>
                <th> id </th>
                <th> senders_first_name </th>
                <th> senders_last_name </th>
                <th> recipient_first_name </th>
                <th> recipient_last_name </th>
                <th> from_city_id</th>
                <th> to_city_id </th>
                <th> goods_type_id </th>
                <th> weight </th>
                <th>senders_phone </th>
                <th> recipient_phone</th>
                <th> sent_date </th>
                <th> delivery_date </th>
                <th> price </th>
                <th> paymentStatus </th>
                <th colspan=3>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${deliveries}" var="delivery">
                <tr>
                  <td><c:out value="${delivery.id}" /></td>
                    <td><c:out value="${delivery.sendersFirstName}" /></td>
                    <td><c:out value="${delivery.sendersLastName}" /></td>
                    <td><c:out value="${delivery.recipientFirstName}" /></td>
                    <td><c:out value="${delivery.recipientLastName}" /></td>
                    <td><c:out value="${delivery.fromCity}" /></td>
                    <td><c:out value="${delivery.toCity}" /></td>
                    <td><c:out value="${delivery.goodsType}" /></td>
                    <td><c:out value="${delivery.weight}" /></td>
                    <td><c:out value="${delivery.sendersPhone}" /></td>
                    <td><c:out value="${delivery.recipientPhone}" /></td>

                     <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${delivery.sentDate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${delivery.deliveryDate}" /></td>
                    <td><c:out value="${delivery.price}" /></td>
                    <td><c:out value="${delivery.paymentStatus}" /></td>
                    <td><a href="?action=payment&id=<c:out value="${}"/>">Pay</a></td>
                    <td><a href="?action=edit&id=<c:out value="${delivery.id}"/>">Update</a></td>
                    <td><a href="?action=delete&id=<c:out value="${delivery.id}"/>">Delete</a></td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="?action=insert"> <input type="submit" value="Add new Delivery"/> </a></p>
</body>
</html>