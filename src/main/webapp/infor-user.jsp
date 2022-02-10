<%--
  Created by IntelliJ IDEA.
  User: QT-247202
  Date: 07/02/2022
  Time: 4:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <h4>Manager</h4>
                    <div class="breadcrumb__links">
                        <a href="./index.jsp">Home</a>
                        <%--                        <a href="./shop.jsp">Shop</a>--%>
                        <span>Create Product</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Thêm Thú Cưng Begin -->
<section class="checkout spad">
    <div class="container">
        <div class="checkout__form">

            <form action="${pageContext.request.contextPath}/khachHang?action=creatPost">
                <div class="row">
                    <div class="col-lg-8 col-md-6">
                        <h6 class="checkout__title">Cập Nhật Thông Tin Khách Hàng</h6>
                        <div class="row">
                            <div class="col-lg-9">
                                <div class="checkout__input">
                                    <p>Họ & Tên<span>*</span></p>
                                    <label>
                                        <input type="text" name="kh_name">
                                    </label>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="checkout__input">
                                    <p>Giới Tính<span>*</span></p>
                                    <label>
                                        <select class="w3-select" name="kh_gioi_tinh">
                                            <option value="1">Nam</option>
                                            <option value="2">Nữ</option>
                                            <option value="3">Khác</option>
                                        </select>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Nhập Đường Dẫn Ảnh<span>*</span></p>
                            <input type="text" name="kh_anh">
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Ngày Sinh<span>*</span></p>
                                    <input type="date"  name="kh_ngay_sinh">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Địa Chỉ<span>*</span></p>
                                    <input type="text" placeholder="VND" name="kh_dia_chi">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Email<span>*</span></p>
                                    <input type="text"  name="kh_email">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Số Điện Thoại<span>*</span></p>
                                    <input type="text" placeholder="VND" name="kh_phone_number">
                                </div>
                            </div>
                        </div>
                        <button type="submit" class="site-btn">XÁC NHẬN</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</section>
<!-- Thêm Thú Cưng End -->

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
