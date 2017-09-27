<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Workers</title>

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
        <h1 style="color: white">Workers</h1>

        <c:if test="${!empty listWorkers}">

            <tr>
                <th width="30px">ID</th>
                <th width="100px">Last name</th>
                <th width="100px">Name</th>
                <th width="100px">Birthday</th>
                <th width="100px">Telephone</th>
                <th width="80px">Position</th>
                <th width="80px">Salary</th>
                <th width="100px">Photo</th>
                <th width="50px">Edit</th>
                <th width="50px">Delete</th>
            </tr>
            <c:forEach items="${listWorkers}" var="worker">
                <tr>
                    <td>${worker.workerId}</td>
                    <td>${worker.lastName}</td>
                    <td>${worker.name}</td>
                    <td>${worker.birthday}</td>
                    <td>${worker.telephone}</td>
                    <td>${worker.position}</td>
                    <td>${worker.salary}</td>
                    <td align="center"><img
                            src="${"/photo/".concat(worker.lastName).concat(worker.name).concat(".jpg")}"></td>
                    <td><a href="<c:url value='/workeredit/${worker.workerId}'/>">Edit</a></td>
                    <td><a href="<c:url value='/workerremove/${worker.workerId}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <br/>
    <b style="color: white; font-size: 30px">Add a Worker</b>

    <c:url var="addAction" value="/workers/add"/>

    <form:form action="${addAction}" commandName="worker">
        <table class="tg">
            <c:if test="${!empty worker.lastName}">
                <tr>
                    <td width="200px">
                        <form:label path="workerId">
                            <spring:message text="ID"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="workerId" readonly="true" size="90" disabled="true"/>
                        <form:hidden path="workerId"/>
                    </td>
                </tr>
            </c:if>
            <c:if test="${empty worker.lastName}">
                <tr>
                    <td width="200px">
                        <form:label path="workerId">
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
                        <form:input path="workerId" size="90" disabled="true"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td>
                    <form:label path="lastName">
                        <spring:message text="LastName"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="lastName" size="90"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="name">
                        <spring:message text="Name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="name" size="90"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="birthday">
                        <spring:message text="Birthday"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="birthday" size="90"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="telephone">
                        <spring:message text="Telephone"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="telephone" size="90"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="position">
                        <spring:message text="Position"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="position" size="90"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="salary">
                        <spring:message text="Salary"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="salary" size="90"/>
                </td>
            </tr>
            <td colspan="2">
                <c:if test="${!empty worker.lastName}">
                    <input type="submit"
                           value="<spring:message text="Edit Worker"/>"/>
                </c:if>
                <c:if test="${empty worker.lastName}">
                    <input type="submit"
                           value="<spring:message text="Add Worker"/>"/>
                </c:if>
            </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>