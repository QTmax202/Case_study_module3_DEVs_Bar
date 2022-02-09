<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List users</h1>

<c:forEach items="${giong_pets}" var="giong_pet">
    <p>  <li><a href="#">${giong_pet.gp_id}</a></li></p>
</c:forEach>
<table>
    <tr>hehe</tr>
    </tr>
    <p>${giong_pet.gp_ten}</p>
<%--    <c:forEach var="giong_pet" items="${giong_pets}">--%>
<%--        <tr>--%>
<%--            <td><c:out value="${giong_pet.gp_id}"/></td>--%>
<%--            <td>${giong_pet.gp_ten}</td>--%>
<%--            <td><c:out value="${giong_pet.gp_mo_ta}"/></td>--%>
<%--            <td><c:out value="${giong_pet.gp_lp_id}"/></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
</table>
</body>
</html>