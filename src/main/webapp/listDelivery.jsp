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

    <table border=1>
        <thead>
            <tr>
                <th style="display:none"> id </th>
                <th style="display:none"> user_id </th>
                <th><fmt:message key="listDelivery.label.sendersFirstName" bundle="${rb}"/></th>
                <th><fmt:message key="listDelivery.label.sendersLastName" bundle="${rb}"/></th>
                <th><fmt:message key="listDelivery.label.recipientFirstName" bundle="${rb}"/></th>
                <th><fmt:message key="listDelivery.label.recipientLastName" bundle="${rb}"/></th>
                <th><fmt:message key="listDelivery.label.fromCity" bundle="${rb}"/></th>
                <th><fmt:message key="listDelivery.label.toCity" bundle="${rb}"/></th>
                <th><fmt:message key="listDelivery.label.goodsTypeId" bundle="${rb}"/></th>
                <th><fmt:message key="listDelivery.label.weight" bundle="${rb}"/></th>
                <th><fmt:message key="listDelivery.label.sendersPhone" bundle="${rb}"/></th>
                <th><fmt:message key="listDelivery.label.recipientPhone" bundle="${rb}"/></th>
                <th><fmt:message key="listDelivery.label.sentDate" bundle="${rb}"/></th>
                <th><fmt:message key="listDelivery.label.deliveryDate" bundle="${rb}"/></th>
                <th><fmt:message key="listDelivery.label.price" bundle="${rb}"/></th>
                <th><fmt:message key="listDelivery.label.paymentStatus" bundle="${rb}"/></th>
                <th colspan=3><fmt:message key="listDelivery.label.action" bundle="${rb}"/></th>
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
                    <td><a href="?action=payment&id=<c:out value="${delivery.id}"/>"><fmt:message key="listDelivery.label.pay" bundle="${rb}"/></a></td>
                    <td><a href="?action=edit&id=<c:out value="${delivery.id}"/>"><fmt:message key="listDelivery.label.update" bundle="${rb}"/></a></td>
                    <td><a href="?action=delete&id=<c:out value="${delivery.id}"/>"><fmt:message key="listDelivery.label.delete" bundle="${rb}"/></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="?action=insert">
     <fmt:message key="listDelivery.button.addNewDelivery" bundle="${rb}"  var="buttonValue" />
     <input type="submit" value="${buttonValue}"/> </a></p>
</body>
</html>