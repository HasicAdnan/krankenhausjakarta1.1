<%@page import="com.krankenhausjakarta.dao.entity.Arzt"%>
<%@page import="com.krankenhausjakarta.dao.ArztDao "%>
<%@page import="java.util.List"%>
<%@page import="com.krankenhausjakarta.dao.ArztDao "%>
<%@ page import="servlet.DBConnection" %>
<%@ page import="com.krankenhausjakarta.dao.entity.PatientTermin" %>
<%@ page import="com.krankenhausjakarta.dao.PatientTerminDao" %>
<%@ page import="com.krankenhausjakarta.dao.entity.Abteilung" %>
<%@ page import="com.krankenhausjakarta.dao.AbteilungDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

    <title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-primary navbar-light">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="arztdashboard.jsp">
                <img src="components/assets/img/previous.png" width="50px" height="50px">
            </a>
        </li>
        <li class="willkommen-logger">
            <h3></h3>
            <h3 >Willkommen ${arztLogger.vorname} ${arztLogger.nachname}</h3>
        </li>
    </ul>
</nav>
<div class="container-fluid p-3">
    <div class="row">
        <div class="col-md-12">
            <div class="card paint-card">
                <div class="card-body">

                    <p class="fs-3 text-center">Terminliste für Untersuchungen</p>

                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Termin</th>
                            <th scope="col">Arzt: </th>
                            <th scope="col">Patientversicherungsnummer</th>
                            <th scope="col">Abteilung: </th>
                            <th scope="col">Datum: </th>
                            <th scope="col">Uhrzeit: </th>
                            <th scope="col">Hinweis: </th>
                        </tr>
                        </thead>
                        <tbody>


                        <%
                            PatientTerminDao dao = new PatientTerminDao();
                            List<PatientTermin> list2 = dao.getAllTermin();
                            for (PatientTermin a : list2) {

                        %>
                        <tr>

                            <td><%=a.getTerminid()%></td>
                            <td>
                                <%

                                    // Dohvatite ID odjeljenja iz objekta
                                    int arztid = a.getArztid();
                                    String arztvorname = "";
                                    String arztnachname = "";// Inicijalizujemo ime odjeljenja
                                    ArztDao arztDao = new ArztDao();
                                    List<Arzt> arztlist = arztDao.getAllArzt();

                                    // Prolazimo kroz listu odjeljenja
                                    for (Arzt arzt : arztlist) {
                                        // Ako je ID odjeljenja u listi jednak ID-u odjeljenja iz objekta
                                        if (arzt.getArztid() == arztid) {
                                            // Postavljamo ime odjeljenja
                                            arztvorname = arzt.getVorname();
                                            arztnachname = arzt.getNachname();
                                            // Možemo prekinuti petlju jer smo pronašli odgovarajuće ime odjeljenja
                                            break;
                                        }
                                    }
                                %>
                                <%= arztvorname %> <%= arztnachname %>
                            </td>
                            <td><%=a.getPatientverischerungsnummer()%></td>
                            <td>
                                <%
                                    // Dohvatite ID odjeljenja iz objekta
                                    int abteilungId = a.getAbteilungid();
                                    String abteilungName = ""; // Inicijalizujemo ime odjeljenja
                                    AbteilungDao abteilungDao = new AbteilungDao();
                                    List<Abteilung> abteilunglist = abteilungDao.getAllAbteilung();

                                    // Prolazimo kroz listu odjeljenja
                                    for (Abteilung abteilung : abteilunglist) {
                                        // Ako je ID odjeljenja u listi jednak ID-u odjeljenja iz objekta
                                        if (abteilung.getAbteilungid() == abteilungId) {
                                            // Postavljamo ime odjeljenja
                                            abteilungName = abteilung.getNamederabteilung();
                                            // Možemo prekinuti petlju jer smo pronašli odgovarajuće ime odjeljenja
                                            break;
                                        }
                                    }
                                %>

                                <%= abteilungName %>
                            </td>
                            <td><%=a.getDatum()%></td>
                            <td><%=a.getUhrzeit()%></td>
                            <td><%=a.getHinweis()%></td>
                            <td><a href="edit.jsp?id=<%=a.getArztid()%>"
                                   class="btn btn-sm btn-primary">Bearbeiten</a>

                                <a
                                        href="../deleteDoctor?id=<%=a.getArztid()%>"
                                        class="btn btn-sm btn-danger">Löschen</a></td>
                        </tr>
                        <%
                            }
                        %>

                        </tbody>
                    </table>

                </div>
            </div>
        </div>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<!-- Footer -->
<footer class="page-footer font-small blue">

    <!-- Copyright -->
    <div class="footer-copyright bg-primary text-center py-3">© 2024 Copyright:
        <a href="/"> MDBootstrap.com</a>
    </div>
    <!-- Copyright -->

</footer>
<!-- Footer -->
</body>
</html>