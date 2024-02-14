package servlet;

import com.krankenhausjakarta.dao.PatientDao;
import entity.Patient;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/patient_register")
public class PatientRegistrierung extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String vorname = req.getParameter("vorname");
            String nachname = req.getParameter("nachname");
            String adresse = req.getParameter("adresse");
            String telefonnummer = req.getParameter("telefonnummer");
            String patientversicherungsnummer = req.getParameter("versicherungsnummer");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String passwordEncrypt = PasswordEncrypt.encryptPassword(password);
            String geburtstag = req.getParameter("geburtstag");
            String ipAdresse = req.getParameter("ipadresse");


           Patient patient = new Patient(vorname, nachname,adresse,telefonnummer,patientversicherungsnummer, email, passwordEncrypt, geburtstag, ipAdresse);

            PatientDao dao = new PatientDao();

            HttpSession session = req.getSession();
            boolean result = dao.register(patient);


            if (result) {
                RequestDispatcher re = req.getRequestDispatcher("patientlogin.jsp");
                re.forward(req, resp);
            } else {
                session.setAttribute("errorMsg", "Ops, können Sie versuchen noch einmal");
                resp.sendRedirect("patientregistrierung.jsp");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
