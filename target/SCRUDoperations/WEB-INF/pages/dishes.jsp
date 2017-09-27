<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page autoFlush="true" buffer="1094kb" %>
<%
    // Create an ArrayList with test data
    ArrayList<String> list = new ArrayList();
    list.add("Zakuski");
    list.add("Pervie Blyuda");
    list.add("Vtorie Blyuda");
    list.add("Desert");
    pageContext.setAttribute("razdely", list);
%>

<html>

<head>
    <title>Dish Page</title>

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
            background-color: transparent;
        }
    </style>
</head>
<body style="background: url(/№1.jpg); background-size: cover">
<div align="center">

    <c:import url="/WEB-INF/pages/header.jsp"></c:import>

    <br/>
    <b style="color: white; font-size: 30px">Menu</b>

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

        <c:if test="${!empty listDishes}">

            <th width="50px">ID</th>
            <th width="150px">Name</th>
            <th width="200px">Category</th>
            <th width="100px">Cost</th>
            <th width="100px">Weight</th>
            <th width="100px">Edit</th>
            <th width="100px">Delete</th>

            <%--<th width="20">ID</th>--%>
            <%--<th width="60">Name</th>--%>
            <%--<th width="60">Category</th>--%>
            <%--<th width="20">Cost</th>--%>
            <%--<th width="20">Weight</th>--%>
            <%--<th width="30">Edit</th>--%>
            <%--<th width="30">Delete</th>--%>
            <c:forEach items="${listDishes}" var="dish">
                <tr>
                    <td>${dish.dishId}</td>
                    <td><a href="/dishdata/${dish.dishId}">${dish.dishName}</a></td>
                    <td>${dish.category}</td>
                        <%--<td>${dish.cost/100}${dish.cost%100}</td>--%>
                    <td>${dish.cost}</td>
                    <td>${dish.weight}</td>
                    <td><a href="<c:url value='/dishedit/${dish.dishId}'/>">Edit</a></td>
                    <td><a href="<c:url value='/dishremove/${dish.dishId}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <c:if test="${!empty param.inp1}">
        <c:forEach items="${listDishes}" var="dish">
            <c:if test="${fn:toLowerCase(dish.dishName) == fn:toLowerCase(param.inp1)}">
                <jsp:forward page="/dishdata/${dish.dishId}"></jsp:forward>
            </c:if>
        </c:forEach>
    </c:if>

    <br/>
    <b style="color: white; font-size: 30px">Add a Dish</b>

    <c:url var="addAction" value="/dishes/add"/>

    <form:form action="${addAction}" commandName="dish">
        <table class="tg">
            <c:if test="${!empty dish.dishName}">
                <tr>
                    <td width="200px">
                        <form:label path="dishId">
                            <spring:message text="ID"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="dishId" readonly="true" size="90" disabled="true"/>
                        <form:hidden path="dishId"/>
                    </td>
                </tr>
            </c:if>
            <c:if test="${empty dish.dishName}">
                <tr>
                        <td width="200px">
                        <form:label path="dishId">
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
                        <form:input path="dishId" size="90" disabled="true"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td>
                    <form:label path="dishName">
                        <spring:message text="DishName"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="dishName" size="90"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="category">
                        <spring:message text="Category"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="category" size="90"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="ingredients">
                        <spring:message text="Ingredients"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="ingredients" size="90"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="cost">
                        <spring:message text="Cost"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="cost" size="90"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="weight">
                        <spring:message text="Weight"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="weight" size="90"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty dish.dishName}">
                        <input type="submit"
                               value="<spring:message text="Edit Dish"/>"/>
                    </c:if>
                    <c:if test="${empty dish.dishName}">
                        <input type="submit"
                               value="<spring:message text="Add Dish"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>

</div>
</body>
</html>