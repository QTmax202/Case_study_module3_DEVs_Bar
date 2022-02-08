<%--
  Created by IntelliJ IDEA.
  User: QT-247202
  Date: 21/01/2022
  Time: 2:27 CH
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
    <title>Trang Chủ</title>

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

<!-- Banner Section Begin -->
<section class="banner spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-7 offset-lg-4">
                <div class="banner__item">
                    <div class="banner__item__pic">
                        <img src="img/banner/banner-1.jpg" alt="">
                    </div>
                    <div class="banner__item__text">
                        <h2>Thú Cưng</h2>
                        <a href="shop.jsp">Shop now</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-5">
                <div class="banner__item banner__item--middle">
                    <div class="banner__item__pic">
                        <img src="img/banner/banner-2.jpg" alt="">
                    </div>
                    <div class="banner__item__text">
                        <h2>Phụ Kiện</h2>
                        <a href="shop.jsp">Shop now</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-7">
                <div class="banner__item banner__item--last">
                    <div class="banner__item__pic">
                        <img src="img/banner/banner-3.jpg" alt="">
                    </div>
                    <div class="banner__item__text">
                        <h2>Dịch Vụ</h2>
                        <a href="shop.jsp">Shop now</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Banner Section End -->

<!-- Thú Cưng Begin -->
<section class="product spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul class="filter__controls">
                    <li class="active">Thú Cưng</li>
                </ul>
            </div>
        </div>
        <div class="row product__filter">
            <div class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix new-arrivals">
                <div class="product__item">
                    <div class="product__item__pic set-bg" data-setbg="https://matpetfamily.com/wp-content/uploads/2022/01/D0015C3F-5BEC-4097-9222-280EE074B2FE.jpeg">>
                        <ul class="product__hover">
                            <li><a href="#"><img src="img/icon/heart.png" alt=""> <span>Heart</span></a></li>
                            <li><a href="#"><img src="img/icon/search.png" alt=""> <span>Detail</span></a></li>
                        </ul>
                    </div>
                    <div class="product__item__text">
                        <h6>Phốc sóc trắng</h6>
                        <a href="#" class="add-cart">+ Add To Cart</a>
                        <hr>
                        <h5>20.000.000 VND</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Thú Cưng End -->

<!-- Phụ kiện Begin -->
<section class="product spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul class="filter__controls">
                    <li class="active">Phụ Kiện</li>
                </ul>
            </div>
        </div>
        <div class="row product__filter">
            <div class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix new-arrivals">
                <div class="product__item">
                    <div class="product__item__pic set-bg" data-setbg="https://matpetfamily.com/wp-content/uploads/2022/01/D0015C3F-5BEC-4097-9222-280EE074B2FE.jpeg">>
                        <ul class="product__hover">
                            <li><a href="#"><img src="img/icon/heart.png" alt=""> <span>Heart</span></a></li>
                            <li><a href="#"><img src="img/icon/search.png" alt=""> <span>Detail</span></a></li>
                        </ul>
                    </div>
                    <div class="product__item__text">
                        <h6>Phốc sóc trắng</h6>
                        <a href="#" class="add-cart">+ Add To Cart</a>
                        <hr>
                        <h5>20.000.000 VND</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Phụ Kiện End -->

<!-- Dịch Vụ Begin -->
<section class="product spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul class="filter__controls">
                    <li class="active">Dịch Vụ</li>
                </ul>
            </div>
        </div>
        <div class="row product__filter">
            <div class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix new-arrivals">
                <div class="product__item">
                    <div class="product__item__pic set-bg" data-setbg="https://matpetfamily.com/wp-content/uploads/2022/01/D0015C3F-5BEC-4097-9222-280EE074B2FE.jpeg">>
                        <ul class="product__hover">
                            <li><a href="#"><img src="img/icon/heart.png" alt=""> <span>Heart</span></a></li>
                            <li><a href="#"><img src="img/icon/search.png" alt=""> <span>Detail</span></a></li>
                        </ul>
                    </div>
                    <div class="product__item__text">
                        <h6>Phốc sóc trắng</h6>
                        <a href="#" class="add-cart">+ Add To Cart</a>
                        <hr>
                        <h5>20.000.000 VND</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Dịch Vụ End -->

<!-- Categories Section Begin -->
<%--<section class="categories spad">--%>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col-lg-3">--%>
<%--                <div class="categories__text">--%>
<%--                    <h2>Clothings Hot <br/> <span>Shoe Collection</span> <br/> Accessories</h2>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-lg-4">--%>
<%--                <div class="categories__hot__deal">--%>
<%--                    <img src="img/product-sale.png" alt="">--%>
<%--                    <div class="hot__deal__sticker">--%>
<%--                        <span>Sale Of</span>--%>
<%--                        <h5>$29.99</h5>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-lg-4 offset-lg-1">--%>
<%--                <div class="categories__deal__countdown">--%>
<%--                    <span>Deal Of The Week</span>--%>
<%--                    <h2>Multi-pocket Chest Bag Black</h2>--%>
<%--                    <div class="categories__deal__countdown__timer" id="countdown">--%>
<%--                        <div class="cd-item">--%>
<%--                            <span>3</span>--%>
<%--                            <p>Days</p>--%>
<%--                        </div>--%>
<%--                        <div class="cd-item">--%>
<%--                            <span>1</span>--%>
<%--                            <p>Hours</p>--%>
<%--                        </div>--%>
<%--                        <div class="cd-item">--%>
<%--                            <span>50</span>--%>
<%--                            <p>Minutes</p>--%>
<%--                        </div>--%>
<%--                        <div class="cd-item">--%>
<%--                            <span>18</span>--%>
<%--                            <p>Seconds</p>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <a href="#" class="primary-btn">Shop now</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>
<!-- Categories Section End -->

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
