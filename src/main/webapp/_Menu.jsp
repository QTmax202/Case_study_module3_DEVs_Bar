<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

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
                        <p>Dev's Bar</p>
                    </div>
                </div>
                <div class="col-lg-6 col-md-5">
                    <div class="header__top__right">
                        <div class="header__top__links">
                            <a href="infor-user.jsp">Xin Chào Bro</a>
                            <a href="sign-in.jsp">Đăng Nhập</a>
                            <a href="sign-in.jsp">Đăng Xuất</a>
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
                    <a href="<c:url value="/hospital?action=home"/>"><img src="img/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <nav class="header__menu mobile-menu">
                    <ul>
                        <li class="active"><a href="<c:url value="/hospital?action=home"/>">Home</a></li>
                        <li><a href="shop.jsp">Shop</a>
                            <ul class="dropdown">
                                <li><a href="./shop.jsp">Thú Cưng</a></li>
                                <li><a href="./shop.jsp">Phụ Kiện</a></li>
                                <li><a href="./shop.jsp">Dịch Vụ</a></li>
                            </ul>
                        </li>

                        <li><a href="#">Manager</a>
                            <ul class="dropdown">
                                <li><a href="./create.jsp">Thêm Thú Cưng</a></li>
                                <li><a href="./create.jsp">Thêm Phụ Kiện</a></li>
                                <li><a href="./create.jsp">Thêm Dịch Vụ</a></li>
                            </ul>
                        </li>

<%--                        <li><a href="shop-details.jsp">Shop Details</a></li>--%>
<%--                        <li><a href="shopping-cart.jsp">Shopping Cart</a></li>--%>

                        <li><a href="create.jsp">Create</a></li>
                        <li><a href="edit.jsp">Edit</a></li>
<%--                        <li><a href="blog-details.jsp">Blog Details</a></li>--%>
<%--                        <li><a href="contact.jsp">Contacts</a></li>--%>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3 col-md-3">
                <div class="header__nav__option">
                    <a href="#" class="search-switch"><img src="img/icon/search.png" alt=""></a>
                    <a href="shopping-cart.jsp"><img src="img/icon/cart.png" alt=""></a>
                </div>
            </div>
        </div>
        <div class="canvas__open"><i class="fa fa-bars"></i></div>
    </div>
</header>
<!-- Header Section End -->

