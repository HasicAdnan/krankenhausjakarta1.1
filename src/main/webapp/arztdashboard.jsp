<%@page import="com.krankenhausjakarta.dao.ArztDao"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%@page isELIgnored="false"%>
<%@page import="com.krankenhausjakarta.dao.entity.Arzt"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="de">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	<meta name="generator" content="Hugo 0.101.0">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<link rel="stylesheet" href="components/assets/css/arztdashboard.css">
	<script src="js/cov.js"></script>
	<title>Krankenhaus</title>
</head>
<body>


<header class="col-12">
	<div class="logo-wrapper">
		<img src="components/assets/img/logo.jpg" alt="logo" id="logo-img" width="120px" height="120px">
		<h1><a href="#">KRANKENHAUS LINZ</a></h1>
	</div>

	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="#">Patienten</a>
				</li>
				<button type="button" class="btn btn-light">Willkommen ${arztLogger.vorname} ${arztLogger.nachname}</button>
				<li class="nav-item active">
					<a class="nav-link" href="pflegepersonal.jsp">Personal</a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="#">Etwas</a>
				</li>

				<div class="logout">
				<a id="logout" href="index.jsp"><img  src="components/assets/img/check-out.png" width="50px" height="50px"></a>
				</div>

            </ul>
		</div>
	</nav>
	<ul class="soc-net list-reset col-12 col-sm-6 col-md-4 col-lg-3 col-xl-3">
		<li><a href="http://www.facebook.com" target="_blank" class="facebook">Facebook</a></li>
		<li><a href="http://www.twitter.com" target="_blank" class="twitter">Twitter</a></li>
		<li><a href="http://www.linkedin.com" target="_blank" class="linked-in">LinkedIn</a></li>
	</ul>
</header>

<div class="block"></div>

<div class="row">
<main class="col-12" id="main">


	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 p-5">
				<img alt="" src="img/doct.jpg">
			</div>
			<a href="listArzt.jsp">Lista Doktora</a>

			<div class="col-md-6">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3">Arzt Termin</p>
						<c:if test="${not empty arztLogger}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form class="row g-3" action="appAppointment" method="post">

							<input type="hidden" name="userid" value="${userObj.id }">

							<div class="col-md-6">
								<label  class="form-label">Full Name</label> <input
									required type="text" class="form-control" name="fullname">
							</div>

							<div class="col-md-6">
								<label>Gender</label> <select class="form-control" name="gender"
															  required>
								<option value="male">Male</option>
								<option value="female">Female</option>
							</select>
							</div>

							<div class="col-md-6">
								<label  class="form-label">Age</label> <input
									required type="number" class="form-control" name="age">
							</div>

							<div class="col-md-6">
								<label  class="form-label">Appointment
									Date</label> <input type="date" class="form-control" required
														name="appoint_date">
							</div>

							<div class="col-md-6">
								<label  class="form-label">Email</label> <input
									required type="email" class="form-control" name="email">
							</div>

							<div class="col-md-6">
								<label  class="form-label">Phone No</label> <input
									maxlength="10" required type="number" class="form-control"
									name="phno">
							</div>


							<div class="col-md-6">
								<label  class="form-label">Diseases</label> <input
									required type="text" class="form-control" name="diseases">
							</div>

							<div class="col-md-6">
								<label  class="form-label">Doctor</label> <select
									required class="form-control" name="doct">
								<option value="">--select--</option>

								<%
									ArztDao dao = new ArztDao();
									List<Arzt> list = dao.getAllArzt();
									for (Arzt a : list) {
								%>
								<option value="<%=a.getArztid()%>"><%=a.getVorname()%><%=a.getNachname()%>
								</option>
								<%
									}
								%>




							</select>
							</div>

							<div class="col-md-12">
								<label>Full Address</label>
								<textarea required name="address" class="form-control" rows="3"
										  cols=""></textarea>
							</div>

							<c:if test="${empty userObj }">
								<a href="user_login.jsp" class="col-md-6 offset-md-3 btn btn-success">Submit</a>
							</c:if>

							<c:if test="${not empty userObj }">
								<button class="col-md-6 offset-md-3 btn btn-success">Submit</button>
							</c:if>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>




</main>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</body>
</html>