package controller;

import DAO.NhanVienDAO;

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

@WebServlet(name = "NhanVienServlet", urlPatterns = "/nhanVien")
public class NhanVienServlet extends HttpServlet {
    private static final NhanVienDAO nhanVienDAO = new NhanVienDAO();

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
            case "creatPost" :
                createPost(request, response);
                break;
            case "creatGet" :
                createGet(request, response);
                break;
            case "sua_nhan_vien_get":
                sua_nhan_vien_get(request, response);
                break;
            case "sua_nhan_vien_post":
                sua_nhan_vien_post(request, response);
                break;

        }
    }
    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("info-user.jsp");
        requestDispatcher.forward(request, response);
    }
    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
        String nv_id = request.getParameter("nv_id");
        String nv_anh = request.getParameter("nv_anh");
        String nv_ten = request.getParameter("nv_ten");
        String nv_gioi_tinh = request.getParameter("nv_gioi_tinh");
        String nv_email = request.getParameter("nv_email");
        String nv_phone_number = request.getParameter("nv_phone_number");
        LocalDate nv_ngay_sinh = LocalDate.parse(request.getParameter("nv_ngay_sinh"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String nv_dia_chi = request.getParameter("nv_dia_chi");
        String nv_ca_id = request.getParameter("nv_ca_id");
        Nhan_vien nhanVien = new Nhan_vien(nv_id, nv_anh, nv_ten, nv_gioi_tinh, nv_email, nv_phone_number, nv_ngay_sinh, nv_dia_chi, nv_ca_id);
        nhanVienDAO.insertNhanVien(nhanVien);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("info-user.jsp");
        requestDispatcher.forward(request, response);
    }
    private void sua_nhan_vien_get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("nv_id");
        Nhan_vien nhan_vien = NhanVienDAO.tim_nhan_vien(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-infor.jsp");
        request.setAttribute("nhan_vien", nhan_vien);
        dispatcher.forward(request, response);
    }
    private void sua_nhan_vien_post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String nv_id = request.getParameter("nv_id");
        String nv_anh = request.getParameter("nv_anh");
        String nv_ten = request.getParameter("nv_ten");
        String nv_gioi_tinh = request.getParameter("nv_gioi_tinh");
        String nv_email = request.getParameter("nv_email");
        String nv_phone_number = request.getParameter("nv_email");
        LocalDate nv_ngay_sinh = LocalDate.parse(request.getParameter("kh_ngay_sinh"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String nv_dia_chi = request.getParameter("nv_dia_chi");
        String nv_ca_id = request.getParameter("nv_ca_id");
        Nhan_vien nhan_vien = new Nhan_vien(nv_id, nv_anh, nv_ten, nv_gioi_tinh, nv_email, nv_phone_number, nv_ngay_sinh, nv_dia_chi,nv_ca_id);
        NhanVienDAO.tim_nhan_vien(String.valueOf(nhan_vien));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit-infor.jsp");
        requestDispatcher.forward(request, response);
    }
}
