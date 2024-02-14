<%@page import="entity.Arzt"%>
<%@page import="com.krankenhausjakarta.dao.ArztDao "%>
<%@page import="java.util.List"%>
<%@page import="com.krankenhausjakarta.dao.ArztDao "%>
<%@ page import="servlet.DBConnection" %>
<%@ page import="com.krankenhausjakarta.dao.AbteilungDao" %>
<%@ page import="entity.Abteilung" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@page contentType="text/html" language="java"%>
<!doctype html>
<html lang="">
<head>
	<meta charset="">
	<meta name="viewport" content="width=, user-scalable=, initial-scale=, maximum-scale=, minimum-scale=">
	<meta http-equiv="X-UA-Compatible" content="ie=">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="components/assets/css/arztdashboard.css">
	<title></title>

</head>
<body onload="noBack();">
<!--Navbar -->
<nav class="navbar navbar-expand-sm  navbar-light">
	<ul class="navbar-nav">
		<li class="nav-item active">
			<a class="nav-link" href="index.jsp">Home</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="arztliste.jsp">Arzt List</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="termine.jsp">Termin List</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="index.jsp">Willkommen ${arztLogger.vorname} ${arztLogger.nachname}</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="arztLogout">Logout</a>
		</li>
	</ul>
</nav>

<div  class="container">
	<div class="row justify-content-center">
		<div class="col-md-6">
<form action="appTermin" method="post" style="max-width: 1500px;">
	<h1>Termin: </h1>
	<div class="form-group">
		<label  class="form-label">Arzt</label> <select
			required class="form-control" name="arztid">
		<option value="">--select--</option>

		<%
			ArztDao dao = new ArztDao();
			List<Arzt> list = dao.getAllArzt();
			for (Arzt arzt : list) {
		%>
		<option value="<%=arzt.getArztid()%>"><%=arzt.getVorname()%> <%=arzt.getNachname()%>

		</option>
		<%
			}
		%>
	</select>
	</div>

	<div class="form-group">
		<label for="patientversicherungsnummer">Patient Versicherungsnummer</label>
		<input type="text" name="patientversicherungsnummer" class="form-control" id="patientversicherungsnummer" placeholder="1234 010180">
	</div>

	<div class="form-group">
		<label   class="form-label">Abteilung</label> <select
			required class="form-control" name="abteilungid">
		<option value="">--select--</option>

		<%
			AbteilungDao abteilungDao = new AbteilungDao();
			List<Abteilung> abteilunglist = abteilungDao.getAllAbteilung();
			for (Abteilung abteilung : abteilunglist) {
		%>
		<option value="<%=abteilung.getAbteilungid()%>"><%=abteilung.getNamederabteilung()%>
		</option>
		<%
			}
		%>

	</select>
	</div>
	<div class="form-group">
		<label for="datum" class="form-label">Datum</label>
		<input type="text" name="datum" class="form-control" id="datum" placeholder="10.02.2024">
	</div>

	<div class="form-group">
		<label for="uhrzeit" class="form-label">Uhrzeit</label>
		<input type="text" name="datum" class="form-control" id="uhrzeit" placeholder="15:40">
	</div>

	<div class="form-group">
		<label for="hinweis" class="form-label">Hinweis</label>
		<input type="textarea" name="hinweis" class="form-control" id="hinweis" placeholder="Nachricht...">
	</div>


	<button type="submit" class="btn btn-primary">Termin erfolgreich gebucht</button>
</form>
		</div>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</body>
</html>