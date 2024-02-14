package servlet;


import com.krankenhausjakarta.dao.PatientDao;
import entity.Patient;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/patientLogin")
public class PatientLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        PatientDao dao = new PatientDao();
        Patient patient = null;
        try {
            patient = dao.login(email, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (patient != null) {
            session.setAttribute("patientLogger", patient);
            session.setAttribute("allesOk", "Sie haben jetzt ein Konto!");
            resp.sendRedirect("patientdashboard.jsp");
        } else {
            session.setAttribute("fehler", "falsche email & password");
            resp.sendRedirect("patientlogin.jsp");
        }

    }
}
