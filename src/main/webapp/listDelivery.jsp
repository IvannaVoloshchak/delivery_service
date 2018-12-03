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
    <table border=1>
        <thead>
            <tr>
                <th> id </th>
                <th> senders_name </th>
                <th> recipient_name </th>
                <th> senders_address </th>
                <th> recipient_address </th>
                <th> delivery_type </th>
                <th> weight </th>
                <th> sent_date </th>
                <th> delivery_date </th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${deliveries}" var="delivery">
                <tr>
                    <td><c:out value="${delivery.id}" /></td>
                    <td><c:out value="${delivery.senders_name}" /></td>
                    <td><c:out value="${delivery.recipient_name}" /></td>
                    <td><c:out value="${delivery.senders_address}" /></td>
                    <td><c:out value="${delivery.recipient_address}" /></td>
                    <td><c:out value="${delivery.delivery_type}" /></td>
                    <td><c:out value="${delivery.weight}" /></td>
                     <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${delivery.sent_date}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${delivery.delivery_date}" /></td>
                    <td><a href="DeliveryController?action=edit&id=<c:out value="${delivery.id}"/>">Update</a></td>
                    <td><a href="DeliveryController?action=delete&id=<c:out value="${delivery.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="DeliveryController?action=insert">  <input type="submit" value="Add new Delivery"/></a></p>
</body>
</html>