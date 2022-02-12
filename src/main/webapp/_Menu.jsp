<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page Preloder -->
<%--<div id="preloder">--%>
<%--    <div class="loader"></div>--%>
<%--</div>--%>

<!-- Offcanvas Menu Begin -->
<div class="offcanvas-menu-wrapper">
    <div class="offcanvas__option">
        <div class="offcanvas__links">
            <a href="#">Sign in</a>
            <a href="#">FAQs</a>
        </div>
    </div>
    <div class="offcanvas__nav__option">
        <a href="#" class="search-switch"><img src="img/icon/search.png" alt=""></a>
        <%--        <a href="#"><img src="img/icon/heart.png" alt=""></a>--%>
        <a href="shopping-cart.jsp"><img src="img/icon/cart.png" alt=""></a>
    </div>
    <div id="mobile-menu-wrap"></div>
    <div class="offcanvas__text">
        <p>Dev's Bar</p>
    </div>
</div>
<!-- Offcanvas Menu End -->

<!-- Header Section Begin -->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7">
                    <div class="header__top__left">
                        <p>The Dev's Bar</p>
                    </div>
                </div>
                <div class="col-lg-6 col-md-5">
                    <div class="header__top__right">
                        <div class="header__top__links">
                            <c:if test="${sessionScope.acc != null}">
                                <c:if test="${sessionScope.acc_admin != null}">
                                    <a href="#">Xin Chào ${sessionScope.acc_admin.getAcc_username()}</a>
                                </c:if>
                                <c:if test="${sessionScope.acc_nhan_vien != null}">
                                    <a href="/khach-hang?action=sua_nhan_vien_get&nv_id=${sessionScope.acc_nhan_vien.acc_nv_id}">Xin Chào NV ${sessionScope.acc_nhan_vien.getAcc_username()}</a>
                                </c:if>
                                <c:if test="${sessionScope.acc_khach_hang != null}">
                                    <a href="/khach-hang?action=sua_khach_hang_get&kh_id=${sessionScope.acc_khach_hang.acc_kh_id}">Xin Chào KH ${sessionScope.acc_khach_hang.getAcc_username()}</a>
                                </c:if>
                                <a href="<c:url value="/sign-in?action=logOut"/>">Đăng Xuất</a>
                            </c:if>
                            <c:if test="${sessionScope.acc == null}">
                                <a href="sign-in.jsp">Đăng Nhập</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <div class="header__logo">
                    <c:if test="${sessionScope.acc_khach_hang != null || sessionScope.acc == null}">
                        <a href="<c:url value="/hospital"/>"><img src="img/logo3.png" alt=""></a>
                    </c:if>
                    <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                        <a href="<c:url value="/shop"/>"><img src="img/logo3.png" alt=""></a>
                    </c:if>
                </div>
            </div>
            <div class="col-lg-8 col-md-6">
                <nav class="header__menu mobile-menu">
                    <ul>
                        <c:if test="${sessionScope.acc == null}">
                            <li class="active"><a href="<c:url value="/hospital?action=home"/>">Trang Chủ</a></li>
                            <li><a href="<c:url value="/shop"/>">Cửa Hàng</a>
                                <ul class="dropdown">
                                    <li><a href="<c:url value="/shop?action=list-thu-cung"/>">Thú Cưng</a></li>
                                    <li><a href="<c:url value="/shop?action=list-phu-kien"/>">Phụ Kiện</a></li>
                                    <li><a href="<c:url value="/shop?action=list-dich-vu"/>">Dịch Vụ</a></li>
                                </ul>
                            </li>
                            <li><a href="blog-details.jsp">Blog</a></li>
                            <li><a href="contact.jsp">Liên Lạc</a></li>
                        </c:if>
                        <c:if test="${sessionScope.acc != null}">
                            <c:if test="${sessionScope.acc_khach_hang != null}">
                                <li class="active"><a href="<c:url value="/hospital?action=home"/>">Trang Chủ</a></li>
                            </c:if>
                            <li><a href="<c:url value="/shop"/>">Cửa Hàng</a>
                                <ul class="dropdown">
                                    <li><a href="<c:url value="/shop?action=list-thu-cung"/>">Thú Cưng</a></li>
                                    <li><a href="<c:url value="/shop?action=list-phu-kien"/>">Phụ Kiện</a></li>
                                    <li><a href="<c:url value="/shop?action=list-dich-vu"/>">Dịch Vụ</a></li>
                                </ul>
                            </li>
                            <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                <li>
                                    <a href="#">Quản Lý Sản Phẩm</a>
                                    <ul class="dropdown">
                                        <li><a href="/quan-ly?action=them_thu_cung_get">Thêm Thú Cưng</a></li>
                                        <li><a href="/quan-ly?action=them_phu_kien_get">Thêm Phụ Kiện</a></li>
                                        <li><a href="/quan-ly?action=them_dich_vu_get">Thêm Dịch Vụ</a></li>
                                    </ul>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc_admin != null || sessionScope.acc_nhan_vien != null}">
                                <li>
                                    <a href="#">Quản Lý Hóa Đơn</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc_admin != null }">
                                <li>
                                    <a href="/khach-hang?action=them_nhan_vien_get">Quản Lý Tài Khoản</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc_khach_hang != null}">
                                <li><a href="blog-details.jsp">Blog</a></li>
                                <li><a href="contact.jsp">Liên Lạc</a></li>
                            </c:if>
                        </c:if>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-1 col-md-3">
                <div class="header__nav__option">
                    <a href="#" class="search-switch">
                        <img src="img/icon/search.png" alt="">
                    </a>
                    <c:if test="${sessionScope.acc_khach_hang != null}">
                        <a href="shopping-cart.jsp">
                            <img src="img/icon/cart.png" alt="">
                        </a>
                    </c:if>

                </div>
            </div>
        </div>
        <div class="canvas__open"><i class="fa fa-bars"></i></div>
    </div>
</header>
<!-- Header Section End -->