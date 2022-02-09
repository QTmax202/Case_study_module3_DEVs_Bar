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
            case "thucung":
                petShopById(request, response);
                break;
            default:
                giongPet(request, response);

        }
    }
    private void petShopById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String petShop_id = request.getParameter("id");
        ArrayList<Pet_shop> pet_shops = (ArrayList<Pet_shop>) shopDAO.petShopById(petShop_id);
        request.setAttribute("pet_shops", pet_shops);
        ArrayList<Giong_pet> giong_pets = (ArrayList<Giong_pet>) shopDAO.giongPet();
        request.setAttribute("giong_pets",giong_pets);
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
        request.setAttribute("giong_pets",giong_pets);
        ArrayList<Chi_tiet_dv> chi_tiet_dvs = (ArrayList<Chi_tiet_dv>) shopDAO.loaiDichVu();
        request.setAttribute("chi_tiet_dvs", chi_tiet_dvs);
        ArrayList<Phu_kien> phu_kiens = (ArrayList<Phu_kien>) shopDAO.loaiPhuKien();
        request.setAttribute("phu_kiens", phu_kiens);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        requestDispatcher.forward(request, response);
    }
}
