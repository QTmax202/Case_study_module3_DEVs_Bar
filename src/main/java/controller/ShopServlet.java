package controller;

import DAO.ShopDAO;
import model.Chi_tiet_dv;
import model.Giong_pet;
import model.Pet_shop;
import model.Phu_kien;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShopServlet", urlPatterns = "/shop")
public class ShopServlet extends HttpServlet {
    private static final ShopDAO shopDAO = new ShopDAO();

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
            case "sap-xep-tang":
                sap_xep_pet_tang(request, response);
                break;
            case "sap-xep-giam":

                break;
            case "dichvu":
                dich_vu_theo_id(request, response);
                break;
            case "phukien":
                phu_kien_theo_id(request, response);
                break;
            case "thucung":
                petShopById(request, response);
                break;
            case "tim-kiem":
                tim_kiem(request, response);
                break;
            case "list-phu-kien":
                list_phu_kien(request, response);
                break;
            case "list-dich-vu":
                list_dich_vu(request, response);
                break;
            case "list-thu-cung":
            default:
                giongPet(request, response);
        }
    }

    private void sap_xep_pet_tang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String petShop_id = request.getParameter("id");
        ArrayList<Pet_shop> pet_shops = (ArrayList<Pet_shop>) shopDAO.pet_tang(petShop_id);
        request.setAttribute("pet_shops", pet_shops);
        ArrayList<Giong_pet> giong_pets = (ArrayList<Giong_pet>) shopDAO.giongPet();
        request.setAttribute("giong_pets", giong_pets);
        ArrayList<Chi_tiet_dv> chi_tiet_dvs = (ArrayList<Chi_tiet_dv>) shopDAO.loaiDichVu();
        request.setAttribute("chi_tiet_dvs", chi_tiet_dvs);
        ArrayList<Phu_kien> phu_kiens = (ArrayList<Phu_kien>) shopDAO.loaiPhuKien();
        request.setAttribute("phu_kiens", phu_kiens);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        requestDispatcher.forward(request, response);
    }

    private void dich_vu_theo_id(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ArrayList<Chi_tiet_dv> chi_tiet_dv = (ArrayList<Chi_tiet_dv>) shopDAO.dich_vu_theo_id(id);
        request.setAttribute("chi_tiet_dv", chi_tiet_dv);
        request.setAttribute("ghim", id);
        ArrayList<Giong_pet> giong_pets = (ArrayList<Giong_pet>) shopDAO.giongPet();
        request.setAttribute("giong_pets", giong_pets);
        ArrayList<Chi_tiet_dv> chi_tiet_dvs = (ArrayList<Chi_tiet_dv>) shopDAO.loaiDichVu();
        request.setAttribute("chi_tiet_dvs", chi_tiet_dvs);
        ArrayList<Phu_kien> phu_kiens = (ArrayList<Phu_kien>) shopDAO.loaiPhuKien();
        request.setAttribute("phu_kiens", phu_kiens);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        requestDispatcher.forward(request, response);
    }

    private void phu_kien_theo_id(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ArrayList<Phu_kien> phu_kien_id = (ArrayList<Phu_kien>) shopDAO.phu_kien_theo_id(id);
        request.setAttribute("phu_kien_id", phu_kien_id);
        request.setAttribute("ghim", id);
        ArrayList<Giong_pet> giong_pets = (ArrayList<Giong_pet>) shopDAO.giongPet();
        request.setAttribute("giong_pets", giong_pets);
        ArrayList<Chi_tiet_dv> chi_tiet_dvs = (ArrayList<Chi_tiet_dv>) shopDAO.loaiDichVu();
        request.setAttribute("chi_tiet_dvs", chi_tiet_dvs);
        ArrayList<Phu_kien> phu_kiens = (ArrayList<Phu_kien>) shopDAO.loaiPhuKien();
        request.setAttribute("phu_kiens", phu_kiens);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        requestDispatcher.forward(request, response);
    }

    private void petShopById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String petShop_id = request.getParameter("id");
        ArrayList<Pet_shop> pet_shops = (ArrayList<Pet_shop>) shopDAO.petShopById(petShop_id);
        request.setAttribute("pet_shops", pet_shops);
        request.setAttribute("ghim", petShop_id);
        ArrayList<Giong_pet> giong_pets = (ArrayList<Giong_pet>) shopDAO.giongPet();
        request.setAttribute("giong_pets", giong_pets);
        ArrayList<Chi_tiet_dv> chi_tiet_dvs = (ArrayList<Chi_tiet_dv>) shopDAO.loaiDichVu();
        request.setAttribute("chi_tiet_dvs", chi_tiet_dvs);
        ArrayList<Phu_kien> phu_kiens = (ArrayList<Phu_kien>) shopDAO.loaiPhuKien();
        request.setAttribute("phu_kiens", phu_kiens);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        requestDispatcher.forward(request, response);
    }

    private void giongPet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Pet_shop> pet_shops = (ArrayList<Pet_shop>) shopDAO.petShop();
        request.setAttribute("pet_shops", pet_shops);
        ArrayList<Giong_pet> giong_pets = (ArrayList<Giong_pet>) shopDAO.giongPet();
        request.setAttribute("giong_pets", giong_pets);
        ArrayList<Chi_tiet_dv> chi_tiet_dvs = (ArrayList<Chi_tiet_dv>) shopDAO.loaiDichVu();
        request.setAttribute("chi_tiet_dvs", chi_tiet_dvs);
        ArrayList<Phu_kien> phu_kiens = (ArrayList<Phu_kien>) shopDAO.loaiPhuKien();
        request.setAttribute("phu_kiens", phu_kiens);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        requestDispatcher.forward(request, response);
    }

    private void list_phu_kien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Phu_kien> list_phu_kien = (ArrayList<Phu_kien>) shopDAO.phu_kien();
        request.setAttribute("phu_kien_id", list_phu_kien);
        ArrayList<Giong_pet> giong_pets = (ArrayList<Giong_pet>) shopDAO.giongPet();
        request.setAttribute("giong_pets", giong_pets);
        ArrayList<Chi_tiet_dv> chi_tiet_dvs = (ArrayList<Chi_tiet_dv>) shopDAO.loaiDichVu();
        request.setAttribute("chi_tiet_dvs", chi_tiet_dvs);
        ArrayList<Phu_kien> phu_kiens = (ArrayList<Phu_kien>) shopDAO.loaiPhuKien();
        request.setAttribute("phu_kiens", phu_kiens);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        requestDispatcher.forward(request, response);
    }

    private void list_dich_vu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Chi_tiet_dv> list_dich_vu = (ArrayList<Chi_tiet_dv>) shopDAO.dich_vu();
        request.setAttribute("chi_tiet_dv", list_dich_vu);
        ArrayList<Giong_pet> giong_pets = (ArrayList<Giong_pet>) shopDAO.giongPet();
        request.setAttribute("giong_pets", giong_pets);
        ArrayList<Chi_tiet_dv> chi_tiet_dvs = (ArrayList<Chi_tiet_dv>) shopDAO.loaiDichVu();
        request.setAttribute("chi_tiet_dvs", chi_tiet_dvs);
        ArrayList<Phu_kien> phu_kiens = (ArrayList<Phu_kien>) shopDAO.loaiPhuKien();
        request.setAttribute("phu_kiens", phu_kiens);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        requestDispatcher.forward(request, response);
    }

    private void tim_kiem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("tim-kiem");
        request.setAttribute("tim", name);
        ArrayList<Pet_shop> pet_shops = (ArrayList<Pet_shop>) shopDAO.tim_thu_cung(name);
        request.setAttribute("pet_shops", pet_shops);
        ArrayList<Phu_kien> list_phu_kien = (ArrayList<Phu_kien>) shopDAO.tim_phu_kien(name);
        request.setAttribute("phu_kien_id", list_phu_kien);
        ArrayList<Chi_tiet_dv> list_dich_vu = (ArrayList<Chi_tiet_dv>) shopDAO.tim_dich_vu(name);
        request.setAttribute("chi_tiet_dv", list_dich_vu);
        ArrayList<Giong_pet> giong_pets = (ArrayList<Giong_pet>) shopDAO.giongPet();
        request.setAttribute("giong_pets", giong_pets);
        ArrayList<Chi_tiet_dv> chi_tiet_dvs = (ArrayList<Chi_tiet_dv>) shopDAO.loaiDichVu();
        request.setAttribute("chi_tiet_dvs", chi_tiet_dvs);
        ArrayList<Phu_kien> phu_kiens = (ArrayList<Phu_kien>) shopDAO.loaiPhuKien();
        request.setAttribute("phu_kiens", phu_kiens);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        requestDispatcher.forward(request, response);
    }
}
