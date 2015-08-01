<%--
  Created by IntelliJ IDEA.
  User: chamindah
  Date: 8/1/2015
  Time: 12:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Sri Medicals</title>
  <spring:url value="/resources/core/css/global.css" var="coreCss" />
  <link href="${coreCss}" rel="stylesheet" />
</head>

<body>
<header>
  <div class="wrapper">
    <div>
      <h1><a href="#">Sri Medicals</a></h1>

      <div class="account-bar">
        <a href="#"></a> | <a href="#">Logout</a>
      </div>
    </div>
    <nav>
      <ul>
        <li><a href="./">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Search Doctor</a></li>
        <li><a href="#">Check Appointments</a></li>
        <li><a href="#">Contact Us</a></li>
      </ul>
    </nav>
  </div>
</header>

<div class="main-content">
  <div class="wrapper">

    <!-- doctor search -->
    <section class="search-doc-box content-box">
      <h3>Search Doctor</h3>

      <table class="tab-doc-search-res tab-alt">
        <thead>
        <tr>
          <th>Name</th>
          <th>Specialty</th>
          <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>Dr. A B C De Silva</td>
          <td>Physician</td>
          <td><a href="channelDoctor">Book Now</a></td>
        </tr>
        <tr>
          <td>Dr. Kamal Perera</td>
          <td>Physician</td>
          <td><a href="#">Book Now</a></td>
        </tr>
        <tr>
          <td>Dr. Nihal Goonaratne</td>
          <td>Surgeon</td>
          <td><a href="#">Book Now</a></td>
        </tr>
        <tr>
          <td>Prof. A N C Wijerathne</td>
          <td>Physician</td>
          <td><a href="#">Book Now</a></td>
        </tr>
        </tbody>
      </table>

    </section>


  </div>
  <!-- end of wrapper -->
</div>
<!-- end of main content -->


<footer>
  <div class="wrapper">
    <p class="copyright">&copy; 2015 Sri Medicals. All rights reserved.</p>
  </div>
</footer>

</body>

</html>
