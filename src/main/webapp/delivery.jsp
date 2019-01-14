<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>

<c:if test="${locale == 1}"><fmt:setLocale value="en_US" scope="session"/></c:if>
<c:if test="${locale == 2}"><fmt:setLocale value="uk_UA" scope="session"/></c:if>
<fmt:setBundle basename="pageContent" var="rb"/>

<html>
<head>
    <c:set var="currentPage" value="path.page.insertOrEdit" scope="request"/>
    <title>Add new delivery</title>
</head>
<body>
<%@ include file="header.jspf" %>
<div class="wrapper container">
<script>
    $(function () {
        $('input[name=sentDate]').datepicker();
        $('input[name=deliveryDate]').datepicker();
    });
</script>

<form style="width:1200px" method="POST" action='?action=save' name="frmAddDelivery">
    <input type="hidden" readonly="readonly" name="id"
           value="<c:out value="${delivery.id}" />"/> <br/>
    <input type="hidden" name="user_id"
           value="<c:out value="${delivery.userId}" />"/> <br/>
    <P>
        <label class="control-label col-sm-2" for="sendersFirstName"> <fmt:message key="delivery.label.sendersFirstName" bundle="${rb}"/>:</label>
        <input type="text" name="senders_first_name" value="<c:out value="${delivery.sendersFirstName}" />"/> <br/>
    </P>
    <P>
        <label class="control-label col-sm-2" for="sendersLastName"> <fmt:message key="delivery.label.sendersLastName" bundle="${rb}"/>:</label>
        <input type="text" name="senders_last_name" value="<c:out value="${delivery.sendersLastName}" />"/> <br/>
    </P>
    <P>
        <label class="control-label col-sm-2" for="recipientFirstName"> <fmt:message key="delivery.label.recipientFirstName" bundle="${rb}"/>:</label>
        <input type="text" name="recipient_first_name" value="<c:out value="${delivery.recipientFirstName}" />"/> <br/>
    </P>
    <P>
        <label class="control-label col-sm-2" for="recipientLastName"> <fmt:message key="delivery.label.recipientLastName" bundle="${rb}"/>:</label>
        <input type="text" name="recipient_last_name" value="<c:out value="${delivery.recipientLastName}" />"/> <br/>
    </P>
    <P>
        <label class="control-label col-sm-2" for="fromCity"> <fmt:message key="delivery.label.fromCity" bundle="${rb}"/>:</label>
        <select name="city_from_id">
            <c:forEach items="${cities}" var="city">
                <option value="${city.id}" ${city.id==delivery.fromCity ? 'selected' : ''}>${city.name}</option>
            </c:forEach>
        </select>
    </P>
    <P>
        <label class="control-label col-sm-2" for="toCity"> <fmt:message key="delivery.label.toCity" bundle="${rb}"/>:</label>
        <select name="city_to_id">
            <c:forEach items="${cities}" var="city">
                <option value="${city.id}" ${city.id==delivery.toCity ? 'selected' : ''}>${city.name}</option>
            </c:forEach>
        </select>
    </P>
    <P>
        <label class="control-label col-sm-2" for="goodsTypeId"> <fmt:message key="delivery.label.goodsTypeId" bundle="${rb}"/>:</label>
        <select name="goods_type_id">
            <c:forEach items="${types}" var="type">
                <option value="${type.idGoodsType}" ${type.idGoodsType==delivery.goodsType ? 'selected' : ''} >${type.name}</option>
            </c:forEach>
        </select>
    </P>
    <P>
        <label class="control-label col-sm-2" for="weight"> <fmt:message key="delivery.label.weight" bundle="${rb}"/>:</label>
        <input type="text" name="weight" value="<c:out value="${delivery.weight}" />"/><br/>
    </P>
    <P>
        <label class="control-label col-sm-2" for="sendersPhone"> <fmt:message key="delivery.label.sendersPhone" bundle="${rb}"/>:</label>
        <input type="tel" id="sendersPhone" name="senders_phone" pattern="(\+?\d[- .]*){7,13}" required value="<c:out value="${delivery.sendersPhone}" />"/> <br/>
    </P>
    <P>
        <label class="control-label col-sm-2" for="recipientPhone"> <fmt:message key="delivery.label.recipientPhone" bundle="${rb}"/>:</label>
        <input type="text" id="recipientPhone" name="recipient_phone" pattern="(\+?\d[- .]*){7,13}" required value="<c:out  value="${delivery.recipientPhone}" />"/><br/>
    </P>
    <P>
        <label class="control-label col-sm-2" for="sentDate"> <fmt:message key="delivery.label.sentDate" bundle="${rb}"/>:</label>
        <input type="date" id="sentDate" name="sent_date"
               value="<fmt:formatDate pattern="yyyy-MM-dd" value="${delivery.sentDate}"/>  />"/><br/>
    </P>
    <P>
        <label class="control-label col-sm-2" for="deliveryDate"> <fmt:message key="delivery.label.deliveryDate" bundle="${rb}"/>:</label>
        <input type="date" id="deliveryDate" name="delivery_date"
               value="<fmt:formatDate pattern="yyyy-MM-dd" value="${delivery.deliveryDate}" />/>"/> <br/>
    </P>

    <input type="hidden" name="paymentStatus" value="<c:out value="${delivery.paymentStatus}" />"/><br/>
    <p>
        <fmt:message key="delivery.button.save" bundle="${rb}" var="buttonValue"/>
        <input type="submit" class="control-label col-sm-2" value="${buttonValue}"/>
    </p>

</form>
</div>
</body>
</html>