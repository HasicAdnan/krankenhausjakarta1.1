package servlet;


import com.krankenhausjakarta.dao.TerminDao;
import com.krankenhausjakarta.dao.entity.Termin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/appTermin")
public class TerminServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            int arztid = Integer.parseInt(req.getParameter("arztid"));
            String patientvesricherungsnummer= req.getParameter("patientversicherungsnummer");
            int abteilungid = Integer.parseInt(req.getParameter("abteilungid"));
            String datum = req.getParameter("datum");
            String uhrzeit = req.getParameter("uhrzeit");
            String hinweis = req.getParameter("hinweis");

            Termin ter = new Termin(arztid, patientvesricherungsnummer, abteilungid,datum, uhrzeit, hinweis);
            DBConnection dbInstance = DBConnection.getInstance();
            Connection conn = dbInstance.getConnect();
            TerminDao dao = new TerminDao();
            HttpSession session = req.getSession();

            if (dao.addTermin(ter)) {
                session.setAttribute("succMsg", "Termin Sucessfully");
                resp.sendRedirect("arzt_dashboard.jsp");
            } else {
                session.setAttribute("errorMsg", "Something wrong on server");
                resp.sendRedirect("arzt_appointment.jsp");

            }

    }
}