<jsp:useBean id="points" class="ru.itmo.p3214.s312198.web.model.PointsData" scope="application"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="results-table">
    <tr class="results-table-header">
        <th>Date</th>
        <th>X</th>
        <th>Y</th>
        <th>R</th>
        <th>Result</th>
    </tr>
    <c:forEach var="point" items="#{points.all}">
        <c:choose>
            <c:when test="${point.r==-999999}">
                <tr>
                    <td class="result-table-column result-date">${point.dateAsString}</td>
                    <td class="result-table-column result-number">-</td>
                    <td class="result-table-column result-number">-</td>
                    <td class="result-table-column result-number">-</td>
                    <td class="result-table-column result-bool">Invalid input</td>
                </tr>
            </c:when>
            <c:otherwise>
                <tr>
                    <td class="result-table-column result-date">${point.dateAsString}</td>
                    <td class="result-table-column result-number">${point.x}</td>
                    <td class="result-table-column result-number">${point.y}</td>
                    <td class="result-table-column result-number">${point.r}</td>
                    <td class="result-table-column result-bool">${point.hit?"hit":"-"}</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</table>