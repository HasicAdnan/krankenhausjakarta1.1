<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="components/assets/css/arztregistrierung.css">
    <title>Document</title>
</head>
<body>
<section class="bg-image">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card p-5">
                        <img src="components/assets/img/logo.jpg" class="img-fluid reg-logo"/>
                            <h2 class="text-uppercase text-center mb-5">Arzt<br>Registrierung</h2>

                            <form action="arzt_register" method="post">

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


                                <div class="d-flex justify-content-center">
                                    <button type="submit"
                                            class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Haben Sie schon ein Konto?
                                    <a href="arztlogin.jsp" class="fw-bold text-body">
                                        <u>Login here</u>
                                    </a>
                                </p>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</body>
</html>