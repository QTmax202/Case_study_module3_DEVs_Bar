package controller;

import DAO.SignInDAO;
import model.Account;

<<<<<<< HEAD
=======
import javax.servlet.RequestDispatcher;
>>>>>>> 34bdb348175a14c9f063d9ba7e8d8a1fa8c9ddc8
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
import javax.servlet.http.HttpSession;
>>>>>>> 34bdb348175a14c9f063d9ba7e8d8a1fa8c9ddc8
import java.io.IOException;

@WebServlet(name = "SignInSevlet", urlPatterns = "/sign-in")
public class SignInServlet extends HttpServlet {
    private static final SignInDAO signInDAO = new SignInDAO();
<<<<<<< HEAD
=======
    private static final Hospital_Servlet hospital_servlet = new Hospital_Servlet();
>>>>>>> 34bdb348175a14c9f063d9ba7e8d8a1fa8c9ddc8

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
<<<<<<< HEAD
        }
    }

=======
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

>>>>>>> 34bdb348175a14c9f063d9ba7e8d8a1fa8c9ddc8
    protected void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String acc_username = request.getParameter("acc_username");
        String acc_password = request.getParameter("acc_password");
<<<<<<< HEAD
        SignInDAO signInDAO = new SignInDAO();
        Account a = signInDAO.signIn(acc_username, acc_password);
        if (a == null) {
            request.setAttribute("mess", "Wrong user or pass");
            request.getRequestDispatcher("/sign-in.jsp").forward(request, response);
        } else {
//            request.getRequestDispatcher("shop").forward(request, response);
            response.sendRedirect("/hospital");
        }
    }
}
=======
        Account acc = signInDAO.signIn(acc_username, acc_password);
        if (acc == null) {
            request.setAttribute("mess", "Tên tài khoản hoặc mật khẩu sai !");
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
>>>>>>> 34bdb348175a14c9f063d9ba7e8d8a1fa8c9ddc8
