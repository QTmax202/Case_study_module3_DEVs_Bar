package controller;

import DAO.GioHangDAO;
import DAO.HospitalDAO;
import model.*;
import service.GioHang_Service;
import service.HospitalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                add_dich_vu(request, response);
                break;
            case "delete_ps_pk":
                delete_ps_pk(request, response);
                break;
            case "delete_dv":
                delete_dv(request, response);
                break;
            case "thanh_toan":
                thanh_toan(request, response);
                break;
            default:
                display_gio_hang(request, response);
        }
    }

    private void thanh_toan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int kh_id = Integer.parseInt(request.getParameter("hd_kh_id"));
        int ca_nv = LocalDateTime.now().getHour();
        Nhan_vien nhan_vien = gioHangDAO.get_nhan_vien(ca_nv);
        gioHangDAO.create_hd(nhan_vien.getNv_id(), kh_id);
        int hd_id = gioHangDAO.get_hoa_don_kh_id_limit1(kh_id).getHd_id();
        ArrayList<Hdmh_tam_thoi> lists_hd_ps = gioHangDAO.getLists_hdmhtt_ps(kh_id);
        ArrayList<Hdmh_tam_thoi> lists_hd_pk = gioHangDAO.getLists_hdmhtt_pk(kh_id);
        ArrayList<Hddv_tam_thoi> lists_hd_dv = gioHangDAO.getLists_hddvtt_dv(kh_id);
        for (Hdmh_tam_thoi hd_ps : lists_hd_ps) {
            gioHangDAO.create_hdmh_ps(new Hoa_don_mua_hang(hd_id, hd_ps.getHdmhtt_ps_id(), hd_ps.getHdmhtt_so_luong(), hd_ps.getHdmhtt_thanh_tien()));
            gioHangDAO.update_pet_shop(hd_ps.getHdmhtt_ps_id());
        }
        for (Hdmh_tam_thoi hd_pk : lists_hd_pk) {
            gioHangDAO.create_hdmh_pk(new Hoa_don_mua_hang(hd_id, hd_pk.getHdmhtt_pk_id(), hd_pk.getHdmhtt_so_luong(), hd_pk.getHdmhtt_thanh_tien()));
            gioHangDAO.update_phu_kien(hd_pk.getHdmhtt_pk_id());
        }
        gioHangDAO.delete_hdmhtt(kh_id);
        for (Hddv_tam_thoi hd_dv : lists_hd_dv) {
            gioHangDAO.create_hddv(new Hoa_don_dich_vu(hd_id, hd_dv.getHddvtt_ctdv_id(), hd_dv.getHddvtt_ngay_dat(), hd_dv.getHddvtt_thanh_tien()));
        }
        gioHangDAO.delete_hddvtt(kh_id);
        lists_hd_ps = gioHangDAO.getLists_hdmhtt_ps(kh_id);
        request.setAttribute("lists_hd_ps", lists_hd_ps);
        lists_hd_pk = gioHangDAO.getLists_hdmhtt_pk(kh_id);
        request.setAttribute("lists_hd_pk", lists_hd_pk);
        lists_hd_dv = gioHangDAO.getLists_hddvtt_dv(kh_id);
        request.setAttribute("lists_hd_dv", lists_hd_dv);
        ArrayList<Hdmh_tam_thoi> lists_hdmhtt = gioHangDAO.getAll_hdmhtt(kh_id);
        int thanh_tien = 0;
        for (Hdmh_tam_thoi hd : lists_hdmhtt) {
            thanh_tien += hd.getHdmhtt_thanh_tien();
        }
        for (Hddv_tam_thoi hd : lists_hd_dv) {
            thanh_tien += hd.getHddvtt_thanh_tien();
        }
        request.setAttribute("tong_tien", thanh_tien);
        request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
    }

    private void delete_dv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int hd_id = Integer.parseInt(request.getParameter("hd_id"));
        int kh_id = Integer.parseInt(request.getParameter("hd_kh_id"));
        gioHangDAO.delete_hdmhtt_dv(hd_id);
        ArrayList<Hdmh_tam_thoi> lists_hd_ps = gioHangDAO.getLists_hdmhtt_ps(kh_id);
        request.setAttribute("lists_hd_ps", lists_hd_ps);
        ArrayList<Hdmh_tam_thoi> lists_hd_pk = gioHangDAO.getLists_hdmhtt_pk(kh_id);
        request.setAttribute("lists_hd_pk", lists_hd_pk);
        ArrayList<Hddv_tam_thoi> lists_hd_dv = gioHangDAO.getLists_hddvtt_dv(kh_id);
        request.setAttribute("lists_hd_dv", lists_hd_dv);
        ArrayList<Hdmh_tam_thoi> lists_hdmhtt = gioHangDAO.getAll_hdmhtt(kh_id);
        int thanh_tien = 0;
        for (Hdmh_tam_thoi hd : lists_hdmhtt) {
            thanh_tien += hd.getHdmhtt_thanh_tien();
        }
        for (Hddv_tam_thoi hd : lists_hd_dv) {
            thanh_tien += hd.getHddvtt_thanh_tien();
        }
        request.setAttribute("tong_tien", thanh_tien);
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
        ArrayList<Hdmh_tam_thoi> lists_hdmhtt = gioHangDAO.getAll_hdmhtt(kh_id);
        int thanh_tien = 0;
        for (Hdmh_tam_thoi hd : lists_hdmhtt) {
            thanh_tien += hd.getHdmhtt_thanh_tien();
        }
        for (Hddv_tam_thoi hd : lists_hd_dv) {
            thanh_tien += hd.getHddvtt_thanh_tien();
        }
        request.setAttribute("tong_tien", thanh_tien);
        request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
    }

    private void add_dich_vu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int kh_id = Integer.parseInt(request.getParameter("hd_kh_id"));
        String dv_id = request.getParameter("hd_dv_id");
        ArrayList<Hddv_tam_thoi> lists_hd_dv = gioHangDAO.getLists_hddvtt_dv(kh_id);
        boolean check = false;
        for (Hddv_tam_thoi dv: lists_hd_dv) {
            if (dv.getHddvtt_ctdv_id().equals(dv_id)) {
                check = true;
                break;
            }
        }
        if (!check){
            Chi_tiet_dv dich_vu = hospitalService.getDich_Vu(dv_id);
            LocalDate ngay_dat = LocalDate.parse(request.getParameter("ngay_dat_dv"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Hddv_tam_thoi hddvtt = new Hddv_tam_thoi(kh_id, dv_id, ngay_dat, dich_vu.getCtdv_gia());
            gioHangDAO.create_hddvtt(hddvtt);
        }
        ArrayList<Hdmh_tam_thoi> lists_hd_ps = gioHangDAO.getLists_hdmhtt_ps(kh_id);
        request.setAttribute("lists_hd_ps",lists_hd_ps);
        ArrayList<Hdmh_tam_thoi> lists_hd_pk = gioHangDAO.getLists_hdmhtt_pk(kh_id);
        request.setAttribute("lists_hd_pk",lists_hd_pk);
        lists_hd_dv = gioHangDAO.getLists_hddvtt_dv(kh_id);
        request.setAttribute("lists_hd_dv", lists_hd_dv);
        ArrayList<Hdmh_tam_thoi> lists_hdmhtt = gioHangDAO.getAll_hdmhtt(kh_id);
        int thanh_tien = 0;
        for (Hdmh_tam_thoi hd : lists_hdmhtt) {
            thanh_tien += hd.getHdmhtt_thanh_tien();
        }
        for (Hddv_tam_thoi hd : lists_hd_dv) {
            thanh_tien += hd.getHddvtt_thanh_tien();
        }
        request.setAttribute("tong_tien", thanh_tien);
        request.getRequestDispatcher("shopping-cart.jsp").forward(request,response);
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
        if (!check){
            Phu_kien phu_kien = hospitalService.getPhu_Kien(pk_id);
            gioHangDAO.create_hdmhtt_pk(new Hdmh_tam_thoi(kh_id, pk_id, 1, phu_kien.getPk_gia()));
        }
        ArrayList<Hdmh_tam_thoi> lists_hd_ps = gioHangDAO.getLists_hdmhtt_ps(kh_id);
        request.setAttribute("lists_hd_ps",lists_hd_ps);
        ArrayList<Hdmh_tam_thoi> lists_hd_pk = gioHangDAO.getLists_hdmhtt_pk(kh_id);
        request.setAttribute("lists_hd_pk",lists_hd_pk);
        ArrayList<Hddv_tam_thoi> lists_hd_dv = gioHangDAO.getLists_hddvtt_dv(kh_id);
        request.setAttribute("lists_hd_dv", lists_hd_dv);
        ArrayList<Hdmh_tam_thoi> lists_hdmhtt = gioHangDAO.getAll_hdmhtt(kh_id);
        int thanh_tien = 0;
        for (Hdmh_tam_thoi hd : lists_hdmhtt) {
            thanh_tien += hd.getHdmhtt_thanh_tien();
        }
        for (Hddv_tam_thoi hd : lists_hd_dv) {
            thanh_tien += hd.getHddvtt_thanh_tien();
        }
        request.setAttribute("tong_tien", thanh_tien);
        request.getRequestDispatcher("shopping-cart.jsp").forward(request,response);
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
        if (!check) {
            Pet_shop pet_shop = hospitalService.getPet_Shop(ps_id);
            gioHangDAO.create_hdmhtt_ps(new Hdmh_tam_thoi(kh_id, ps_id, 1, pet_shop.getPs_gia()));
        }
        ArrayList<Hdmh_tam_thoi> lists_hd_ps = gioHangDAO.getLists_hdmhtt_ps(kh_id);
        request.setAttribute("lists_hd_ps", lists_hd_ps);
        ArrayList<Hdmh_tam_thoi> lists_hd_pk = gioHangDAO.getLists_hdmhtt_pk(kh_id);
        request.setAttribute("lists_hd_pk", lists_hd_pk);
        ArrayList<Hddv_tam_thoi> lists_hd_dv = gioHangDAO.getLists_hddvtt_dv(kh_id);
        request.setAttribute("lists_hd_dv", lists_hd_dv);
        ArrayList<Hdmh_tam_thoi> lists_hdmhtt = gioHangDAO.getAll_hdmhtt(kh_id);
        int thanh_tien = 0;
        for (Hdmh_tam_thoi hd : lists_hdmhtt) {
            thanh_tien += hd.getHdmhtt_thanh_tien();
        }
        for (Hddv_tam_thoi hd : lists_hd_dv) {
            thanh_tien += hd.getHddvtt_thanh_tien();
        }
        request.setAttribute("tong_tien", thanh_tien);
        request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
    }

    private void display_gio_hang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int kh_id = Integer.parseInt(request.getParameter("hd_kh_id"));
        ArrayList<Hdmh_tam_thoi> lists_hd_ps = gioHangDAO.getLists_hdmhtt_ps(kh_id);
        ArrayList<Hdmh_tam_thoi> lists_hd_pk = gioHangDAO.getLists_hdmhtt_pk(kh_id);
        request.setAttribute("lists_hd_ps", lists_hd_ps);
        request.setAttribute("lists_hd_pk", lists_hd_pk);
        ArrayList<Hddv_tam_thoi> lists_hd_dv = gioHangDAO.getLists_hddvtt_dv(kh_id);
        request.setAttribute("lists_hd_dv", lists_hd_dv);
        ArrayList<Hdmh_tam_thoi> lists_hdmhtt = gioHangDAO.getAll_hdmhtt(kh_id);
        int thanh_tien = 0;
        for (Hdmh_tam_thoi hd : lists_hdmhtt) {
            thanh_tien += hd.getHdmhtt_thanh_tien();
        }
        for (Hddv_tam_thoi hd : lists_hd_dv) {
            thanh_tien += hd.getHddvtt_thanh_tien();
        }
        request.setAttribute("tong_tien", thanh_tien);
        request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
    }
}
