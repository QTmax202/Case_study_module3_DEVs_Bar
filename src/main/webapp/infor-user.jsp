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

<c:if test="${requestScope['vienNhan'] != null}">
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <p class="text-danger">${vienNhan}</p>
            </div>
        </div>
    </section>
</c:if>

<c:if test="${requestScope['mess'] != null}">
    <%--        Đăng kí thông tin nhân viên--%>
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <form action="/khach-hang?action=them_nhan_vien_post" method="post">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <h6 class="checkout__title">Đăng kí thông tin nhân viên</h6>
                            <div class="row">
                                <div class="col-lg-3">
                                    <div class="checkout__input">
                                        <p>Mã Nhân Viên<span>*</span></p>
                                        <input type="text" name="nv_id">
                                    </div>
                                </div>
                                <div class="col-lg-7">
                                    <div class="checkout__input">
                                        <p>Họ & Tên<span>*</span></p>
                                        <input type="text" name="nv_ten">
                                    </div>
                                </div>
                                <div class="col-lg-2">
                                    <div class="checkout__input">
                                        <p>Giới Tính<span>*</span></p>
                                        <select name="nv_gioi_tinh">
                                            <option value="Nam" name="nv_gioi_tinh">Nam</option>
                                            <option value="Nữ" name="nv_gioi_tinh">Nữ</option>
                                            <option value="Khác" name="nv_gioi_tinh">Khác</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Ngày Sinh<span>*</span></p>
                                        <input type="date" name="nv_ngay_sinh">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Số Điện Thoại<span>*</span></p>
                                        <input type="text" name="nv_phone_number">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Email<span>*</span></p>
                                        <input type="text" name="nv_email">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Địa chỉ<span>*</span></p>
                                        <input type="text" name="nv_dia_chi">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Ca làm việc<span>*</span></p>
                                        <select name="nv_ca_id">
                                            <option value="0h-6h" name="nv_ca_id">Ca 00:01 đến 06:00</option>
                                            <option value="6h-12h" name="nv_ca_id">Ca 06:01 đến 12:00</option>
                                            <option value="12h-18h" name="nv_ca_id">Ca 12:01 đến 18:00</option>
                                            <option value="18h-24h" name="nv_ca_id">Ca 18:01 đến 00:00</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <button type="submit" class="site-btn">XÁC NHẬN</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <%--  Đăng kí thông tin nhân viên--%>
</c:if>

<c:if test="${requestScope['nhan_vien'] != null}">
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <form action="/khach-hang?action=them_acc_nhan_vien" method="post">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <h6 class="checkout__title">Đăng kí tài khoản nhân viên </h6>
                            <p class="text-danger">Đăng kí thông tin nhân viên thành công. Nhập tài khoản đăng
                                kí</p>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Tài Khoản<span>*</span></p>
                                        <input type="text" name="acc_username">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Mật Khẩu<span>*</span></p>
                                        <input type="password" name="acc_password">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Nhập Lại Mật Khẩu<span>*</span></p>
                                        <input type="password" name="acc_password2">
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="acc_nv_id" value="${nhan_vien.nv_id}">
                            <input type="hidden" name="acc_phan_cap" value="NV">
                            <br>
                            <button type="submit" class="site-btn">XÁC NHẬN</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <%--  Đăng kí thông tin nhân viên--%>
</c:if>

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
