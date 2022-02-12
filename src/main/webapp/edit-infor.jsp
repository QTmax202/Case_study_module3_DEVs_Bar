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

<c:if test="${requestScope['tai-khoan'] != null}">
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <p class="text-danger">Sửa thông tin thành công</p>
            </div>
        </div>
    </section>
</c:if>


<c:if test="${requestScope.nhan_vien.nv_id != null}">
    <%--        Đăng kí thông tin nhân viên--%>
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <form action="/khach-hang?action=sua_nhan_vien_post" method="post">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <h6 class="checkout__title">Thay đổi thông tin nhân viên</h6>
                            <input type="text" name="nv_id" value="${nhan_vien.nv_id}">
                            <div class="row">
                                <div class="col-lg-10">
                                    <div class="checkout__input">
                                        <p>Họ & Tên<span>*</span></p>
                                        <input type="text" name="nv_ten" value="${nhan_vien.nv_ten}">
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
                                        <p>Tài khoản<span>*</span></p>
                                        <p>${account.acc_username}</p>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Mật khẩu<span>*</span></p>
                                        <input type="text" name="acc_password" value="${account.acc_password}">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Ngày Sinh<span>*</span></p>
                                        <input type="date" name="nv_ngay_sinh"  value="${nhan_vien.nv_ngay_sinh}">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Số Điện Thoại<span>*</span></p>
                                        <input type="text" name="nv_phone_number" value="${nhan_vien.nv_phone_number}">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Email<span>*</span></p>
                                        <input type="text" name="nv_email" value="${nhan_vien.nv_email}">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Địa chỉ<span>*</span></p>
                                        <input type="text" name="nv_dia_chi" value="${nhan_vien.nv_dia_chi}">
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

<c:if test="${requestScope.khach_hang.kh_id != null}">
    <%--        Đăng kí thông tin nhân viên--%>
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <form action="/khach-hang?action=sua_khach_hang_post" method="post">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <h6 class="checkout__title">Thay đổi thông tin khách hàng</h6>
                            <input type="text" name="kh_id" value="${khach_hang.kh_id}">
                            <div class="row">
                                <div class="col-lg-10">
                                    <div class="checkout__input">
                                        <p>Họ & Tên<span>*</span></p>
                                        <input type="text" name="kh_ten" value="${khach_hang.kh_ten}">
                                    </div>
                                </div>
                                <div class="col-lg-2">
                                    <div class="checkout__input">
                                        <p>Giới Tính<span>*</span></p>
                                        <select name="kh_gioi_tinh">
                                            <option value="Nam" name="kh_gioi_tinh">Nam</option>
                                            <option value="Nữ" name="kh_gioi_tinh">Nữ</option>
                                            <option value="Khác" name="kh_gioi_tinh">Khác</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Tài khoản<span>*</span></p>
                                        <p>${account.acc_username}</p>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Mật khẩu<span>*</span></p>
                                        <input type="text" name="acc_password" value="${account.acc_password}">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Số Điện Thoại<span>*</span></p>
                                        <input type="text" name="kh_phone_number" value="${khach_hang.kh_phone_number}">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Địa chỉ<span>*</span></p>
                                        <input type="text" name="kh_dia_chi" value="${khach_hang.kh_dia_chi}">
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
