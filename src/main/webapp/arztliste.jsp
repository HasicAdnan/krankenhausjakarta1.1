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
    </ul>
</nav>
<div class="container-fluid p-3">
    <div class="row">
        <div class="col-md-12">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-3 text-center">Arzt Liste</p>

                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Arzt ID: </th>
                            <th scope="col">Vorname: </th>
                            <th scope="col">Nachname: </th>
                            <th scope="col">Adresse: </th>
                            <th scope="col">Telefonnummer: </th>
                            <th scope="col">Versicherungsnummer: </th>
                        </tr>
                        </thead>
                        <tbody>


                        <%
                            ArztDao dao = new ArztDao();
                            List<Arzt> listarzt = dao.getAllArzt();
                            for (Arzt a : listarzt) {

                        %>
                        <tr>
                            <td><%=a.getArztid()%></td>
                            <td><%=a.getVorname()%></td>
                            <td><%=a.getNachname()%></td>
                            <td><%=a.getNachname()%></td>
                            <td><%=a.getTelefonnummer()%></td>
                            <td><%=a.getVersicherungsnummer()%></td>

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