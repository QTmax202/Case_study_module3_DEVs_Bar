package controller;

import DAO.GioHangDAO;
import DAO.HospitalDAO;
import model.Hdmh_tam_thoi;
import service.GioHang_Service;
import service.HospitalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GioHangServlet", urlPatterns = "/gio_hang")
public class GioHang_Servlet extends HttpServlet {
    private static final GioHangDAO gioHangDAO = new GioHangDAO();
    private static final GioHang_Service gioHangService = new GioHang_Service();
    private static final HospitalDAO hospitalDAO = new HospitalDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                display_gio_hang(request, response);
        }
    }

    private void display_gio_hang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int kh_id = Integer.parseInt(request.getParameter("hd_kh_id"));
        ArrayList<Hdmh_tam_thoi> lists_hd_ps = gioHangDAO.getLists_hdmhtt_ps(kh_id);
        ArrayList<Hdmh_tam_thoi> lists_hd_pk = gioHangDAO.getLists_hdmhtt_pk(kh_id);
        request.setAttribute("lists_hd_ps",lists_hd_ps);
        request.setAttribute("lists_hd_pk",lists_hd_pk);
        request.getRequestDispatcher("shopping-cart.jsp").forward(request,response);
    }

}
