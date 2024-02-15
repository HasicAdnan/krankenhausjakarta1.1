package com.krankenhausjakarta.servlet;

import java.io.IOException;

import com.krankenhausjakarta.dao.PatientTerminDao;
import com.krankenhausjakarta.entity.PatientTermin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/terminLoschen")
public class TerminLoschen extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String terminIdParam = req.getParameter("id");

        if (terminIdParam != null && !terminIdParam.isEmpty()) {
            int terminId = Integer.parseInt(terminIdParam);
            int id = Integer.parseInt(req.getParameter("id"));

            PatientTerminDao patientTermindao = new PatientTerminDao();
            HttpSession session = req.getSession();

            if (patientTermindao.loschenTermin(id)) {
                session.setAttribute("succMsg", "Doctor Delete Sucessfully..");
                resp.sendRedirect("termine.jsp");
        } else {
            // Ako "id" parametar nije pravilno postavljen, obradite to ili generirajte odgovarajući odgovor
            resp.getWriter().println("Invalid or missing 'id' parameter.");
        }
    }
}

}
