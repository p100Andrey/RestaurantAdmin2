<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page session="false" %>
<%@ page autoFlush="true" buffer="1094kb" %>
<html>
<head>
    <title>Orders</title>

    <style>
        a {
            text-decoration: none;
        }

        /* Убираем подчеркивание у ссылок */
        a:hover {
            text-decoration: underline;
        }

        /* Добавляем подчеркивание при наведении курсора мыши на ссылку */
    </style>

    <style type="text/css">
        .tg {
            width: 800px;
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body style="background: url(/№1.jpg); background-size: cover">
<div align="center">

    <c:import url="/WEB-INF/pages/header.jsp"></c:import>

    <table class="tg">
        <br/>
        <h1 style="color: white">Orders list</h1>

        <c:if test="${!empty listOrder}">

            <tr>
                <th width="50px">ID</th>
                <th width="200px">Waiter</th>
                <th width="300px">Dishes Name</th>
                <th width="50px">Table Number</th>
                <th width="200px">Date</th>
            </tr>

            <c:forEach items="${listOrder}" var="order">
                <tr>
                    <c:set var="dishes" value=""/>

                    <td>${order.orderId}</td>

                    <c:forEach items="${listWorkers}" var="worker">
                        <c:if test="${order.waiter == worker.workerId}">
                            <td>${worker.name}</td>
                        </c:if>
                    </c:forEach>

                    <c:forEach items="${listOrderDishes}" var="orderDishes">
                        <c:if test="${order.orderId == orderDishes.orderId}">
                            <c:forEach items="${listDishes}" var="dish">
                                <c:if test="${orderDishes.dishId == dish.dishId}">
                                    <c:set var="dishes" value="${dishes.concat(dish.dishName).concat('; ')}"/>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>

                    <td>${dishes}</td>

                    <td>${order.tableNumber}</td>
                    <td>${order.date}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

</div>
</body>
</html>