<%@ page language="java" import="servlet.DBConnection" %>
<%@ page language="java" import="java.sql.DriverManager" %>
<%@ page language="java" import="java.sql.Connection" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="de">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	<meta name="generator" content="Hugo 0.101.0">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<link rel="stylesheet" href="components/assets/css/main.css">
	<title>Krankenhaus</title>
	<script type="text/javascript">
		// Funkcija za sprečavanje povratka na prethodnu stranicu
		window.history.forward();
		function noBack() { window.history.forward(); }
	</script>
</head>
<body onload="noBack();">
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
					<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="patientregistrierung.jsp">Patienten</a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="pflegepersonal">Personal</a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="arztlogin.jsp">Ärzte</a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="#">Notfall</a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="#">Kontakt</a>
				</li>

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
<main class="col-12" id="background-video">
	<div class="row">
	<div class="video-container">
		<video autoplay muted loop>
			<source src="components/assets/video/videoBackground.mp4" type="video/mp4" />
		</video>
	</div>
	</div>
</main>

<section class="col-12 abteilung-section row">
	<div class="album py-5 bg-light">
		<div class="container">

			<div class="row">

				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img src="components/assets/img/kardiologie.jpg"
							 class="bd-placeholder-img card-img-top" width="100%" height="225"
							 role="img" aria-label="Placeholder: Thumbnail"
							 preserveAspectRatio="xMidYMid slice" focusable="false">
						<div class="card-body">
							<p class="card-text">KARDIOLOGIE</p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-outline-secondary">View</button>

								</div>
								<small class="text-muted">9 mins</small>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img src="components/assets/img/chirurgie.jpg"
							 class="bd-placeholder-img card-img-top" width="100%" height="225"
							 role="img" aria-label="Placeholder: Thumbnail"
							 preserveAspectRatio="xMidYMid slice" focusable="false">
						<div class="card-body">
							<p class="card-text">CHIRURGIE</p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-outline-secondary">View</button>

								</div>
								<small class="text-muted">9 mins</small>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img src="components/assets/img/neurologie.jpg"
							 class="bd-placeholder-img card-img-top" width="100%" height="225"
							 role="img" aria-label="Placeholder: Thumbnail"
							 preserveAspectRatio="xMidYMid slice" focusable="false">
						<div class="card-body">
							<p class="card-text">NEUROLOGIE</p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-outline-secondary">View</button>

								</div>
								<small class="text-muted">9 mins</small>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img src="components/assets/img/notfall.jpg"
							 class="bd-placeholder-img card-img-top" width="100%" height="225"
							 role="img" aria-label="Placeholder: Thumbnail"
							 preserveAspectRatio="xMidYMid slice" focusable="false">
						<div class="card-body">
							<p class="card-text">NOTFALL</p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-outline-secondary">View</button>

								</div>
								<small class="text-muted">9 mins</small>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img src="components/assets/img/orthopaedie.jpg"
							 class="bd-placeholder-img card-img-top" width="100%" height="225"
							 role="img" aria-label="Placeholder: Thumbnail"
							 preserveAspectRatio="xMidYMid slice" focusable="false">
						<title>Placeholder</title>
						<rect width="100%" height="100%" fill="#55595c" />
						<div class="card-body">
							<p class="card-text">ORTHOPÄDIE</p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-outline-secondary">View</button>

								</div>
								<small class="text-muted">9 mins</small>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img src="components/assets/img/Impfzentrum.jpg"
							 class="bd-placeholder-img card-img-top" width="100%" height="225"
							 role="img" aria-label="Placeholder: Thumbnail"
							 preserveAspectRatio="xMidYMid slice" focusable="false">
						<title>Placeholder</title>
						<rect width="100%" height="100%" fill="#55595c" />

						<div class="card-body">
							<p class="card-text">IMPFZENTRUM</p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-outline-secondary">View</button>

								</div>
								<small class="text-muted">9 mins</small>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script src="components/assets/js/noBack.js"></script>

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