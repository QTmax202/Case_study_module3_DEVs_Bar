package controller;

import DAO.GioHangDAO;
import DAO.HospitalDAO;
import model.Hddv_tam_thoi;
import model.Hdmh_tam_thoi;
import model.Pet_shop;
import model.Phu_kien;
import service.GioHang_Service;
import service.HospitalService;

import javax.servlet.RequestDispatcher;
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
    private static final HospitalService hospitalService = new HospitalService();

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
            case "add_pet_shop":
                add_pet_shop(request, response);
                break;
            case "add_phu_kien":
                add_phu_kien(request, response);
                break;
            case "add_dich_vu":
//                add_phu_kien(request, response);
                break;
            case "delete_ps_pk":
                delete_ps_pk(request, response);
                break;
            case "delete_dv":
                delete_dv(request, response);
                break;
            default:
                display_gio_hang(request, response);
        }
    }

    private void delete_dv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int hd_id = Integer.parseInt(request.getParameter("hddv_id"));
        int kh_id = Integer.parseInt(request.getParameter("hd_kh_id"));
        gioHangDAO.delete_hdmhtt_dv(hd_id);
        ArrayList<Hdmh_tam_thoi> lists_hd_ps = gioHangDAO.getLists_hdmhtt_ps(kh_id);
        request.setAttribute("lists_hd_ps", lists_hd_ps);
        ArrayList<Hdmh_tam_thoi> lists_hd_pk = gioHangDAO.getLists_hdmhtt_pk(kh_id);
        request.setAttribute("lists_hd_pk", lists_hd_pk);
        ArrayList<Hddv_tam_thoi> lists_hd_dv = gioHangDAO.getLists_hddvtt_dv(kh_id);
        request.setAttribute("lists_hd_dv", lists_hd_dv);
        request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
    }

    private void delete_ps_pk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int hd_id = Integer.parseInt(request.getParameter("hd_id"));
        int kh_id = Integer.parseInt(request.getParameter("hd_kh_id"));
        gioHangDAO.delete_hdmhtt_ps_pk(hd_id);
        ArrayList<Hdmh_tam_thoi> lists_hd_ps = gioHangDAO.getLists_hdmhtt_ps(kh_id);
        request.setAttribute("lists_hd_ps", lists_hd_ps);
        ArrayList<Hdmh_tam_thoi> lists_hd_pk = gioHangDAO.getLists_hdmhtt_pk(kh_id);
        request.setAttribute("lists_hd_pk", lists_hd_pk);
        ArrayList<Hddv_tam_thoi> lists_hd_dv = gioHangDAO.getLists_hddvtt_dv(kh_id);
        request.setAttribute("lists_hd_dv", lists_hd_dv);
        request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
    }

    private void add_phu_kien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int kh_id = Integer.parseInt(request.getParameter("hd_kh_id"));
        String pk_id = request.getParameter("hd_pk_id");
        ArrayList<Hdmh_tam_thoi> lists_hd = gioHangService.getlist_hdmhtt_pk(kh_id);
        boolean check = false;
        for (Hdmh_tam_thoi hd : lists_hd) {
            if (hd.getHdmhtt_pk_id().equals(pk_id)) {
                check = true;
                break;
            }
        }
        if (check){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shop");
            requestDispatcher.forward(request, response);
        } else {
            Phu_kien phu_kien = hospitalService.getPhu_Kien(pk_id);
            gioHangDAO.create_hdmhtt_pk(new Hdmh_tam_thoi(kh_id, pk_id, 1, phu_kien.getPk_gia()));
            ArrayList<Hdmh_tam_thoi> lists_hd_ps = gioHangDAO.getLists_hdmhtt_ps(kh_id);
            request.setAttribute("lists_hd_ps",lists_hd_ps);
            ArrayList<Hdmh_tam_thoi> lists_hd_pk = gioHangDAO.getLists_hdmhtt_pk(kh_id);
            request.setAttribute("lists_hd_pk",lists_hd_pk);
            ArrayList<Hddv_tam_thoi> lists_hd_dv = gioHangDAO.getLists_hddvtt_dv(kh_id);
            request.setAttribute("lists_hd_dv", lists_hd_dv);
            request.getRequestDispatcher("shopping-cart.jsp").forward(request,response);
        }
    }

    private void add_pet_shop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int kh_id = Integer.parseInt(request.getParameter("hd_kh_id"));
        int ps_id = Integer.parseInt(request.getParameter("hd_ps_id"));
        ArrayList<Hdmh_tam_thoi> lists_hd = gioHangService.getlist_hdmhtt_ps(kh_id);
        boolean check = false;
        for (Hdmh_tam_thoi hd : lists_hd) {
            if (hd.getHdmhtt_ps_id() == ps_id) {
                check = true;
                break;
            }
        }
        if (check) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shop");
            requestDispatcher.forward(request, response);
        } else {
            Pet_shop pet_shop = hospitalService.getPet_Shop(ps_id);
            gioHangDAO.create_hdmhtt_ps(new Hdmh_tam_thoi(kh_id, ps_id, 1, pet_shop.getPs_gia()));
            ArrayList<Hdmh_tam_thoi> lists_hd_ps = gioHangDAO.getLists_hdmhtt_ps(kh_id);
            request.setAttribute("lists_hd_ps", lists_hd_ps);
            ArrayList<Hdmh_tam_thoi> lists_hd_pk = gioHangDAO.getLists_hdmhtt_pk(kh_id);
            request.setAttribute("lists_hd_pk", lists_hd_pk);
            ArrayList<Hddv_tam_thoi> lists_hd_dv = gioHangDAO.getLists_hddvtt_dv(kh_id);
            request.setAttribute("lists_hd_dv", lists_hd_dv);
            request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
        }
    }

    private void display_gio_hang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int kh_id = Integer.parseInt(request.getParameter("hd_kh_id"));
        ArrayList<Hdmh_tam_thoi> lists_hd_ps = gioHangDAO.getLists_hdmhtt_ps(kh_id);
        ArrayList<Hdmh_tam_thoi> lists_hd_pk = gioHangDAO.getLists_hdmhtt_pk(kh_id);
        request.setAttribute("lists_hd_ps", lists_hd_ps);
        request.setAttribute("lists_hd_pk", lists_hd_pk);
        ArrayList<Hddv_tam_thoi> lists_hd_dv = gioHangDAO.getLists_hddvtt_dv(kh_id);
        request.setAttribute("lists_hd_dv", lists_hd_dv);
        request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
    }

}
