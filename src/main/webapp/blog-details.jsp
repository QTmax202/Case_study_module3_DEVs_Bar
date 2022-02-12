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

<!-- Blog Details Hero Begin -->
<section class="blog-hero spad">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col-lg-9 text-center">
                <div class="blog__hero__text">
                    <h2>HỆ THỐNG BỆNH VIỆN THÚ CƯNG DEV's BAR</h2>
                    <ul>
                        <li>By The Dev's Bar</li>
                        <li>Tháng Hai 22, 2022</li>
                        <li>8 Comments</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Blog Details Hero End -->

<!-- Blog Details Section Begin -->
<section class="blog-details spad">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col-lg-12">
                <div class="blog__details__pic">
                    <img src="img/blog/details/blog-details.jpg" alt="">
                </div>
            </div>
            <div class="col-lg-8">
                <div class="blog__details__content">
                    <div class="blog__details__share">
                        <span>share</span>
                        <ul>
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" class="twitter"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" class="youtube"><i class="fa fa-youtube-play"></i></a></li>
                            <li><a href="#" class="linkedin"><i class="fa fa-linkedin"></i></a></li>
                        </ul>
                    </div>
                    <div class="blog__details__text">
                        <p>
                            The Dev's Bar là chuỗi bệnh viện thú cưng tại Hà Nội, TP.HCM, Đà Nẵng và Hải Phòng với hệ thống nhiều chi nhánh cửa hàng thú
                            cưng chuyên cung cấp đồ dùng, quần áo, thức ăn, sữa tắm, chuồng, vòng cổ xích và các phụ kiện cho Chó cảnh , Mèo cảnh. Cùng nhiều bài viết chia sẻ
                            kinh nghiệm chăm sóc Chó cảnh , Mèo cảnh,...  cảnh hàng đầu tại Việt Nam. Địa chỉ nhận tắm spa, chăm sóc, cắt tỉa lông và
                            trông giữ thú cưng chuyên nghiệp. Với chất lượng dịch vụ tốt nhất luôn được khách hàng tin tưởng sẽ là điểm đến lý tưởng và tuyệt vời dành cho vật nuôi.
                        </p>
                    </div>
                    <div class="blog__details__quote">
                        <i class="fa fa-quote-left"></i>
                        <p>
                            “Một cựu sát thủ trả thù những kẻ đột nhập vào nhà, lấy trộm chiếc xe cổ và giết chú chó
                            con của tôi - Wick (Daisy), đó là món quà cuối cùng từ người vợ vừa qua đời Helen (Moynahan).
                            Sau khi trả thù và đang trên đường về nhà, tôi - Wick (Daisy) dừng chân tại một phòng khám thú y để điều trị vết thương và giải cứu một con chó con Pit bull.
                            Tôi - Wick (Daisy) và chú chó đi bộ về nhà dọc theo lối đi bộ bên bờ sông, nơi có cuộc hẹn hò cuối cùng với Helen (người vợ vừa qua đời).”
                        </p>
                        <h6>_ John Wick _</h6>
                    </div>
                    <div class="blog__details__comment">
                        <h4>Để lại bình luận</h4>
                        <form action="#">
                            <div class="row">
                                <div class="col-lg-4 col-md-4">
                                    <input type="text" placeholder="Name">
                                </div>
                                <div class="col-lg-4 col-md-4">
                                    <input type="text" placeholder="Email">
                                </div>
                                <div class="col-lg-4 col-md-4">
                                    <input type="text" placeholder="Phone">
                                </div>
                                <div class="col-lg-12 text-center">
                                    <textarea placeholder="Comment"></textarea>
                                    <button type="submit" class="site-btn">đăng bình luận</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Blog Details Section End -->

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
