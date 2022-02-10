package controller;

import DAO.SignInDAO;
import model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SignInSevlet", urlPatterns = "/sign-in")
public class SignInServlet extends HttpServlet {
    private static final SignInDAO signInDAO = new SignInDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logIn(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logIn(request, response);
    }

    private void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "logIn":
                signIn(request, response);
                break;
        }
    }

    protected void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String acc_username = request.getParameter("acc_username");
        String acc_password = request.getParameter("acc_password");
        SignInDAO signInDAO = new SignInDAO();
        Account a = signInDAO.signIn(acc_username, acc_password);
        if (a == null) {
            request.setAttribute("mess", "Wrong user or pass");
            request.getRequestDispatcher("/sign-in.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("acc", a);
            response.sendRedirect("/hospital");
        }
    }
}
