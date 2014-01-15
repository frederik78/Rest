<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: Frederic
  Date: 28/12/13
  Time: 00:07
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="definitions.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<c:if test="${fn:length(users) > 0}">
    <table>
        <tr>
            <th>Prénom</th>
            <th>Nom</th>
            <th>Date de naissance</th>
            <th>Courriel</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr style="text-align: center;">
                <td>${user.lastname}</td>
                <td>${user.firstname}</td>
                <td>
                    <fmt:formatDate value="${user.birthday}" pattern="dd/MM/yyyy"/></td>
                <td>${user.email}</td>
                <td>
                    <table>
                        <tr>
                            <th>
                                <form action="user/${user.id}" method="get">
                                    <input type="submit" value="Détail"/>
                                </form>
                            </th>
                            <th>
                                <form action="user/${user.id}" method="get">
                                     <input type="hidden" name="update" value="true" id="update"/>
                                    <input type="submit" value="Mise à Jour"/>
                                </form>
                            </th>
                        </tr>
                    </table>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<form action="new" method="get">
    <input type="submit" value="Créer"/>
</form>
</body>
</html>
