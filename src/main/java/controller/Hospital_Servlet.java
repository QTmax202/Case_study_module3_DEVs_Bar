package controller;

import model.Pet_shop;
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
            default:
                display_pet_shop(request, response);
        }    }

    private void display_pet_shop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ArrayList<Pet_shop> Pet_shops = hospitalService.getAllPet_shop();
        request.setAttribute("pet_shops", Pet_shops);
        request.getRequestDispatcher("").forward(request,response);
    }

}
