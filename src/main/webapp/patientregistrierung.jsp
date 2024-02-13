<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Creative Colorlib SignUp Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Custom Theme files -->
    <link href="components/assets/css/patientenregistrierung.css" rel="stylesheet" type="text/css" media="all" />
    <!-- //Custom Theme files -->
    <!-- web font -->
    <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
    <!-- //web font -->
</head>
<body>

<!-- main -->
<div class="main-w3layouts wrapper">
    <div class="main-agileinfo">
        <div class="agileits-top">
            <div action="#" method="post">

                <h1>Patient Regsitrierung</h1>

                <form action="patient_register" method="post">

                    <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example1cg">Vorname : </label>
                        <input type="text" id="form3Example1cg" name="vorname" class="form-control form-control-lg" />

                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example2cg">Nachname : </label>
                        <input type="text" id="form3Example2cg" name="nachname" class="form-control form-control-lg" />
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example3cg">Adresse : </label>
                        <input type="text" id="form3Example3cg" name="adresse" class="form-control form-control-lg" />
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example4cg">Telefonnummer : </label>
                        <input type="text" id="form3Example4cg" name="telefonnummer" class="form-control form-control-lg" />
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example5cg">Versicherungsnummer : </label>
                        <input type="text" id="form3Example5cg" name="versicherungsnummer" class="form-control form-control-lg"/>
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example6cg">Email : </label>
                        <input type="email" id="form3Example6cg" name="email" class="form-control form-control-lg" />
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example7cg">Password : </label>
                        <input type="password" id="form3Example7cg" name="password" class="form-control form-control-lg" />
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example8cg">Geburtstag</label>
                        <input type="text" id="form3Example8cg" class="form-control form-control-lg" />
                    </div>

                    <p class="text-center text-muted mt-5 mb-0">Haben Sie schon ein Konto?
                        <a href="patientlogin.jsp
" class="fw-bold text-body">
                            <u>Login here</u>
                        </a>
                    </p>
                    <input type="submit" value="REGISTRIERUNG">
                </form>


            </div>

        </div>


        </form>
    </div>
</div>
<!-- copyright -->
<div class="colorlibcopy-agile">

    <!-- //copyright -->
    <ul class="colorlib-bubbles">
        <li>A+</li>
        <li>B+</li>
        <li>AB+</li>
        <li>0+</li>
        <li>0-</li>
        <li>A+</li>
        <li>A-</li>
        <li>B-</li>
        <li>AB-</li>
        <li>A+</li>
    </ul>
</div>
<!-- //main -->
</body>
</html>