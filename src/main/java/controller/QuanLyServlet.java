package controller;

import DAO.QuanLyDAO;
import DAO.ShopDAO;
import DAO.SignInDAO;
import model.Account;
import model.Chi_tiet_dv;
import model.Giong_pet;
import model.Phu_kien;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "QuanLyServlet", urlPatterns = "/quan-ly")
public class QuanLyServlet extends HttpServlet {
    private static final QuanLyDAO quanLyDAO = new QuanLyDAO();
    private static final ShopDAO shopDAO = new ShopDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logIn(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logIn(request, response);
    }

    private void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "them_dich_vu_post":
                them_dich_vu_post(request, response);
                break;
            case "them_dich_vu_get":
                them_dich_vu_get(request, response);
                break;
            case "them_phu_kien_post":
                them_phu_kien_post(request, response);
                break;
            case "them_phu_kien_get":
                them_phu_kien_get(request, response);
                break;
        }
    }

    private void them_phu_kien_get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void them_phu_kien_post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pk_id = request.getParameter("pk_id");
        String pk_ten = request.getParameter("pk_ten");
        String pk_anh = request.getParameter("pk_anh");
        int pk_gia = Integer.parseInt(request.getParameter("pk_gia"));
        int pk_so_luong = Integer.parseInt(request.getParameter("pk_so_luong"));
        String pk_mo_ta = request.getParameter("pk_mo_ta");
        String pk_lpk_id = request.getParameter("pk_lpk_id");
        Phu_kien phu_kien = new Phu_kien(pk_id, pk_ten, pk_anh, pk_gia, pk_so_luong, pk_mo_ta, pk_lpk_id);
        quanLyDAO.them_phu_kien(phu_kien);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void them_dich_vu_get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void them_dich_vu_post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ctdv_id = request.getParameter("ctdv_id");
        String ctdv_anh = request.getParameter("ctdv_anh");
        String ctdv_ten = request.getParameter("ctdv_ten");
        int ctdv_gia = Integer.parseInt(request.getParameter("ctdv_gia"));
        String ctdv_mo_ta = request.getParameter("ctdv_mo_ta");
        int ctdv_trang_thai = Integer.parseInt(request.getParameter("ctdv_trang_thai"));
        String ctdv_dv_id = request.getParameter("ctdv_dv_id");
        Chi_tiet_dv chi_tiet_dv = new Chi_tiet_dv(ctdv_id, ctdv_anh, ctdv_ten, ctdv_gia, ctdv_mo_ta, ctdv_trang_thai, ctdv_dv_id);
        quanLyDAO.them_dich_vu(chi_tiet_dv);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request, response);
    }
}
