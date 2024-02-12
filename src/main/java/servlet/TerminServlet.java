package servlet;


import com.krankenhausjakarta.dao.TerminDao;
import com.krankenhausjakarta.dao.entity.PatientTermin;
import jakarta.servlet.RequestDispatcher;
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

            PatientTermin ter = new PatientTermin(arztid, patientvesricherungsnummer, abteilungid,datum, uhrzeit, hinweis);
            DBConnection dbInstance = DBConnection.getInstance();
            Connection conn = dbInstance.getConnect();
            TerminDao dao = new TerminDao();
            HttpSession session = req.getSession();
            System.out.println(ter.toString());

            boolean f = dao.addTermin(ter);
            if (f) {
                RequestDispatcher re = req.getRequestDispatcher("index.jsp");
                re.forward(req, resp);
            } else {
                session.setAttribute("errorMsg", "Ops, können Sie versuchen noch einmal");
                resp.sendRedirect("arztregistrierung.jsp");
            }

    }
}