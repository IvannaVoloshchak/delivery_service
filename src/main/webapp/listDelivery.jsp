<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<c:if test="${locale == 1}"><fmt:setLocale value="en_US" scope="session"/></c:if>
<c:if test="${locale == 2}"><fmt:setLocale value="uk_UA" scope="session"/></c:if>
<fmt:setBundle basename="pageContent" var="rb"/>

<html>
<head>
 <c:set var="currentPage" value="path.page.listDelivery" scope="request"/>
<title>Show All Deliveries</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
<p><a href="/"> Main </a></p>
    <table border=1>
        <thead>
            <tr>
                <th style="display:none"> id </th>
                <th style="display:none"> user_id </th>
                <th><label for="SendersFN"><fmt:message key="listDelivery.label.SendersFirstName"  bundle="${rb}"/>:</label>  </th>
                <th> <label for="SendersLN"><fmt:message key="listDelivery.label.SendersLastName"  bundle="${rb}"/>:</label>  </th>
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
                  <td style="display:none"><c:out value="${delivery.id}" /></td>
                  <td style="display:none"><c:out value="${delivery.userId}" /></td>
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
                    <td><a href="?action=payment&id=<c:out value="${delivery.id}"/>">Pay</a></td>
                    <td><a href="?action=edit&id=<c:out value="${delivery.id}"/>">Update</a></td>
                    <td><a href="?action=delete&id=<c:out value="${delivery.id}"/>">Delete</a></td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="?action=insert"> <input type="submit" value="Add new Delivery"/> </a></p>
</body>
</html>