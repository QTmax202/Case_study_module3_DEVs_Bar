<%--
  Created by IntelliJ IDEA.
  User: QT-247202
  Date: 07/02/2022
  Time: 4:52 CH
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

<c:url value="/hospital" var="myUrl">
    <c:if test="${pet_shop != null}">
        <c:param name="action" value="search_pet_shop"/>
    </c:if>
    <c:if test="${phu_kien != null}">
        <c:param name="action" value="search_phu_kien"/>
    </c:if>
    <c:if test="${dich_vu != null}">
        <c:param name="action" value="search_dich_vu"/>
    </c:if>
</c:url>

<jsp:include page="_Menu.jsp"></jsp:include>

<!-- Shop Details Section Begin -->
<section class="shop-details">
    <div class="product__details__pic">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="product__details__breadcrumb">
                        <c:if test="${sessionScope.acc == null}">
                            <a href="<c:url value="/hospital"/>">Home</a>
                            <a href="<c:url value="/shop"/>">Shop</a>
                            <span>Product Details</span>
                        </c:if>
                        <c:if test="${sessionScope.acc != null}">
                            <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                <a href="<c:url value="/shop"/>">Shop</a>
                                <span>Product Details</span>
                            </c:if>
                            <c:if test="${sessionScope.acc_khach_hang != null}">
                                <a href="<c:url value="/hospital"/>">Home</a>
                                <a href="<c:url value="/shop"/>">Shop</a>
                                <span>Product Details</span>
                            </c:if>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4"></div>
                <div class="col-lg-4 col-md-9">
                    <div class="tab-content">
                        <div class="tab-pane active" id="tabs-1" role="tabpanel">
                            <div class="product__details__pic__item align-content-center mx-auto d-block">
                                <c:if test="${pet_shop != null}">
                                    <img src="${pet_shop.getPs_anh()}" alt="">
                                </c:if>
                                <c:if test="${phu_kien != null}">
                                    <img src="${phu_kien.getPk_anh()}" alt="">
                                </c:if>
                                <c:if test="${dich_vu != null}">
                                    <img src="${dich_vu.getCtdv_anh()}" alt="">
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="product__details__content">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-8">
                    <div class="product__details__text">
                        <h4>
                            <c:if test="${pet_shop != null}">
                                ${pet_shop.getPs_ten()}
                            </c:if>
                            <c:if test="${phu_kien != null}">
                                ${phu_kien.getPk_ten()}
                            </c:if>
                            <c:if test="${dich_vu != null}">
                                ${dich_vu.getCtdv_ten()}
                            </c:if>
                        </h4>
                        <hr>
                        <h3>
                            <c:if test="${pet_shop != null}">
                                ${pet_shop.getPs_gia()} VNĐ
                            </c:if>
                            <c:if test="${phu_kien != null}">
                                ${phu_kien.getPk_gia()} VNĐ
                            </c:if>
                            <c:if test="${dich_vu != null}">
                                ${dich_vu.getCtdv_gia()} VNĐ
                            </c:if>
                            <span>
                                <c:if test="${pet_shop != null}">
                                    ${pet_shop.getPs_gia() + Integer.valueOf(pet_shop.getPs_gia() * 0.1)} vnđ
                                </c:if>
                                <c:if test="${phu_kien != null}">
                                    ${phu_kien.getPk_gia() + Integer.valueOf(phu_kien.getPk_gia() * 0.1)} vnđ
                                </c:if>
                                <c:if test="${dich_vu != null}">
                                    ${dich_vu.getCtdv_gia() + Integer.valueOf(dich_vu.getCtdv_gia() * 0.1)} vnđ
                                </c:if>
                            </span>
                        </h3>
                        <c:if test="${pet_shop != null}">
                            <p>
                                    ${pet_shop.getPs_mo_ta()}
                            </p>
                        </c:if>
                        <c:if test="${phu_kien != null}">
                            <p>
                                    ${phu_kien.getPk_mo_ta()}
                            </p>
                        </c:if>
                        <c:if test="${dich_vu != null}">
                            <p>
                                    ${dich_vu.getCtdv_mo_ta()}
                            </p>
                        </c:if>
                        <div class="product__details__btns__option">
                            <c:if test="${pet_shop != null }">
                                <c:if test="${pet_shop.getPs_trang_thai() != 0}">
                                    <p>
                                        Tình trạng: Còn hàng
                                    </p>
                                </c:if>
                                <c:if test="${pet_shop.getPs_trang_thai() == 0}">
                                    <p>
                                        Tình trạng: Hết hàng
                                    </p>
                                </c:if>
                            </c:if>
                            <c:if test="${phu_kien != null}">
                                <c:if test="${phu_kien.getPk_so_luong() != 0}">
                                    <p>
                                        Tình trạng: Còn hàng
                                    </p>
                                </c:if>
                                <c:if test="${phu_kien.getPk_so_luong() == 0}">
                                    <p>
                                        Tình trạng: Hết hàng
                                    </p>
                                </c:if>
                            </c:if>
                            <c:if test="${dich_vu != null}">
                                <c:if test="${dich_vu.getCtdv_trang_thai() != 0}">
                                    <p>
                                        Tình trạng: Còn hàng
                                    </p>
                                </c:if>
                                <c:if test="${dich_vu.getCtdv_trang_thai() == 0}">
                                    <p>
                                        Tình trạng: Hết hàng
                                    </p>
                                </c:if>
                            </c:if>
                        </div>
                        <div class="product__details__cart__option">
                            <c:if test="${pet_shop != null }">
                                <c:if test="${sessionScope.acc != null}">
                                    <c:if test="${sessionScope.acc_khach_hang != null}">
                                        <div class="quantity">
                                            <div class="pro-qty">
                                                <input type="text" value="1">
                                            </div>
                                        </div>
                                    </c:if>
                                </c:if>
                            </c:if>
                            <c:if test="${phu_kien != null}">
                                <c:if test="${sessionScope.acc != null}">
                                    <c:if test="${sessionScope.acc_khach_hang != null}">
                                        <div class="quantity">
                                            <div class="pro-qty">
                                                <input type="text" value="1">
                                            </div>
                                        </div>
                                    </c:if>
                                </c:if>
                            </c:if>
                            <c:if test="${dich_vu != null}">
                                <c:if test="${sessionScope.acc != null}">
                                    <c:if test="${sessionScope.acc_khach_hang != null}">
                                        <div class="quantity">
                                            <input type="date" name="ngay_dat_dv">
                                        </div>
                                    </c:if>
                                </c:if>
                            </c:if>
                            <c:if test="${pet_shop != null }">
                                <c:if test="${pet_shop.getPs_trang_thai() != 0}">
                                    <c:if test="${sessionScope.acc == null}">
                                        <a href="#" class="primary-btn">Hãy Đăng Nhập</a>
                                    </c:if>
                                    <c:if test="${sessionScope.acc != null}">
                                        <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                            <a href="#" class="primary-btn"> ADMIN </a>
                                        </c:if>
                                        <c:if test="${sessionScope.acc_khach_hang != null}">
                                            <a href="<c:url value="/gio_hang?action=add_pet_shop&hd_ps_id=${pet_shop.getPs_id()}&hd_kh_id=${sessionScope.acc_khach_hang.getAcc_kh_id()}"/>"
                                               class="primary-btn">Thêm Vào Giỏ Hàng
                                            </a>
                                        </c:if>
                                    </c:if>
                                </c:if>
                            </c:if>
                            <c:if test="${phu_kien != null}">
                                <c:if test="${phu_kien.getPk_so_luong() != 0}">
                                    <c:if test="${sessionScope.acc == null}">
                                        <a href="#" class="primary-btn">Hãy Đăng Nhập</a>
                                    </c:if>
                                    <c:if test="${sessionScope.acc != null}">
                                        <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                            <a href="#" class="primary-btn"> ADMIN </a>
                                        </c:if>
                                        <c:if test="${sessionScope.acc_khach_hang != null}">
                                            <a href="<c:url value="/gio_hang?action=add_phu_kien&hd_pk_id=${phu_kien.getPk_id()}&hd_kh_id=${sessionScope.acc_khach_hang.getAcc_kh_id()}"/>"
                                               class="primary-btn">
                                                Thêm Vào Giỏ Hàng
                                            </a>
                                        </c:if>
                                    </c:if>
                                </c:if>
                            </c:if>
                            <c:if test="${dich_vu != null}">
                                <c:if test="${dich_vu.getCtdv_trang_thai() != 0}">
                                    <c:if test="${sessionScope.acc == null}">
                                        <a href="#" class="primary-btn">Hãy Đăng Nhập</a>
                                    </c:if>
                                    <c:if test="${sessionScope.acc != null}">
                                        <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                            <a href="#" class="primary-btn"> ADMIN </a>
                                        </c:if>
                                        <c:if test="${sessionScope.acc_khach_hang != null}">
                                            <a href="#"
                                               class="primary-btn">
                                                Thêm Vào Giỏ Hàng
                                            </a>
                                        </c:if>
                                    </c:if>
                                </c:if>
                            </c:if>
                        </div>
                        <div class="product__details__btns__option">
                            <a href="#"><i class="fa fa-heart"></i> add to wishlist</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shop Details Section End -->

