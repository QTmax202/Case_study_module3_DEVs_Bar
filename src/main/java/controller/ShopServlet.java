package controller;

import DAO.ShopDAOIpm;
import model.Giong_pet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShopServlet", urlPatterns = "/shop-servlet")
public class ShopServlet extends HttpServlet {
    private static final ShopDAOIpm shopDAOImp = new ShopDAOIpm();

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
                categoryPet(request, response);
        }    }

    private void categoryPet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ArrayList<Giong_pet> giong_pets = (ArrayList<Giong_pet>) shopDAOImp.categoryPet();
        request.setAttribute("giong_pets",giong_pets);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        requestDispatcher.forward(request, response);
    }

}
