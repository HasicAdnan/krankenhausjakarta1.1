package servlet;


import com.krankenhausjakarta.dao.ArztDao;
import com.krankenhausjakarta.dao.entity.Arzt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/arztLogin")
public class ArztLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        ArztDao dao = new ArztDao();
        Arzt arzt = null;
        try {
            arzt = dao.login(email, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (arzt != null) {
            session.setAttribute("arztLogger", arzt);
            session.setAttribute("allesOk", "Sie haben jetzt ein Konto!");
            resp.sendRedirect("arztdashboard.jsp");
        } else {
            session.setAttribute("fehler", "falsche email & password");
            resp.sendRedirect("arztlogin.jsp");
        }

    }
}
