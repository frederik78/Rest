<%--
  Created by IntelliJ IDEA.
  User: Frederic
  Date: 31/12/13
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="definitions.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <tr>
        <td align="right">
            Nom :
        </td>
        <td>
            <input type="text" value="${user.firstname}" disabled="${disabled}"/>
        </td>
    </tr>
    <tr>
        <td align="right">
            Prénom :
        </td>
        <td>
            <input type="text" value="${user.lastname}" disabled="${disabled}"/>
        </td>
    </tr>
    <tr>
        <td align="right">
            Date de Naissance :
        </td>
        <td>
            <input type="text"  value = "<fmt:formatDate value="${user.birthday}" pattern="dd/MM/yyyy"/>" disabled="${disabled}"/>
        </td>
    </tr>
    <tr>
        <td align="right">
            courriel :
        </td>
        <td>
            <input type="text"  value = "${user.email}" disabled="${disabled}"/>
        </td>
    </tr>
    <tr>
        <td align="right">
            téléphone :
        </td>
        <td>
            <input type="text"  value = "${user.phone}" disabled="${disabled}"/>
        </td>
    </tr>

</table>


</body>
</html>