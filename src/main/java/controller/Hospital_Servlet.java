package controller;

import DAO.HospitalDAO;
import model.pet_shop;
import service.HospitalService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Hospital_Servlet", value = "/hospital")
public class Hospital_Servlet extends HttpServlet {
    private static final HospitalService hospitalService = new HospitalService();
    private static final HospitalDAO hospitalDAO = new HospitalDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        response.setContentType("text/html;charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "shop":
                break;
            default:
                display_shop(request, response);
        }
    }

    private void display_shop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<pet_shop> pet_shops = hospitalService.getLimit8Pet_shop();
        request.setAttribute("pet_shops",pet_shops);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
//        requestDispatcher.forward(request,response);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
