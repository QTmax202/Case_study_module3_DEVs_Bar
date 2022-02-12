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
                    <h4>Shop</h4>
                    <div class="breadcrumb__links">
                        <c:if test="${sessionScope.acc == null}">
                            <a href="<c:url value="/hospital?action=home"/>">Home</a>
                            <span><a href="<c:url value="/shop"/>">Shop</a></span>
                        </c:if>
                        <c:if test="${sessionScope.acc != null}">
                            <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                <span><a href="<c:url value="/shop"/>">Shop</a></span>
                            </c:if>
                            <c:if test="${sessionScope.acc_khach_hang != null}">
                                <a href="<c:url value="/hospital?action=home"/>">Home</a>
                                <span><a href="<c:url value="/shop"/>">Shop</a></span>
                            </c:if>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Shop Section Begin -->
<section class="shop spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="shop__sidebar">
                    <div class="shop__sidebar__search">
                        <form action="<c:url value="/shop?action=tim-kiem"/>" method="post">
                            <input value="${tim}" type="text" placeholder="Search..." name="tim-kiem">
                            <button type="submit"><span class="icon_search"></span></button>
                        </form>
                    </div>
                    <div class="shop__sidebar__accordion">
                        <div class="accordion" id="accordionExample">
                            <div class="card">
                                <div class="card-heading">
                                    <a data-toggle="collapse" data-target="#collapseOne">Thú Cưng</a>
                                </div>
                                <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                                    <div class="card-body">
                                        <div class="shop__sidebar__categories">
                                            <ul class="nice-scroll">
                                                <li class="fa fa-star-o"><a href="/shop?action=list-thu-cung"> TẤT
                                                    CẢ</a></li>
                                                <c:forEach items="${giong_pets}" var="giong_pet">
                                                    <li class="${ghim == giong_pet.gp_id ? "active":""}">
                                                        <a href="/shop?action=thucung&id=${giong_pet.gp_id}">${giong_pet.gp_id}</a>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-heading">
                                    <a data-toggle="collapse" data-target="#collapseTwo">Phụ Kiện</a>
                                </div>
                                <div id="collapseTwo" class="collapse show" data-parent="#accordionExample">
                                    <div class="card-body">
                                        <div class="shop__sidebar__categories">
                                            <ul class="nice-scroll">
                                                <li class="fa fa-star-o"><a href="/shop?action=list-phu-kien"> TẤT
                                                    CẢ</a></li>
                                                <c:forEach items="${phu_kiens}" var="phu_kien">
                                                    <li>
                                                        <a href="/shop?action=phukien&id=${phu_kien.pk_mo_ta}">${phu_kien.pk_lpk_id}</a>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-heading">
                                    <a data-toggle="collapse" data-target="#collapseThree">Dịch Vụ</a>
                                </div>
                                <div id="collapseThree" class="collapse show" data-parent="#accordionExample">
                                    <div class="card-body">
                                        <div class="shop__sidebar__categories">
                                            <ul class="nice-scroll">
                                                <li class="fa fa-star-o"><a href="/shop?action=list-dich-vu"> TẤT CẢ</a>
                                                </li>
                                                <c:forEach items="${chi_tiet_dvs}" var="chi_tiet_dv">
                                                    <li>
                                                        <a href="/shop?action=dichvu&id=${chi_tiet_dv.ctdv_mo_ta}">${chi_tiet_dv.ctdv_dv_id}</a>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="shop__product__option">
                    <div class="row">
                        <div class="col-lg-6    col-md-6 col-sm-6"></div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <%--                            <div class="shop__product__option__right">--%>
                            <%--                                <p>Sắp xếp theo giá:</p>--%>
                            <%--                                <select>--%>
                            <%--                                    <option><a href="shop?action=sap-xep-tang">Sắp xếp tăng dần</a></option>--%>
                            <%--                                    <option><a href="shop?action=sap-xep-giam">Sắp xếp giảm dần</a></option>--%>
                            <%--                                </select>--%>
                            <%--                            </div>--%>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <c:forEach items="${pet_shops}" var="pet_shop">
                        <div class="col-lg-4 col-md-6 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg"
                                     data-setbg="${pet_shop.ps_anh}">
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
                                                    <a href="/quan-ly?action=sua_thu_cung_get&tc_id=${pet_shop.getPs_id()}">
                                                        <img src="https://image.flaticon.com/icons/png/512/84/84380.png"
                                                             width="36" height="36" alt="">
                                                        <span>Edit</span></a>
                                                </li>
                                                <li>
                                                    <a href="/quan-ly?action=xoa_thu_cung&tc_id=${pet_shop.getPs_id()}">
                                                        <img src="https://icon-library.com/images/icon-delete/icon-delete-16.jpg"
                                                             width="36" height="36" alt="">
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
                                    <c:if test="${pet_shop.getPs_trang_thai() != 0}">
                                        <h6>${pet_shop.ps_ten}</h6>
                                        <c:if test="${sessionScope.acc != null}">
                                            <c:if test="${sessionScope.acc_khach_hang != null}">
                                                <a href="<c:url value="/hospital?action=addToCart&id=${pet_shop.getPs_id()}"/>"
                                                   class="add-cart">+ Thêm Vào Giỏ Hàng</a>
                                            </c:if>
                                            <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                                <a href="<c:url value="/hospital?action=search_pet_shop&ps_id=${pet_shop.getPs_id()}"/>"
                                                   class="add-cart">
                                                    + ${pet_shop.getPs_ten()}
                                                </a>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${sessionScope.acc == null}">
                                            <a href="#" class="add-cart">+ Hãy Đăng Nhập</a>
                                        </c:if>
                                        <hr>
                                        <h5>
                                                <fmt:setLocale value = "vi_VN"/>
                                                <fmt:formatNumber value = "${pet_shop.ps_gia}" type = "currency"/>
                                        </h5>
