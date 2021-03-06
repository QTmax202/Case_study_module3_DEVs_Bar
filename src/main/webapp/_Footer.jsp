<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Footer Section Begin -->
<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-5 col-md-6 col-sm-6">
                <div class="footer__widget">
                    <h6>Liên lạc</h6>
                    <ul>
                        <li><a href="#">Địa chỉ: Số 23, Lô TT01, KĐT Mon City, Mỹ Đình 2, Nam Từ Liêm, Hà Nội.</a></li>
                        <li><a href="#">Hotline: 02462538829</a></li>
                        <li><a href="#">Email: info@codegym.vn</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-3 offset-lg-1 col-md-3 col-sm-6">
                <div class="footer__widget">
                    <h6>Shopping</h6>
                    <ul>
                        <li><a href="<c:url value="/shop?action=list-thu-cung"/>">Thú Cưng</a></li>
                        <li><a href="<c:url value="/shop?action=list-phu-kien"/>">Phụ Kiện</a></li>
                        <li><a href="<c:url value="/shop?action=list-dich-vu"/>">Dịch Vụ</a></li>
                        <li><a href="blog-details.jsp">Giới Thiệu</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="footer__about">
                    <div class="footer__logo">
                        <a href="#"><img src="img/footer-logo1.png" alt=""></a>
                    </div>
                    <p>Khách hàng là trọng tâm của mô hình kinh doanh độc đáo của chúng tôi.</p>
                    <a href="#"><img src="img/payment.png" alt=""></a>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- Footer Section End -->


<!-- Search Begin -->
<div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch">+</div>
        <form class="search-model-form" action="/shop?action=tim-kiem" method="post">
            <label>
                <input type="text" id="search-input" placeholder="Search here....." name="tim-kiem">
            </label>
        </form>
    </div>
</div>
<!-- Search End -->


