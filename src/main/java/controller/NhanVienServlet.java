package controller;

import model.Nhan_vien;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NhanVienServlet", value = "/NhanVienServlet")
public class NhanVienServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                break;
        }
    }
    private void ediPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Nhan_vien> nhanViens = 
    }
}
