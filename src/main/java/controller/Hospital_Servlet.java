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
            case "shop":
                break;
            case "home":
                display_pet_shop(request, response);
                break;
            default:
                display_pet_shop(request, response);
        }    }

    private void display_pet_shop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ArrayList<Pet_shop> Pet_shops = hospitalService.getLimit8Pet_Shop();
        ArrayList<Phu_kien> Phu_kiens = hospitalService.getLimit8Phu_Kien();
        ArrayList<Chi_tiet_dv> Dich_vus =hospitalService.getLimit8Dich_Vu();
        request.setAttribute("pet_shops", Pet_shops);
        request.setAttribute("phu_kiens", Phu_kiens);
        request.setAttribute("dich_vus", Dich_vus);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

}
