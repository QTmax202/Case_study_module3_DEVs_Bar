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
                    <h4>Mua sắm</h4>
                    <div class="breadcrumb__links">
                        <a href="<c:url value="/hospital"/>">Trang chủ</a>
                        <a href="<c:url value="/shop"/>">Cửa hàng</a>
                        <span>Hóa đơn</span>
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
            <div class="col-lg-8">
                <div class="shopping__cart__table">
                    <c:if test="${lists_hd_ps != null}">
                        <table>
                            <thead>
                            <tr><h4 class="checkout__title text-center">Thú Cưng</h4></tr>
                            <tr>
                                <th>SẢN PHẨM</th>
                                <th>SỐ LƯỢNG</th>
                                <th>THÀNH TIỀN</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope['lists_hd_ps']}" var="hd_ps">
                                <tr>
                                    <td class="product__cart__item">
                                        <div class="product__cart__item__pic">
                                            <img src="img/shopping-cart/cart-4.jpg" alt="">
                                        </div>
                                        <div class="product__cart__item__text">
                                            <h6>${hd_ps.getHdmhtt_ten()}</h6>
                                        </div>
                                    </td>
                                    <td class="quantity__item">
                                        <div class="quantity">
                                            <div class="pro-qty-2">
                                                <input type="text" value="1">
                                            </div>
                                        </div>
                                    </td>
                                    <td class="cart__price">
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber value="${hd_ps.getHdmhtt_thanh_tien()}" type="currency"/>
                                    </td>
                                    <td class="cart__close">
                                        <a href="<c:url value="/gio_hang?action=delete_ps_pk&hd_id=${hd_ps.getHdmhtt_id()}&hd_kh_id=${sessionScope.acc_khach_hang.getAcc_kh_id()}"/>">
                                            <i class="fa fa-close"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <br>
                    <c:if test="${lists_hd_pk != null}">
                        <table>
                            <thead>
                            <tr><h4 class="checkout__title text-center">Phụ Kiện</h4></tr>
                            <tr>
                                <th>SẢN PHẨM</th>
                                <th>SỐ LƯỢNG</th>
                                <th>THÀNH TIỀN</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope['lists_hd_pk']}" var="hd_pk">
                                <tr>
                                    <td class="product__cart__item">
                                        <div class="product__cart__item__pic">
                                            <img src="img/shopping-cart/cart-4.jpg" alt="">
                                        </div>
                                        <div class="product__cart__item__text">
                                            <h6>${hd_pk.getHdmhtt_ten()}</h6>
                                        </div>
                                    </td>
                                    <td class="quantity__item">
                                        <div class="quantity">
                                            <div class="pro-qty-2">
                                                <input type="text" value="1">
                                            </div>
                                        </div>
                                    </td>
                                    <td class="cart__price">
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber value="${hd_pk.getHdmhtt_thanh_tien()}" type="currency"/>
                                    </td>
                                    <td class="cart__close">
                                        <a href="<c:url value="/gio_hang?action=delete_ps_pk&hd_id=${hd_pk.getHdmhtt_id()}&hd_kh_id=${sessionScope.acc_khach_hang.getAcc_kh_id()}"/>">
                                            <i class="fa fa-close"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <br>
                    <c:if test="${lists_hd_dv != null}">
                        <table>
                            <thead>
                            <tr><h4 class="checkout__title text-center">Dịch vụ</h4></tr>
                            <tr>
                                <th>DỊCH VỤ</th>
                                <th>THỜI GIAN ĐẶT</th>
                                <th>THÀNH TIỀN</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope['lists_hd_dv']}" var="hd_dv">
                                <tr>
                                    <td class="product__cart__item">
                                        <div class="product__cart__item__pic">
                                            <img src="img/shopping-cart/cart-4.jpg" alt="">
                                        </div>
                                        <div class="product__cart__item__text">
                                            <h6>${hd_dv.getHddvtt_ctdv_ten()}</h6>
                                        </div>
                                    </td>
                                    <td class="quantity__item">
                                        <div class="quantity">
                                                <%--                                        <div class="pro-qty-2">--%>
                                                <%--                                            <input type="text" value="1">--%>
                                                <%--                                        </div>--%>
                                            <div>
                                                <h6>${hd_dv.getHddvtt_thoi_gian_dat()}</h6>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="cart__price">
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber value="${hd_dv.getHddvtt_thanh_tien()}" type="currency"/>
                                    </td>
                                    <td class="cart__close">
                                        <a href="<c:url value="/gio_hang?action=delete_dv&hd_id=${hd_dv.getHddvtt_id()}&hd_kh_id=${sessionScope.acc_khach_hang.getAcc_kh_id()}"/>">
                                            <i class="fa fa-close"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="continue__btn">
                            <a href="<c:url value="/shop"/>">Tiếp tục mua sắm</a>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="continue__btn update__btn">
                            <a href="<c:url value="/gio_hang?action&hd_kh_id=${sessionScope.acc_khach_hang.getAcc_kh_id()}"/>">
                                <i class="fa fa-spinner"></i> Cập nhật giỏ hàng
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="cart__discount">
                    <h6>MÃ GIẢM GIÁ</h6>
                    <form action="#">
                        <input type="text" placeholder="Mã giảm giá">
                        <button type="submit">GỬI</button>
                    </form>
                </div>
                <div class="cart__total">
                    <c:if test="${mess == null}">
                        <h6>TỔNG TIỀN GIỎ HÀNG</h6>
                        <ul>
                            <li>Tổng cộng
                                <span>
                                <fmt:setLocale value="vi_VN"/>
                                    <fmt:formatNumber value="${tong_tien + Integer.valueOf(tong_tien * 0.1)}"
                                                      type="currency"/>
                            </span>
                            </li>
                            <li><h5>Thành tiền
                                <span>
                                 <fmt:setLocale value="vi_VN"/>
                                <fmt:formatNumber value="${tong_tien}" type="currency"/>
                            </span></h5>
                            </li>
                        </ul>
                        <a href="<c:url value="/gio_hang?action=thanh_toan&hd_kh_id=${sessionScope.acc_khach_hang.getAcc_kh_id()}"/>"
                           class="primary-btn">THANH TOÁN
                        </a>
                    </c:if>
                    <c:if test="${mess != null}">
                        <li>
                            <h5>
                                <c:url value="${mess}"/>
                            </h5>
                        </li>
                        <a href="<c:url value="/shop"/>"
                           class="primary-btn">
                            Tiếp tục mua sắm
                        </a>
                    </c:if>

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
