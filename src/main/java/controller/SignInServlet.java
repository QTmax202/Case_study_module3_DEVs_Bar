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
    private static final Hospital_Servlet hospital_servlet = new Hospital_Servlet();

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
            case "logOut":
                logOut(request, response);
                break;
        }
    }

    private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("/hospital?action=home").forward(request, response);
    }

    protected void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String acc_username = request.getParameter("acc_username");
        String acc_password = request.getParameter("acc_password");
        Account acc = signInDAO.signIn(acc_username, acc_password);
        if (acc == null) {
            request.setAttribute("message", "Tên tài khoản hoặc mật khẩu sai !");
            request.getRequestDispatcher("/sign-in.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            switch (acc.getAcc_phan_cap()){
                case "AD":
                    session.setAttribute("acc", acc);
                    session.setAttribute("acc_admin", acc);
                    request.getRequestDispatcher("/shop").forward(request, response);
                    break;
                case "NV":
                    session.setAttribute("acc", acc);
                    session.setAttribute("acc_nhan_vien", acc);
                    session.setAttribute("acc_nv_id", acc.getAcc_nv_id());
                    request.getRequestDispatcher("/shop").forward(request, response);
                    break;
                case "KH":
                    session.setAttribute("acc", acc);
                    session.setAttribute("acc_khach_hang", acc);
                    session.setAttribute("acc_kh_id", acc.getAcc_kh_id());
                    request.getRequestDispatcher("/hospital").forward(request, response);
                    break;
            }
        }
    }
}
