<<<<<<< HEAD
<%--
  Created by IntelliJ IDEA.
  User: QT-247202
  Date: 08/02/2022
  Time: 4:21 CH
  To change this template use File | Settings | File Templates.
--%>
=======
>>>>>>> 5c649161677bfa5007ab0df811d307c29b028528
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
<<<<<<< HEAD
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<table>
    <h1><a href="<c:url value="/hospital?action=search}"/>"><img
            src="img/icon/search.png" alt=""> <span>Detail</span></a></h1>
    <form action="${pageContext.request.contextPath}/hospital">
    <c:forEach items="${requestScope['pet_shops']}" var="pet_shop">
        <tr>
            <td>${pet_shop.getPs_ten()}</td>
            <td>${pet_shop.getPs_gia()}</td>
            <td>${pet_shop.getPs_anh()}</td>
            <td>${pet_shop.getPs_ngay_sinh()}</td>
            <td>${pet_shop.getPs_gp_id()}</td>
        </tr>
    </c:forEach>
    </form>
</table>
</body>
</html>
=======
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
>>>>>>> 5c649161677bfa5007ab0df811d307c29b028528
