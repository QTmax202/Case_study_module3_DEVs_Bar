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

            <form action="/quan-ly?action=them_thu_cung_post" method="post">
                <div class="row">
                    <div class="col-lg-8 col-md-6">
                        <h6 class="checkout__title">Thêm Thú Cưng</h6>
                        <div class="row">
                            <div class="col-lg-3">
                                <div class="checkout__input">
                                    <p>Chọn Giống Pet<span>*</span></p>
                                        <select name="ps_gp_id">
                                            <option value="BEAGLE" name="ps_gp_id">Chó Beagle</option>
                                            <option value="BRITISH" name="ps_gp_id">Mèo Anh (Ngắn + Dài)</option>
                                            <option value="CORGI" name="ps_gp_id">Chó CORGI</option>
                                            <option value="GOLDEN" name="ps_gp_id">Chó Golden Retriever</option>
                                            <option value="HUSKY" name="ps_gp_id">Chó Husky</option>
                                            <option value="MUNCHKIN" name="ps_gp_id">Mèo chân ngắn</option>
                                            <option value="POODLE" name="ps_gp_id">Chó Poodle</option>
                                            <option value="PUG" name="ps_gp_id">Chó Pug</option>
                                            <option value="SAMOYED" name="ps_gp_id">Chó Samoyed</option>
                                        </select>
                                </div>
                            </div>
                            <div class="col-lg-9">
                                <div class="checkout__input">
                                    <p>Nhập Tên<span>*</span></p>
                                    <input type="text" name="ps_ten">
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Nhập Đường Dẫn Ảnh<span>*</span></p>
                            <input type="text" name="ps_anh">
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Ngày Sinh<span>*</span></p>
                                    <input type="date"  name="ps_ngay_sinh">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Đơn Giá<span>*</span></p>
                                    <input type="text" placeholder="VND" name="ps_gia">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div>
                                    <p>Trạng thái<span>*</span></p>
                                    <select name="ps_trang_thai">
                                        <option value="1" name="ps_trang_thai">Sẵn sàng</option>
                                        <option value="0" name="ps_trang_thai">Khóa</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Mô Tả</p>
                                    <input type="text" name="ps_mo_ta">
                                </div>
                            </div>
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
            <form action="/quan-ly?action=them_phu_kien_post" method="post">
                <div class="row">
                    <div class="col-lg-8 col-md-6">
                        <h6 class="checkout__title">Thêm Phụ Kiện</h6>
                        <div class="row">
                            <div class="col-lg-2">
                                <div>
                                    <p>Loại Phụ Kiện<span>*</span></p>
                                    <select name="pk_lpk_id">
                                            <option value="AO" name="pk_lpk_id">Áo</option>
                                            <option value="BALO" name="pk_lpk_id">Balo</option>
                                            <option value="CH" name="pk_lpk_id">Chuồng</option>
                                            <option value="DC" name="pk_lpk_id">Đồ chơi</option>
                                            <option value="TP" name="pk_lpk_id">Thực phẩm</option>
                                            <option value="VC" name="pk_lpk_id">Vòng cổ</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <div class="checkout__input">
                                    <p>Mã Phụ Kiện<span>*</span></p>
                                    <input type="text" name="pk_id">
                                </div>
                            </div>
                            <div class="col-lg-8">
                                <div class="checkout__input">
                                    <p>Tên Phụ Kiện<span>*</span></p>
                                    <input type="text" name="pk_ten">
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Đường Dẫn Ảnh<span>*</span></p>
                            <input type="text" name="pk_anh">
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Số Lượng<span>*</span></p>
                                    <input type="text" name="pk_so_luong">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Đơn Giá<span>*</span></p>
                                    <input type="text" placeholder="VND" name="pk_gia">
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Mô Tả</p>
                            <input type="text" name="pk_mo_ta">
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
            <form action="/quan-ly?action=them_dich_vu_post" method="post">
                <div class="row">
                    <div class="col-lg-8 col-md-6">
                        <h6 class="checkout__title">Thêm Dịch Vụ</h6>
                        <div class="row">
                            <div class="col-lg-2">
                                <div>
                                    <p>Loại Dịch Vụ<span>*</span></p>
                                    <select name="ctdv_dv_id">
                                        <option value="HT" name="ctdv_dv_id">Hotel</option>
                                        <option value="SPA" name="ctdv_dv_id">Spa</option>
                                        <option value="TC" name="ctdv_dv_id">Tiêm chủng</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <div class="checkout__input">
                                    <p>Mã Dịch Vụ<span>*</span></p>
                                    <input type="text" name="ctdv_id">
                                </div>
                            </div>
                            <div class="col-lg-8">
                                <div class="checkout__input">
                                    <p>Tên Dịch Vụ<span>*</span></p>
                                    <input type="text" name="ctdv_ten">
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Đường Dẫn Ảnh<span>*</span></p>
                            <input type="text" name="ctdv_anh">
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <div>
                                    <p>Trạng thái<span>*</span></p>
                                    <select name="ctdv_trang_thai">
                                        <option value="1" name="ctdv_trang_thai">Sẵn sàng</option>
                                        <option value="0" name="ctdv_trang_thai">Khóa</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Đơn Giá<span>*</span></p>
                                    <input type="text" placeholder="VND" name="ctdv_gia">
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Mô Tả</p>
                            <input type="text" name="ctdv_mo_ta">
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
