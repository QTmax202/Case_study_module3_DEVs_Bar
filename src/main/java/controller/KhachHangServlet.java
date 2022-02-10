package controller;

import DAO.KhachHangDAO;

import model.Khach_hang;


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

@WebServlet(name = "KhachHangServlet", urlPatterns = "/khachHang")
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
            case "creatPost":
                createPost(request, response);
                break;
            case "creatGet":
                createGet(request, response);
                break;
        }
    }
    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("info-user.jsp");
        requestDispatcher.forward(request, response);
    }
    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
        String kh_id = request.getParameter("kh_id");
        String kh_anh = request.getParameter("kh_anh");
        String kh_ten = request.getParameter("kh_ten");
        String kh_gioi_tinh = request.getParameter("kh_gioi_tinh");
        String kh_email = request.getParameter("kh_email");
        String kh_phone_number = request.getParameter("kh_phone_number");
        LocalDate kh_ngay_sinh = LocalDate.parse(request.getParameter("kh_ngay_sinh"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String kh_dia_chi = request.getParameter("kh_dia_chi");
        Khach_hang khachHang = new Khach_hang(kh_id, kh_anh, kh_ten, kh_gioi_tinh, kh_email, kh_phone_number, kh_ngay_sinh, kh_dia_chi);
        khachHangDAO.insertKhachHang(khachHang);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("info-user.jsp");
        requestDispatcher.forward(request, response);
    }
}
