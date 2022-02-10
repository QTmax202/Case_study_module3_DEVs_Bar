package controller;

import DAO.NhanVienDAO;
import DAO.SignInDAO;
import model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@WebServlet(name = "SignUpServlet", urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("acc_username");
        String pass = request.getParameter("acc_password");
        String re_pass = request.getParameter("repass");
        if (!pass.equals(re_pass)) {
            response.sendRedirect("sign-in.jsp");
        } else {
            SignInDAO dao = new SignInDAO();
            Account a = dao.checkAccountExist(user);
            if (a == null) {
                response.sendRedirect("sign-in.jsp");
            }
        }
    }
}
