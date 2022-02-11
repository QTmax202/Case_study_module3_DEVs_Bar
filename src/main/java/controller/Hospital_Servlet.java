package controller;

import model.Chi_tiet_dv;
import model.Pet_shop;
import model.Phu_kien;
import service.HospitalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HospitalServlet", urlPatterns = "/hospital")
public class Hospital_Servlet extends HttpServlet {
    private static final HospitalService hospitalService = new HospitalService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "search_pet_shop":
                search_pet_shop(request, response);
                break;
            case "search_phu_kien":
                search_phu_kien(request, response);
                break;
            case "search_dich_vu":
                search_dich_vu(request, response);
                break;
            case "home":
            default:
                display_pet_shop(request, response);
        }
    }

    private void search_dich_vu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("dv_id");
        Chi_tiet_dv dich_vu = hospitalService.getDich_Vu(id);
        ArrayList<Chi_tiet_dv> dich_vus = hospitalService.getLimit4Dich_Vu(id);
        request.setAttribute("dich_vu",dich_vu);
        request.setAttribute("dich_vus", dich_vus);
        request.getRequestDispatcher("shop-details.jsp").forward(request,response);
    }

    private void search_phu_kien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("pk_id");
        Phu_kien phu_kien = hospitalService.getPhu_Kien(id);
        ArrayList<Phu_kien> phu_kiens = hospitalService.getLimit4Phu_Kien(id);
        request.setAttribute("phu_kien",phu_kien);
        request.setAttribute("phu_kiens", phu_kiens);
        request.getRequestDispatcher("shop-details.jsp").forward(request,response);
    }

    private void search_pet_shop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("ps_id"));
        Pet_shop pet_shop = hospitalService.getPet_Shop(id);
        ArrayList<Pet_shop> pet_shops = hospitalService.getLimit4Pet_Shop(id);
        request.setAttribute("pet_shop", pet_shop);
        request.setAttribute("pet_shops", pet_shops);
        request.getRequestDispatcher("shop-details.jsp").forward(request,response);
    }

    private void display_pet_shop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ArrayList<Pet_shop> Pet_shops = hospitalService.getLimit8Pet_Shop();
        ArrayList<Phu_kien> Phu_kiens = hospitalService.getLimit8Phu_Kien();
        ArrayList<Chi_tiet_dv> Dich_vus = hospitalService.getLimit8Dich_Vu();
        request.setAttribute("pet_shops", Pet_shops);
        request.setAttribute("phu_kiens", Phu_kiens);
        request.setAttribute("dich_vus", Dich_vus);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

}
