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

<div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('img/index/sign-in.jpg');"></div>
    <div class="contents order-2 order-md-1">

        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-md-7">
                    <h3>Đăng nhập
                        <strong>
                            <a href="<c:url value="/hospital?action=home"/>">Pet Hospital</a>
                        </strong></h3>
                    <p class="text-danger">${mess}</p>
                    <hr>
                    <form action="<c:url value="/sign-in?action=logIn"/>" method="post">
                        <div class="form-group first">
                            <label for="username">Tài khoản</label>
                            <input type="text" class="form-control" placeholder="Nhập tài khoản" id="username" name="acc_username">
                        </div>
                        <div class="form-group last mb-3">
                            <label for="password">Mật khẩu</label>
                            <input type="password" class="form-control" placeholder="Nhập mật khẩu" id="password" name="acc_password">
                        </div>

                        <div class="form-group form-check">
                            <input name="remember" value="1" type="checkbox" class="form-check-input" id="exampleCheck1">
                            <label class="form-check-label" for="exampleCheck1">Remember me</label>
                        </div>

                        <div class="d-flex mb-5 align-items-center">
                            <span class="ml-auto"><a href="sign-up.jsp" class="forgot-pass">Đăng kí</a></span>
                        </div>

                        <input type="submit" value="Đăng nhập" class="btn btn-block btn-primary" href="<c:url value="/hospital?action=home"/>">

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