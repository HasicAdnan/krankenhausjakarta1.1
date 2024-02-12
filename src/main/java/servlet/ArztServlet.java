package servlet;

import com.krankenhausjakarta.dao.ArztDao;
import com.krankenhausjakarta.dao.entity.Arzt;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/arzt_register")
public class ArztServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String vorname = req.getParameter("vorname");
            String nachname = req.getParameter("nachname");
            String adresse = req.getParameter("adresse");
            String telefonnummer = req.getParameter("telefonnummer");
            String versicherungsnummer = req.getParameter("versicherungsnummer");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String passwordEncrypt = PasswordEncrypt.encryptPassword(password);
            String geburtstag = req.getParameter("geburtstag");
            String ipAdresse = req.getParameter("ipadresse");

            Arzt arzt = new Arzt(vorname, nachname, adresse, telefonnummer, versicherungsnummer, email, passwordEncrypt, geburtstag, ipAdresse);

            System.out.println(arzt.toString());
            DBConnection dbInstance = DBConnection.getInstance();
            Connection conn = dbInstance.getConnect();

            ArztDao dao = new ArztDao();

            HttpSession session = req.getSession();

            boolean f = dao.register(arzt);


            if (f) {
                conn.close();
                RequestDispatcher re = req.getRequestDispatcher("arztlogin.jsp");
                re.forward(req, resp);

            } else {
                conn.close();
                session.setAttribute("errorMsg", "Ops, können Sie versuchen noch einmal");
                resp.sendRedirect("arztregistrierung.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
