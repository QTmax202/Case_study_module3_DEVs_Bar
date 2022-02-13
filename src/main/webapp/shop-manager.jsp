<%--
  Created by IntelliJ IDEA.
  User: QT-247202
  Date: 07/02/2022
  Time: 4:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Male-Fashion | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
          rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
<jsp:include page="_Menu.jsp"></jsp:include>

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb__text">
                    <h4>Hóa Đơn</h4>
                    <div class="breadcrumb__links">
                        <a href="<c:url value="/shop"/>">Shop</a>
                        <span>Hóa Đơn</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Shopping Cart Section Begin -->
<section class="shopping-cart spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-9">
                <div class="shopping__cart__table">
                    <table>
                        <thead>
                        <tr><h4 class="checkout__title text-center">Quản lý hóa đơn</h4></tr>
                        <tr>
                            <th>ID</th>
                            <th>ID Nhân viên</th>
                            <th>ID Khách hàng</th>
                            <th>Ngày lập</th>
                            <th>Tổng đơn</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope['hoa_dons']}" var="hoa_don">
                            <tr>
                                <td class="cart__price">${hoa_don.getHd_id()}</td>
                                <td class="cart__price">${hoa_don.getHd_nv_id()}</td>
                                <td class="cart__price">${hoa_don.getHd_kh_id()}</td>
                                <td class="cart__price">${hoa_don.getNgay_lap_hd()}</td>
                                <td class="cart__price">
                                    <fmt:setLocale value="vi_VN"/>
                                    <fmt:formatNumber value="${hoa_don.getTong_tien()}" type="currency"/>
                                </td>
                                <td class="cart__close">
                                    <a href="<c:url value="/gio_hang?action=delete_hd_id&hd_id=${hoa_don.getHd_id()}"/>">
                                        <i class="fa fa-close"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="continue__btn">
                                <a href="<c:url value="/shop"/>">Quay lại cửa hàng</a>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="continue__btn update__btn">
                                <a href="<c:url value="/gio_hang?action=quan_ly_hoa_don"/>">
                                    <i class="fa fa-spinner"></i> Cập nhật giỏ hàng
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3">
                <br>
                <br>
                <br>
                <br>
                <br>
                <div class="cart__total">
                    <h6>Doanh thu</h6>
                    <ul>
                        <li>Lợi nhuận <span>
                            <fmt:setLocale value="vi_VN"/>
                            <fmt:formatNumber value="${doanh_thu}" type="currency"/>
                        </span></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shopping Cart Section End -->

<jsp:include page="_Footer.jsp"></jsp:include>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery.nicescroll.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/jquery.countdown.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>
</html>
