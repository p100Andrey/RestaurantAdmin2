<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page session="false" %>
<%@ page autoFlush="true" buffer="1094kb" %>

<html>
<head>
    <title>Stock</title>

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

    <br/>
    <h1 style="color: white">Stock</h1>

    <form>
        <table class="tg-4eph">
            <tr>
                <td width="560px"></td>
                <td><input type="text" name="inp1" value="" width="120px"/></td>
                <td><input type="submit" value="Search" width="50px"/></td>
            </tr>
        </table>
    </form>

    <table class="tg">

        <c:if test="${!empty listStock}">

            <tr>
                <th width="30px">ID</th>
                <th width="100px">Ingredient name</th>
                <th width="100px">Quantity</th>
                <th width="100px">Measure</th>
                <th width="50px">Edit</th>
                <th width="50px">Delete</th>
            </tr>
            <c:forEach items="${listStock}" var="stock">
                <tr>
                    <td>${stock.stockId}</td>
                    <td>${stock.ingredientName}</td>
                    <td>${stock.quantity}</td>
                    <td>${stock.measure}</td>
                    <td><a href="<c:url value='/stockedit/${stock.stockId}'/>">Edit</a></td>
                    <td><a href="<c:url value='/stockremove/${stock.stockId}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <c:if test="${!empty param.inp1}">
        <c:forEach items="${listStock}" var="stock">
            <c:if test="${fn:toLowerCase(stock.ingredientName) == fn:toLowerCase(param.inp1)}">
                <jsp:forward page="/ingredientdata/${stock.stockId}"></jsp:forward>
            </c:if>
        </c:forEach>
    </c:if>

    <br/>
    <b style="color: white; font-size: 30px">Add a Stock</b>

    <c:url var="addAction" value="/stock/add"/>

    <form:form action="${addAction}" commandName="stock">
        <table class="tg">
            <c:if test="${!empty stock.ingredientName}">
                <tr>
                    <td width="200px">
                        <form:label path="stockId">
                            <spring:message text="ID"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="stockId" readonly="true" size="90" disabled="true"/>
                        <form:hidden path="stockId"/>
                    </td>
                </tr>
            </c:if>
            <c:if test="${empty stock.ingredientName}">
                <tr>
                    <td width="200px">
                        <form:label path="stockId">
                            <spring:message text="ID"/>
                        </form:label>
                    </td>
                        <%--<c:set var="stop" value="0"/>--%>
                        <%--<c:forEach var="i" begin="1" end="${listDishes.size()+1}">--%>
                        <%--<c:set var="flag" value="true"/>--%>
                        <%--<c:forEach items="${listDishes}" var="dish">--%>
                        <%--<c:if test="${i == dish.dishId}">--%>
                        <%--<c:set var="flag" value="false"/>--%>
                        <%--</c:if>--%>
                        <%--</c:forEach>--%>
                        <%--<c:if test="${flag && stop == 0}">--%>
                        <%--<td>--%>
                        <%--<form:input path="dishId" value="${i}" size="90"/>--%>
                        <%--</td>--%>
                        <%--<c:set var="stop" value="${i}"/>--%>
                        <%--</c:if>--%>
                        <%--</c:forEach>--%>
                    <td>
                        <form:input path="stockId" size="90" disabled="true"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td>
                    <form:label path="ingredientName">
                        <spring:message text="IngredientName"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="ingredientName" size="90"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="quantity">
                        <spring:message text="Quantity"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="quantity" size="90"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="measure">
                        <spring:message text="Measure"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="measure" size="90"/>
                </td>
            </tr>

            <td colspan="2">
                <c:if test="${!empty stock.ingredientName}">
                    <input type="submit"
                           value="<spring:message text="Edit Stock"/>"/>
                </c:if>
                <c:if test="${empty stock.ingredientName}">
                    <input type="submit"
                           value="<spring:message text="Add Stock"/>"/>
                </c:if>
            </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>