<!-- Related Section Begin -->
<section class="related spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h3 class="related-title">Sản Phẩm Tương Tự</h3>
            </div>
        </div>
        <div class="row">
            <c:if test="${pet_shop != null }">
                <c:forEach items="${requestScope['pet_shops']}" var="pet_shop">
                    <div class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix new-arrivals">
                        <div class="product__item">
                            <div class="product__item__pic set-bg"
                                 data-setbg="${pet_shop.getPs_anh()}">
                                <ul class="product__hover">
                                    <c:if test="${sessionScope.acc == null}">
                                        <li>
                                            <a href="#">
                                                <img src="img/icon/heart.png" alt="">
                                                <span>Heart</span></a>
                                        </li>
                                        <li>
                                            <a href="<c:url value="/hospital?action=search_pet_shop&ps_id=${pet_shop.getPs_id()}"/>">
                                                <img src="img/icon/search.png" alt="">
                                                <span>Detail</span></a>
                                        </li>
                                    </c:if>
                                    <c:if test="${sessionScope.acc != null}">
                                        <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                            <li>
                                                <a href="<c:url value="/hospital?action=search_pet_shop&ps_id=${pet_shop.getPs_id()}"/>">
                                                    <img src="img/icon/search.png" alt="">
                                                    <span>Detail</span></a>
                                            </li>
                                            <li>
                                                <a href="edit.jsp">
                                                    <img src="https://image.flaticon.com/icons/png/512/84/84380.png" width="36" height="36" alt="">
                                                    <span>Edit</span></a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <img src="https://icon-library.com/images/icon-delete/icon-delete-16.jpg" width="36" height="36" alt="">
                                                    <span>Delete</span></a>
                                            </li>
                                        </c:if>
                                        <c:if test="${sessionScope.acc_khach_hang != null}">
                                            <li>
                                                <a href="#">
                                                    <img src="img/icon/heart.png" alt="">
                                                    <span>Heart</span></a>
                                            </li>
                                            <li>
                                                <a href="<c:url value="/hospital?action=search_pet_shop&ps_id=${pet_shop.getPs_id()}"/>">
                                                    <img src="img/icon/search.png" alt="">
                                                    <span>Detail</span></a>
                                            </li>
                                        </c:if>
                                    </c:if>
                                </ul>
                            </div>
                            <div class="product__item__text">
                                <h6>${pet_shop.getPs_ten()}</h6>
                                <c:if test="${sessionScope.acc != null}">
                                    <c:if test="${sessionScope.acc_khach_hang != null}">
                                        <a href="<c:url value="/gio_hang?action=add_pet_shop&hd_ps_id=${pet_shop.getPs_id()}&hd_kh_id=${sessionScope.acc_khach_hang.getAcc_kh_id()}"/>"
                                           class="add-cart">+ Thêm Vào Giỏ Hàng</a>
                                    </c:if>
                                    <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                        <a href="<c:url value="/hospital?action=search_pet_shop&ps_id=${pet_shop.getPs_id()}"/>" class="add-cart">
                                            + ${pet_shop.getPs_ten()}
                                        </a>
                                    </c:if>
                                </c:if>
                                <c:if test="${sessionScope.acc == null}">
                                    <a href="#" class="add-cart">+ Hãy Đăng Nhập</a>
                                </c:if>
                                <hr>
                                <h5>${pet_shop.getPs_gia()} VND</h5>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${phu_kien != null}">
                <c:forEach items="${requestScope['phu_kiens']}" var="phu_kien">
                    <div class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix new-arrivals">
                        <div class="product__item">
                            <div class="product__item__pic set-bg"
                                 data-setbg="${phu_kien.getPk_anh()}">
                                <ul class="product__hover">
                                    <c:if test="${sessionScope.acc == null}">
                                        <li>
                                            <a href="#">
                                                <img src="img/icon/heart.png" alt="">
                                                <span>Heart</span></a>
                                        </li>
                                        <li>
                                            <a href="<c:url value="/hospital?action=search_phu_kien&pk_id=${phu_kien.getPk_id()}"/>">
                                                <img src="img/icon/search.png" alt="">
                                                <span>Detail</span></a>
                                        </li>
                                    </c:if>
                                    <c:if test="${sessionScope.acc != null}">
                                        <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                            <li>
                                                <a href="<c:url value="/hospital?action=search_phu_kien&pk_id=${phu_kien.getPk_id()}"/>">
                                                    <img src="img/icon/search.png" alt="">
                                                    <span>Detail</span></a>
                                            </li>
                                            <li>
                                                <a href="edit.jsp">
                                                    <img src="https://image.flaticon.com/icons/png/512/84/84380.png" width="36" height="36" alt="">
                                                    <span>Edit</span></a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <img src="https://icon-library.com/images/icon-delete/icon-delete-16.jpg" width="36" height="36" alt="">
                                                    <span>Delete</span></a>
                                            </li>
                                        </c:if>
                                        <c:if test="${sessionScope.acc_khach_hang != null}">
                                            <li>
                                                <a href="#">
                                                    <img src="img/icon/heart.png" alt="">
                                                    <span>Heart</span></a>
                                            </li>
                                            <li>
                                                <a href="<c:url value="/hospital?action=search_phu_kien&pk_id=${phu_kien.getPk_id()}"/>">
                                                    <img src="img/icon/search.png" alt="">
                                                    <span>Detail</span></a>
                                            </li>
                                        </c:if>
                                    </c:if>
                                </ul>
                            </div>
                            <div class="product__item__text">
                                <h6>${phu_kien.getPk_ten()}</h6>
                                <c:if test="${sessionScope.acc != null}">
                                    <c:if test="${sessionScope.acc_khach_hang != null}">
                                        <a href="<c:url value="/gio_hang?action=add_phu_kien&hd_pk_id=${phu_kien.getPk_id()}&hd_kh_id=${sessionScope.acc_khach_hang.getAcc_kh_id()}"/>"
                                           class="add-cart">+ Thêm Vào Giỏ Hàng</a>
                                    </c:if>
                                    <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                        <a href="<c:url value="/hospital?action=search_phu_kien&pk_id=${phu_kien.getPk_id()}"/>" class="add-cart">
                                            + ${phu_kien.getPk_ten()}
                                        </a>
                                    </c:if>
                                </c:if>
                                <c:if test="${sessionScope.acc == null}">
                                    <a href="#" class="add-cart">+ Hãy Đăng Nhập</a>
                                </c:if>
                                <hr>
                                <h5>${phu_kien.getPk_gia()} VND</h5>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${dich_vu != null}">
                <c:forEach items="${requestScope['dich_vus']}" var="dich_vu">
                    <div class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix new-arrivals">
                        <div class="product__item">
                            <div class="product__item__pic set-bg"
                                 data-setbg="${dich_vu.getCtdv_anh()}">
                                <ul class="product__hover">
                                    <c:if test="${sessionScope.acc == null}">
                                        <li>
                                            <a href="#">
                                                <img src="img/icon/heart.png" alt="">
                                                <span>Heart</span></a>
                                        </li>
                                        <li>
                                            <a href="<c:url value="/hospital?action=search_dich_vu&dv_id=${dich_vu.getCtdv_id()}"/>">
                                                <img src="img/icon/search.png" alt="">
                                                <span>Detail</span></a>
                                        </li>
                                    </c:if>
                                    <c:if test="${sessionScope.acc != null}">
                                        <c:if test="${sessionScope.acc_admin != null  || sessionScope.acc_nhan_vien != null}">
                                            <li>
                                                <a href="<c:url value="/hospital?action=search_dich_vu&dv_id=${dich_vu.getCtdv_id()}"/>">
                                                    <img src="img/icon/search.png" alt="">
                                                    <span>Detail</span></a>
                                            </li>
                                            <li>
                                                <a href="edit.jsp">
                                                    <img src="https://image.flaticon.com/icons/png/512/84/84380.png" width="36" height="36" alt="">
                                                    <span>Edit</span></a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <img src="https://icon-library.com/images/icon-delete/icon-delete-16.jpg" width="36" height="36" alt="">
                                                    <span>Delete</span></a>
                                            </li>
                                        </c:if>
                                        <c:if test="${sessionScope.acc_khach_hang != null}">
                                            <li>
                                                <a href="#">
                                                    <img src="img/icon/heart.png" alt="">
                                                    <span>Heart</span></a>
                                            </li>
                                            <li>
                                                <a href="<c:url value="/hospital?action=search_dich_vu&dv_id=${dich_vu.getCtdv_id()}"/>">
                                                    <img src="img/icon/search.png" alt="">
                                                    <span>Detail</span></a>
                                            </li>
                                        </c:if>
                                    </c:if>
                                </ul>
                            </div>
                            <div class="product__item__text">
                                <h6>${dich_vu.getCtdv_ten()}</h6>
                                <c:if test="${sessionScope.acc != null}">
                                    <c:if test="${sessionScope.acc_khach_hang != null}">
                                        <a href="<c:url value="/hospital?action=search_dich_vu&dv_id=${dich_vu.getCtdv_id()}"/>"
                                           class="add-cart">+ Đăng ký dịch vụ</a>
                                    </c:if>
                                    <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                        <a href="<c:url value="/hospital?action=search_dich_vu&dv_id=${dich_vu.getCtdv_id()}"/>" class="add-cart">
                                            + ${dich_vu.getCtdv_ten()}
                                        </a>
                                    </c:if>
                                </c:if>
                                <c:if test="${sessionScope.acc == null}">
                                    <a href="#" class="add-cart">+ Hãy Đăng Nhập</a>
                                </c:if>
                                <hr>
                                <h5>${dich_vu.getCtdv_gia()} VNĐ</h5>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</section>
<!-- Related Section End -->
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
