package controller;

import DAO.KhachHangDAO;

import model.Account;
import model.Khach_hang;
import model.Nhan_vien;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name = "KhachHangServlet", urlPatterns = "/khach-hang")
public class KhachHangServlet extends HttpServlet {
    private static final KhachHangDAO khachHangDAO = new KhachHangDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            action(request, response);
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            action(request, response);
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "them_acc_khach_hang":
                them_acc_khach_hang(request, response);
                break;
            case "them_khach_hang_post":
                them_khach_hang_post(request, response);
                break;
            case "them_khach_hang_get":
                them_khach_hang_get(request, response);
                break;
            case "them_nhan_vien_post":
                them_nhan_vien_post(request, response);
                break;
            case "them_nhan_vien_get":
                them_nhan_vien_get(request, response);
                break;
            case "them_acc_nhan_vien":
                them_acc_nhan_vien(request, response);
                break;
        }
    }

    private void them_khach_hang_get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mess", new Khach_hang());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("sign-up.jsp");
        requestDispatcher.forward(request, response);
    }

    private void them_khach_hang_post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
        String kh_ten = request.getParameter("kh_ten");
        String kh_gioi_tinh = request.getParameter("kh_gioi_tinh");
        String kh_phone_number = request.getParameter("kh_phone_number");
        String kh_dia_chi = request.getParameter("kh_dia_chi");
        Khach_hang khach_hang = new Khach_hang(kh_ten, kh_gioi_tinh, kh_phone_number, kh_dia_chi);
        khachHangDAO.them_khach_hang(khach_hang);
        Khach_hang khach_hang_gui = khachHangDAO.tim_khach_hang();
        request.setAttribute("khach_hang", khach_hang_gui);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("sign-up.jsp");
        requestDispatcher.forward(request, response);
    }

    private void them_nhan_vien_get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mess", new Nhan_vien());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("infor-user.jsp");
        requestDispatcher.forward(request, response);
    }

    private void them_nhan_vien_post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
        String nv_id = request.getParameter("nv_id");
        String nv_ten = request.getParameter("nv_ten");
        String nv_gioi_tinh = request.getParameter("nv_gioi_tinh");
        String nv_email = request.getParameter("nv_email");
        String nv_phone_number = request.getParameter("nv_phone_number");
        LocalDate nv_ngay_sinh = LocalDate.parse(request.getParameter("nv_ngay_sinh"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String nv_dia_chi = request.getParameter("nv_dia_chi");
        String nv_ca_id = request.getParameter("nv_ca_id");
        Nhan_vien nhan_vien = new Nhan_vien(nv_id, nv_ten, nv_gioi_tinh, nv_email, nv_phone_number, nv_ngay_sinh, nv_dia_chi, nv_ca_id);
        khachHangDAO.them_nhan_vien(nhan_vien);
        request.setAttribute("nhan_vien", nhan_vien);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("infor-user.jsp");
        requestDispatcher.forward(request, response);
    }

    private void them_acc_khach_hang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String acc_username = request.getParameter("acc_username");
        String acc_password = request.getParameter("acc_password");
        String acc_password2 = request.getParameter("acc_password2");
        String acc_phan_cap = request.getParameter("acc_phan_cap");
        int acc_kh_id = Integer.parseInt(request.getParameter("acc_kh_id"));
        if (!acc_password.equals(acc_password2)) {
            request.setAttribute("message","Mật khẩu không trùng. Vui lòng nhập lại");
            request.getRequestDispatcher("/khach-hang?action=them_khach_hang_post").forward(request, response);
        } else {
            Account a = khachHangDAO.kiem_tra_acc_khach_hang(acc_username);
            if (a == null) {
                Account account = new Account(acc_username, acc_password, acc_phan_cap, acc_kh_id);
                khachHangDAO.them_acc_khach_hang(account);
                request.setAttribute("message","Đăng kí thành công. Vui lòng nhập");
                request.getRequestDispatcher("/sign-in.jsp").forward(request, response);
            } else {
                request.setAttribute("message","Đã có tài khoản này. Vui lòng nhập lại");
                request.getRequestDispatcher("/khach-hang?action=them_khach_hang_post").forward(request, response);
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("sign-up.jsp");
        requestDispatcher.forward(request, response);
    }

    private void them_acc_nhan_vien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String acc_username = request.getParameter("acc_username");
        String acc_password = request.getParameter("acc_password");
        String acc_password2 = request.getParameter("acc_password2");
        String acc_phan_cap = request.getParameter("acc_phan_cap");
        String acc_nv_id = request.getParameter("acc_nv_id");
        if (!acc_password.equals(acc_password2)) {
            request.setAttribute("vienNhan","Mật khẩu không trùng. Vui lòng nhập lại");
            request.getRequestDispatcher("/khach-hang?action=them_nhan_vien_post").forward(request, response);
        } else {
            Account a = khachHangDAO.kiem_tra_acc_nhan_vien(acc_username);
            if (a == null) {
                Account account = new Account(acc_username, acc_password, acc_phan_cap, acc_nv_id);
                khachHangDAO.them_acc_nhan_vien(account);
                request.setAttribute("vienNhan","Đăng kí thành công. Vui lòng nhập");
                request.getRequestDispatcher("/infor-user.jsp").forward(request, response);
            } else {
                request.setAttribute("vienNhan","Đã có tài khoản này. Vui lòng nhập lại");
                request.getRequestDispatcher("/khach-hang?action=them_nhan_vien_post").forward(request, response);
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("infor-user.jsp");
        requestDispatcher.forward(request, response);
    }
}
