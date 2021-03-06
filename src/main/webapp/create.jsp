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
<c:if test="${requestScope['createMessage'] != null}">
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <p class="text-danger">${createMessage}</p>
            </div>
        </div>
    </section>
</c:if>

<c:if test="${pet_shops != null}">
    <!-- Th??m Th?? C??ng Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">

                <form action="/quan-ly?action=them_thu_cung_post" method="post">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <h6 class="checkout__title">Th??m Th?? C??ng</h6>
                            <div class="row">
                                <div class="col-lg-3">
                                    <div class="checkout__input">
                                        <p>Ch???n Gi???ng Pet<span>*</span></p>
                                        <select name="ps_gp_id">
                                            <option value="BEAGLE" name="ps_gp_id">Ch?? Beagle</option>
                                            <option value="BRITISH" name="ps_gp_id">M??o Anh (Ng???n + D??i)</option>
                                            <option value="CORGI" name="ps_gp_id">Ch?? CORGI</option>
                                            <option value="GOLDEN" name="ps_gp_id">Ch?? Golden Retriever</option>
                                            <option value="HUSKY" name="ps_gp_id">Ch?? Husky</option>
                                            <option value="MUNCHKIN" name="ps_gp_id">M??o ch??n ng???n</option>
                                            <option value="POODLE" name="ps_gp_id">Ch?? Poodle</option>
                                            <option value="PUG" name="ps_gp_id">Ch?? Pug</option>
                                            <option value="SAMOYED" name="ps_gp_id">Ch?? Samoyed</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-9">
                                    <div class="checkout__input">
                                        <p>Nh???p T??n<span>*</span></p>
                                        <input type="text" name="ps_ten">
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input">
                                <p>Nh???p ???????ng D???n ???nh<span>*</span></p>
                                <input type="text" name="ps_anh">
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Ng??y Sinh<span>*</span></p>
                                        <input type="date" name="ps_ngay_sinh">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>????n Gi??<span>*</span></p>
                                        <input type="text" placeholder="VND" name="ps_gia">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-3">
                                    <div>
                                        <p>Tr???ng th??i<span>*</span></p>
                                        <select name="ps_trang_thai">
                                            <option value="1" name="ps_trang_thai">S???n s??ng</option>
                                            <option value="0" name="ps_trang_thai">Kh??a</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-9">
                                    <div class="checkout__input">
                                        <p>M?? T???</p>
                                        <input type="text" name="ps_mo_ta">
                                    </div>
                                </div>
                            </div>

                            <button type="submit" class="site-btn">X??C NH???N</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </section>
</c:if>


<!-- Th??m Th?? C??ng End -->

<c:if test="${phu_kien_id != null}">
    <!-- Th??m Ph??? Ki???n Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <form action="/quan-ly?action=them_phu_kien_post" method="post">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <h6 class="checkout__title">Th??m Ph??? Ki???n</h6>
                            <div class="row">
                                <div class="col-lg-2">
                                    <div>
                                        <p>Lo???i Ph??? Ki???n<span>*</span></p>
                                        <select name="pk_lpk_id">
                                            <option value="AO" name="pk_lpk_id">??o</option>
                                            <option value="BALO" name="pk_lpk_id">Balo</option>
                                            <option value="CH" name="pk_lpk_id">Chu???ng</option>
                                            <option value="DC" name="pk_lpk_id">????? ch??i</option>
                                            <option value="TP" name="pk_lpk_id">Th???c ph???m</option>
                                            <option value="VC" name="pk_lpk_id">V??ng c???</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-2">
                                    <div class="checkout__input">
                                        <p>M?? Ph??? Ki???n<span>*</span></p>
                                        <input type="text" name="pk_id">
                                    </div>
                                </div>
                                <div class="col-lg-8">
                                    <div class="checkout__input">
                                        <p>T??n Ph??? Ki???n<span>*</span></p>
                                        <input type="text" name="pk_ten">
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input">
                                <p>???????ng D???n ???nh<span>*</span></p>
                                <input type="text" name="pk_anh">
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>S??? L?????ng<span>*</span></p>
                                        <input type="text" name="pk_so_luong">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>????n Gi??<span>*</span></p>
                                        <input type="text" placeholder="VND" name="pk_gia">
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input">
                                <p>M?? T???</p>
                                <input type="text" name="pk_mo_ta">
                            </div>
                            <button type="submit" class="site-btn">X??C NH???N</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- Th??m Ph??? Ki???n End -->
</c:if>


<c:if test="${chi_tiet_dv != null}">
    <!-- Th??m D???ch V??? Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <form action="/quan-ly?action=them_dich_vu_post" method="post">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <h6 class="checkout__title">Th??m D???ch V???</h6>
                            <div class="row">
                                <div class="col-lg-2">
                                    <div>
                                        <p>Lo???i D???ch V???<span>*</span></p>
                                        <select name="ctdv_dv_id">
                                            <option value="HT" name="ctdv_dv_id">Hotel</option>
                                            <option value="SPA" name="ctdv_dv_id">Spa</option>
                                            <option value="TC" name="ctdv_dv_id">Ti??m ch???ng</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-2">
                                    <div class="checkout__input">
                                        <p>M?? D???ch V???<span>*</span></p>
                                        <input type="text" name="ctdv_id">
                                    </div>
                                </div>
                                <div class="col-lg-8">
                                    <div class="checkout__input">
                                        <p>T??n D???ch V???<span>*</span></p>
                                        <input type="text" name="ctdv_ten">
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input">
                                <p>???????ng D???n ???nh<span>*</span></p>
                                <input type="text" name="ctdv_anh">
                            </div>
                            <div class="row">
                                <div class="col-lg-3">
                                    <div>
                                        <p>Tr???ng th??i<span>*</span></p>
                                        <select name="ctdv_trang_thai">
                                            <option value="1" name="ctdv_trang_thai">S???n s??ng</option>
                                            <option value="0" name="ctdv_trang_thai">Kh??a</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-9">
                                    <div class="checkout__input">
                                        <p>????n Gi??<span>*</span></p>
                                        <input type="text" placeholder="VND" name="ctdv_gia">
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input">
                                <p>M?? T???</p>
                                <input type="text" name="ctdv_mo_ta">
                            </div>
                            <button type="submit" class="site-btn">X??C NH???N</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- Th??m D???ch V??? End -->
</c:if>


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
