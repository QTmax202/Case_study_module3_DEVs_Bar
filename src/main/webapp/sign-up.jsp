<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<%--        đăng kí thông tin khách hàng--%>
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7">
                <h3>Đăng ký thông tin<strong>Pet Hospital</strong></h3>
                <hr>
                <form action="sign-in.jsp" method="post">
                    <div class="form-group first">
                        <label>Họ & Tên</label>
                        <input type="text" class="form-control" placeholder="Nhập họ tên" name="kh_ten">
                    </div>
                    <div class="form-group last mb-3">
                        <label>Giới tính</label>
                        <input type="text" class="form-control" placeholder="Nhập giới tính" name="kh_gioi_tinh">
                    </div>
                    <div class="form-group last mb-3">
                        <label for="password2">Số điện thoại</label>
                        <input type="text" class="form-control" placeholder="Nhập số điện thoại" name="kh_phone_number">
                    </div>
                    <div class="form-group last mb-3">
                        <label for="password">Địa chỉ</label>
                        <input type="text" class="form-control" placeholder="Nhập địa chỉ" name="kh_dia_chi">
                    </div>

                    <div class="d-flex mb-5 align-items-center">
                        <span class="ml-auto"><a href="sign-in.jsp" class="forgot-pass">Bỏ qua</a></span>
                    </div>

                    <input type="submit" value="ĐĂNG KÝ" class="btn btn-block btn-primary">

                </form>
            </div>
        </div>
    </div>
<%--đăng kí tài khoản khách hàng--%>
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-md-7">
                    <h3>Đăng ký <strong>Pet Hospital</strong></h3>
                    <hr>
                    <%--                    <p class="mb-4">Lorem ipsum dolor sit amet elit. Sapiente sit aut eos consectetur adipisicing.</p>--%>
                    <form action="sign-in.jsp" method="post">
                        <div class="form-group first">
                            <label for="username">Tài khoản</label>
                            <input type="text" class="form-control" placeholder="Nhập tài khoản" id="username">
                        </div>
                        <div class="form-group last mb-3">
                            <label for="password">Mật khẩu</label>
                            <input type="password" class="form-control" placeholder="Nhập mật khẩu" id="password">
                        </div>
                        <div class="form-group last mb-3">
                            <label for="password2">Mật khẩu</label>
                            <input type="password" class="form-control" placeholder="Nhập lại mật khẩu" id="password2">
                        </div>

                        <div class="d-flex mb-5 align-items-center">
                            <%--                            <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>--%>
                            <%--                                <input type="checkbox" checked="checked"/>--%>
                            <%--                                <div class="control__indicator"></div>--%>
                            <%--                            </label>--%>
                            <span class="ml-auto"><a href="sign-in.jsp" class="forgot-pass">Đăng nhập</a></span>
                        </div>

                        <input type="submit" value="Sign Up" class="btn btn-block btn-primary">

                    </form>
                </div>
            </div>
        </div>
    </div>


</div>



<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
