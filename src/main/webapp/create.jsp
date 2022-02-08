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

            <form action="#">
                <div class="row">
                    <div class="col-lg-8 col-md-6">
                        <h6 class="checkout__title">Thêm Thú Cưng</h6>
                        <div class="row">
                            <div class="col-lg-3">
                                <div class="checkout__input">
                                    <p>Chọn Giống Pet<span>*</span></p>
                                    <label>
                                        <select name="">
                                            <option value="">Pug</option>
                                            <option value="">Poodle</option>
                                        </select>
                                    </label>
                                </div>
                            </div>
                            <div class="col-lg-9">
                                <div class="checkout__input">
                                    <p>Nhập Tên<span>*</span></p>
                                    <input type="text" name="">
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Nhập Đường Dẫn Ảnh<span>*</span></p>
                            <input type="text" name="">
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Ngày Sinh<span>*</span></p>
                                    <input type="date"  name="">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Đơn Giá<span>*</span></p>
                                    <input type="text" placeholder="VND" name="">
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Mô Tả</p>
                            <input type="text" name="">
                        </div>
                        <button type="submit" class="site-btn">XÁC NHẬN</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</section>
<!-- Thêm Thú Cưng End -->

<!-- Thêm Phụ Kiện Begin -->
<section class="checkout spad">
    <div class="container">
        <div class="checkout__form">
            <form action="#">
                <div class="row">
                    <div class="col-lg-8 col-md-6">
                        <h6 class="checkout__title">Thêm Phụ Kiện</h6>
                        <div class="row">
                            <div class="col-lg-3">
                                <div class="checkout__input">
                                    <p>Chọn Phụ Kiện<span>*</span></p>
                                    <label>
                                        <select name="">
                                            <option value="">Pug</option>
                                            <option value="">Poodle</option>
                                        </select>
                                    </label>
                                </div>
                            </div>
                            <div class="col-lg-9">
                                <div class="checkout__input">
                                    <p>Nhập Tên<span>*</span></p>
                                    <input type="text" name="">
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Nhập Đường Dẫn Ảnh<span>*</span></p>
                            <input type="text" name="">
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Số Lượng<span>*</span></p>
                                    <input type="text" name="">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Đơn Giá<span>*</span></p>
                                    <input type="text" placeholder="VND" name="">
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Mô Tả</p>
                            <input type="text">
                        </div>
                        <button type="submit" class="site-btn">XÁC NHẬN</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>
<!-- Thêm Phụ Kiện End -->

<!-- Thêm Dịch Vụ Begin -->
<section class="checkout spad">
    <div class="container">
        <div class="checkout__form">
            <form action="#">
                <div class="row">
                    <div class="col-lg-8 col-md-6">
                        <h6 class="checkout__title">Thêm Dịch Vụ</h6>
                        <div class="row">
                            <div class="col-lg-3">
                                <div class="checkout__input">
                                    <p>Chọn Dịch Vụ<span>*</span></p>
                                    <label>
                                        <select name="">
                                            <option value="">Pug</option>
                                            <option value="">Poodle</option>
                                        </select>
                                    </label>
                                </div>
                            </div>
                            <div class="col-lg-9">
                                <div class="checkout__input">
                                    <p>Nhập Tên<span>*</span></p>
                                    <input type="text" name="">
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Nhập Đường Dẫn Ảnh<span>*</span></p>
                            <input type="text" name="">
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Thời gian đặt<span>*</span></p>
                                    <input type="time" name="">

                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Đơn Giá<span>*</span></p>
                                    <input type="text" placeholder="VND" name="">
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Mô Tả</p>
                            <input type="text">
                        </div>
                        <button type="submit" class="site-btn">XÁC NHẬN</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>
<!-- Thêm Dịch VỤ End -->

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
