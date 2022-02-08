<%--
  Created by IntelliJ IDEA.
  User: QT-247202
  Date: 08/02/2022
  Time: 4:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<table>
    <h1>adasda</h1>
    <c:forEach items="${requestScope['pet_shops']}" var="pet_shop">
        <tr>
            <td>${pet_shop.getPs_ten()}</td>
            <td>${pet_shop.getPs_gia()}</td>
            <td>${pet_shop.getPs_anh()}</td>
            <td>${pet_shop.getPs_ngay_sinh()}</td>
            <td>${pet_shop.getPs_gp_id()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
