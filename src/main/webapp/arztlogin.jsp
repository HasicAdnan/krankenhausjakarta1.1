<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="components/assets/css/arztlogin.css">
    <link rel="icon" href="components/assets/img/logo.jpg" type="image/x-icon">
    <title>Arzt Login</title>

</head>
<body>

        <div class="container py-5 h-100">
          <div class="row d-flex justify-content-center align-items-center h-100" id="h-100">
            <div class="col-xl-10 login-form">
              <div class="card rounded-3 text-black">
                <div class="row g-0">
                  <div class="col-lg-6">
                    <div class="card-body p-md-5 mx-md-4">

                      <div class="text-center">
                        <img src="components/assets/img/logo.jpg"
                          style="width: 185px;" alt="logo">
                        <h4 class="mt-1 mb-5 pb-1">KRANKENHAUS LINZ</h4>
                      </div>

                      <form action="arztLogin" method="post">
                          <c:if test="${not empty allesOk}">
                              <p class="form-outline mb-4">${allesOk}</p>
                              <c:remove var="errorMsg" scope="session" />
                          </c:if>
                          <c:if test="${not empty fehler}">
                              <div class="form-outline mb-4s" role="alert">${fehler}</div>
                              <c:remove var="allesOk" scope="session" />
                          </c:if>
                        <p>Please login to your account</p>

                        <div class="form-outline mb-4">
                          <input name="email" type="email" id="form2Example11" class="form-control"
                            placeholder="Email address" />
                          <label class="form-label" for="form2Example11">Email</label>
                        </div>

                        <div class="form-outline mb-4">
                          <input name="password" type="password" id="form2Example22" class="form-control" />
                          <label class="form-label" for="form2Example22">Password</label>
                        </div>

                        <div class="text-center pt-1 mb-5 pb-1">
                          <button class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" type="submit">Log
                            in</button>
                          <a class="text-muted" href="#!">Forgot password?</a>
                        </div>

                        <div class="d-flex align-items-center justify-content-center pb-4">
                          <p class="mb-0 me-2">Haben Sie noch kein Konto??</p>
                            <a href="arztregistrierung.jsp"  class="text-decoration-none">
                                <button type="button" class="btn btn-outline-danger">
                           Dann erstellen Sie jetzt eins!
                          </button>
                            </a>
                        </div>

                      </form>

                    </div>
                  </div>
                  <div class="col-lg-6 d-flex align-items-center gradient-custom-2">
                    <div class="text-white px-3 py-4 p-md-5 mx-md-4">
                      <h4 class="mb-4">Sehr geehrte Damen und Herren</h4>
                      <p class="small mb-0">"Sehr geehrte Patienten, wir begrüßen Sie herzlich in unserer Einrichtung. Wir werden alles tun, um Ihnen den Aufenthalt so angenehm wie möglich zu gestalten."</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <%
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Expires", "0");
            response.setDateHeader("Expires", -1);
            session.invalidate();
        %>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</body>
</html>