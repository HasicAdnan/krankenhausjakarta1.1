<%@page import="entity.Arzt"%>
<%@page import="com.krankenhausjakarta.dao.ArztDao "%>
<%@page import="java.util.List"%>
<%@page import="com.krankenhausjakarta.dao.ArztDao "%>
<%@ page import="servlet.DBConnection" %>
<%@ page import="entity.PatientTermin" %>
<%@ page import="com.krankenhausjakarta.dao.PatientTerminDao" %>
<%@ page import="entity.Abteilung" %>
<%@ page import="com.krankenhausjakarta.dao.AbteilungDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <title>Terminliste für Untersuchungen</title>
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
            <h3>Willkommen ${arztLogger.vorname} ${arztLogger.nachname}</h3>
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
                            <th scope="col">Pacijent</th>
                            <th scope="col">Abteilung: </th>
                            <th scope="col">Datum: </th>
                            <th scope="col">Uhrzeit: </th>
                            <th scope="col">Hinweis: </th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            // Iteriraj kroz listu termina pacijenta
                            for (PatientTermin pt : list2) {
                        %>
                        <tr>
                            <td><%= pt.getTerminid() %></td>
                            <td><%= pt.getArzt().getVorname() %> <%= pt.getArzt().getNachname() %></td>
                            <td><%= trenutniPacijent.getVorname() %> <%= trenutniPacijent.getNachname() %></td>
                            <td><%= pt.getAbteilung().getNamederabteilung() %></td>
                            <td><%= pt.getDatum() %></td>
                            <td><%= pt.getUhrzeit() %></td>
                            <td><%= pt.getHinweis() %></td>
                            <td>
                                <a href="edit.jsp?id=<%= pt.getPatientverischerungsnummer() %>"
                                   class="btn btn-sm btn-primary">Bearbeiten</a>
                                <a href="../deleteDoctor?id=<%= pt.getPatientverischerungsnummer() %>"
                                   class="btn btn-sm btn-danger">Löschen</a>
                            </td>
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
<footer class="page-footer font-small blue">
    <div class="footer-copyright bg-primary text-center py-3">© 2024 Copyright:
        <a href="/"> MDBootstrap.com</a>
    </div>
</footer>
</body>
</html>
