<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/owl_login.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap_login.min.css">

    <!-- Style -->
    <link rel="stylesheet" href="css/style_login.css">

    <title>Login #2</title>
</head>
<body>
<!-- Page Preloder -->


<div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('img/index/sign-in.jpg');"></div>
    <div class="contents order-2 order-md-1">
        <c:if test="${requestScope['mess'] != null}">
            <%--Đăng kí thông tin khách hàng        --%>
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-md-7">
                        <h3>Đăng ký thông tin <br>
                            <strong>Pet Hospital</strong>
                        </h3>
                        <p class="text-danger">${message}</p>
                        <hr>
                        <form action="/khach-hang?action=them_khach_hang_post" method="post">
                            <div class="form-group first">
                                <label>Họ & Tên</label>
                                <input type="text" class="form-control" placeholder="Nhập họ tên" name="kh_ten" required>
                            </div>
                            <div class="form-group last mb-3">
                                <label>Giới tính</label>
                                <select name="kh_gioi_tinh">
                                    <option value="Nam" name="kh_gioi_tinh">Nam</option>
                                    <option value="Nữ" name="kh_gioi_tinh">Nữ</option>
                                    <option value="Khác" name="kh_gioi_tinh">Khác</option>
                                </select>
                            </div>
                            <div class="form-group last mb-3">
                                <label>Số điện thoại</label>
                                <input type="text" class="form-control" placeholder="Nhập số điện thoại"
                                       name="kh_phone_number" required>
                            </div>
                            <div class="form-group last mb-3">
                                <label>Địa chỉ</label>
                                <input type="text" class="form-control" placeholder="Nhập địa chỉ" name="kh_dia_chi" required>
                            </div>

                            <div class="d-flex mb-5 align-items-center">
                                <span class="ml-auto"><a href="sign-in.jsp" class="forgot-pass">Quay lại</a></span>
                            </div>

                            <input type="submit" value="ĐĂNG KÝ" class="btn btn-block btn-primary">
                        </form>
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${requestScope['khach_hang'] != null}">
            <%--Đăng kí tài khoản        --%>
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-md-7">
                        <h3>Đăng ký tài khoản <br>
                            <strong>Pet Hospital</strong>
                        </h3>
                        <p class="text-danger">${message}</p>
                        <hr>
                        <form action="/khach-hang?action=them_acc_khach_hang" method="post">
                            <div class="form-group first">
                                <input type="hidden" class="form-control" name="acc_kh_id" value="${requestScope['khach_hang'].getKh_id()}">
                            </div>
                            <div class="form-group first">
                                <label>Tài khoản</label>
                                <input type="text" class="form-control" placeholder="Nhập tài khoản"
                                       name="acc_username" required>
                            </div>
                            <div class="form-group first">
                                <input type="hidden" class="form-control" name="acc_phan_cap" value="KH">
                            </div>
                            <div class="form-group last mb-3">
                                <label>Mật khẩu</label>
                                <input type="password" class="form-control" placeholder="Nhập mật khẩu"
                                       name="acc_password" required>
                            </div>
                            <div class="form-group last mb-3">
                                <label>Nhập lại mật khẩu</label>
                                <input type="password" class="form-control" placeholder="Nhập lại mật khẩu"
                                       name="acc_password2" required>
                            </div>

                            <div class="d-flex mb-5 align-items-center">
                                <span class="ml-auto"><a href="sign-in.jsp" class="forgot-pass">Đăng nhập</a></span>
                            </div>

                            <input type="submit" value="ĐĂNG KÝ" class="btn btn-block btn-primary">

                        </form>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</div>


<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