<%--                                        <h5>${pet_shop.ps_gia} VND</h5>--%>
                                    </c:if>
                                    <c:if test="${pet_shop.getPs_trang_thai() == 0}">
                                        <h6>${pet_shop.ps_ten}</h6>
                                        <a class="add-cart">Hết hàng</a>
                                        <hr>
                                        <h5>${pet_shop.ps_gia} VND</h5>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <%--                    Phụ kiện--%>
                    <c:forEach items="${phu_kien_id}" var="phu_kien_id">
                        <div class="col-lg-4 col-md-6 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg"
                                     data-setbg="${phu_kien_id.pk_anh}">
                                    <ul class="product__hover">
                                        <c:if test="${sessionScope.acc == null}">
                                            <li>
                                                <a href="#">
                                                    <img src="img/icon/heart.png" alt="">
                                                    <span>Heart</span></a>
                                            </li>
                                            <li>
                                                <a href="<c:url value="/hospital?action=search_phu_kien&pk_id=${phu_kien_id.getPk_id()}"/>">
                                                    <img src="img/icon/search.png" alt="">
                                                    <span>Detail</span></a>
                                            </li>
                                        </c:if>
                                        <c:if test="${sessionScope.acc != null}">
                                            <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                                <li>
                                                    <a href="<c:url value="/hospital?action=search_phu_kien&pk_id=${phu_kien_id.getPk_id()}"/>">
                                                        <img src="img/icon/search.png" alt="">
                                                        <span>Detail</span></a>
                                                </li>
                                                <li>
                                                    <a href="/quan-ly?action=sua_phu_kien_get&pk_id=${phu_kien_id.getPk_id()}">
                                                        <img src="https://image.flaticon.com/icons/png/512/84/84380.png"
                                                             width="36" height="36" alt="">
                                                        <span>Edit</span></a>
                                                </li>
                                                <li>
                                                    <a href="/quan-ly?action=xoa_phu_kien&pk_id=${phu_kien_id.getPk_id()}">
                                                        <img src="https://icon-library.com/images/icon-delete/icon-delete-16.jpg"
                                                             width="36" height="36" alt="">
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
                                                    <a href="<c:url value="/hospital?action=search_phu_kien&pk_id=${phu_kien_id.getPk_id()}"/>">
                                                        <img src="img/icon/search.png" alt="">
                                                        <span>Detail</span></a>
                                                </li>
                                            </c:if>
                                        </c:if>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <c:if test="${phu_kien_id.getPk_so_luong() != 0}">
                                        <h6>${phu_kien_id.pk_ten}</h6>
                                        <c:if test="${sessionScope.acc != null}">
                                            <c:if test="${sessionScope.acc_khach_hang != null}">
                                                <a href="<c:url value="/hospital?action=addToCart&id=${phu_kien_id.getPk_id()}"/>"
                                                   class="add-cart">+ Thêm Vào Giỏ Hàng</a>
                                            </c:if>
                                            <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                                <a href="<c:url value="/hospital?action=search_phu_kien&pk_id=${phu_kien_id.getPk_id()}"/>"
                                                   class="add-cart">
                                                    + ${phu_kien_id.getPk_ten()}
                                                </a>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${sessionScope.acc == null}">
                                            <a href="#" class="add-cart">+ Hãy Đăng Nhập</a>
                                        </c:if>
                                        <hr>
                                        <h5>${phu_kien_id.pk_gia} VND</h5>
                                    </c:if>
                                    <c:if test="${phu_kien_id.getPk_so_luong() == 0}">
                                        <h6>${phu_kien_id.pk_ten}</h6>
                                        <a class="add-cart">Hết hàng</a>
                                        <hr>
                                        <h5>${phu_kien_id.pk_gia} VND</h5>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <%--                    Dịch vụ--%>
                    <c:forEach items="${chi_tiet_dv}" var="chi_tiet_dv">
                        <div class="col-lg-4 col-md-6 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg"
                                     data-setbg="${chi_tiet_dv.ctdv_anh}">
                                    <ul class="product__hover">
                                        <c:if test="${sessionScope.acc == null}">
                                            <li>
                                                <a href="#">
                                                    <img src="img/icon/heart.png" alt="">
                                                    <span>Heart</span></a>
                                            </li>
                                            <li>
                                                <a href="<c:url value="/hospital?action=search_dich_vu&dv_id=${chi_tiet_dv.getCtdv_id()}"/>">
                                                    <img src="img/icon/search.png" alt="">
                                                    <span>Detail</span></a>
                                            </li>
                                        </c:if>
                                        <c:if test="${sessionScope.acc != null}">
                                            <c:if test="${sessionScope.acc_admin != null  || sessionScope.acc_nhan_vien != null}">
                                                <li>
                                                    <a href="<c:url value="/hospital?action=search_dich_vu&dv_id=${chi_tiet_dv.getCtdv_id()}"/>">
                                                        <img src="img/icon/search.png" alt="">
                                                        <span>Detail</span></a>
                                                </li>
                                                <li>
                                                    <a href="/quan-ly?action=sua_dich_vu_get&dv_id=${chi_tiet_dv.getCtdv_id()}">
                                                        <img src="https://image.flaticon.com/icons/png/512/84/84380.png"
                                                             width="36" height="36" alt="">
                                                        <span>Edit</span></a>
                                                </li>
                                                <li>
                                                    <a href="/quan-ly?action=xoa_dich_vu&dv_id=${chi_tiet_dv.getCtdv_id()}">
                                                        <img src="https://icon-library.com/images/icon-delete/icon-delete-16.jpg"
                                                             width="36" height="36" alt="">
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
                                                    <a href="<c:url value="/hospital?action=search_dich_vu&dv_id=${chi_tiet_dv.getCtdv_id()}"/>">
                                                        <img src="img/icon/search.png" alt="">
                                                        <span>Detail</span></a>
                                                </li>
                                            </c:if>
                                        </c:if>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <c:if test="${chi_tiet_dv.getCtdv_trang_thai() != 0}">
                                        <h6>${chi_tiet_dv.ctdv_ten}</h6>
                                        <c:if test="${sessionScope.acc != null}">
                                            <c:if test="${sessionScope.acc_khach_hang != null}">
                                                <a href="<c:url value="/hospital?action=addToCart&id=${chi_tiet_dv.getCtdv_id()}"/>"
                                                   class="add-cart">+ Thêm Vào Giỏ Hàng</a>
                                            </c:if>
                                            <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                                <a href="<c:url value="/hospital?action=search_dich_vu&dv_id=${chi_tiet_dv.getCtdv_id()}"/>"
                                                   class="add-cart">
                                                    + ${chi_tiet_dv.getCtdv_ten()}
                                                </a>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${sessionScope.acc == null}">
                                            <a href="#" class="add-cart">+ Hãy Đăng Nhập</a>
                                        </c:if>
                                        <hr>
                                        <h5>${chi_tiet_dv.ctdv_gia} VND</h5>
                                    </c:if>
                                    <c:if test="${chi_tiet_dv.getCtdv_trang_thai() == 0}">
                                        <h6>${chi_tiet_dv.ctdv_ten}</h6>
                                        <a class="add-cart">Hết hàng</a>
                                        <hr>
                                        <h5>${chi_tiet_dv.ctdv_gia} VND</h5>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shop Section End -->

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
