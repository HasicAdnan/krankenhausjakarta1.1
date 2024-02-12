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
<div class="container-fluid pt-5">
    <div class="row flex-nowrap">

    </div>
</div>

</main>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</body>
</html>