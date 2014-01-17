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
    <script type="text/javascript">
        function redirect(){
            document.userInformation.action =  "${pageContext.request.contextPath}" + "/users/";
            document.userInformation.method ="get";
            document.userInformation.forward("${pageContext.request.contextPath}" + "/users/");
            return true;
        }
    </script>
</head>
<body>

<form name="userInformation" action="${action}" method="${method}">

    <table>
        <tr>
            <td align="right">
                Nom :
            </td>
            <td>
                <input name="firstname" type="text" value="${user.firstname}" ${disabled}/>
            </td>
        </tr>
        <tr>
            <td align="right">
                Prénom :
            </td>
            <td>
                <input name="lastname" type="text" value="${user.lastname}" ${disabled}/>
            </td>
        </tr>
        <tr>
            <td align="right">
                Date de Naissance :
            </td>
            <td>
                <input name="birthday" type="text"
                       value="<fmt:formatDate value="${user.birthday}" pattern="dd/MM/yyyy"/>" ${disabled}/>
            </td>
        </tr>
        <tr>
            <td align="right">
                Courriel :
            </td>
            <td>
                <input name="email" type="text" value="${user.email}" ${disabled}/>
            </td>
        </tr>
        <tr>
            <td align="right">
                Téléphone :
            </td>
            <td>
                <input name="phone" type="text" value="${user.phone}" ${disabled}/>
            </td>
        </tr>
    </table>
    <table>
      <tr>
    <th>
    <c:if test="${operation == 'create'}">
        <input type="hidden" name="_method" value="POST"/>
        <input type="submit" value="Créer"/>
    </c:if>
    <c:if test="${operation == 'update'}">
        <input type="hidden" name="_method" value="PUT"/>
        <input type="submit" value="Modifier"/>
    </c:if>
    </th>
          <th>
              <input type="submit" value="Retour" onclick="redirect();"/>
          </th>
      </tr>
    </table>
</form>


</body>
</html>
