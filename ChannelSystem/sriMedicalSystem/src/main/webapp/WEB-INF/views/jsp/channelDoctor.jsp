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

    <!-- doctor search - channel -->
    <section class="search-doc-channel-box content-box">
      <h3>Channel Doctor</h3>

      <form name="channel-doc-form" method="post">
        <table class="form-table">
          <tr>
            <td colspan="2">
              <h4>Doctor Details</h4>
            </td>
          </tr>
          <tr>
            <td>Doctor Name: </td>
            <td>Dr. Kamal Perera</td>
          </tr>
          <tr>
            <td>Specialty: </td>
            <td>Physician</td>
          </tr>
          <tr>
            <td colspan="2">
              <h4>Patient Details</h4>
            </td>
          </tr>
          <tr>
            <td>Patient Name: </td>
            <td>Lasantha Samarakoon</td>
          </tr>
          <tr>
            <td>NIC No: </td>
            <td>871054251V</td>
          </tr>
          <tr>
            <td>Telephone: </td>
            <td>(071) 234 5678</td>
          </tr>
          <tr>
            <td colspan="2">
              <h4>Appointment Details</h4>
            </td>
          </tr>
          <tr>
            <td>Date: </td>
            <td>
              <input type="text" name="appdate" placeholder="DD/MM/YYYY" />
            </td>
          </tr>
          <tr>
            <td>Time: </td>
            <td>
              <input type="text" name="apptime" placeholder="HH:MM" />
            </td>
          </tr>
          <tr>
            <td>Appointment No: </td>
            <td>4</td>
          </tr>
          <tr>
            <td>Room No: </td>
            <td>508</td>
          </tr>
          <tr>
            <td></td>
            <td>
              <input type="submit" value="Confirm" />
            </td>
          </tr>
        </table>
      </form>

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
