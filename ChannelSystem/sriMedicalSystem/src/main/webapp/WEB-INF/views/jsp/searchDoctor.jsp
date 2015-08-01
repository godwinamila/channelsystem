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

      <form name="search-doc-form" method="post">
        <table class="form-table">
          <tr>
            <td>
              Last Name:
            </td>
            <td>
              <input type="text" name="lastname" />
            </td>
          </tr>
          <tr>
            <td>Speciality:</td>
            <td>
              <select name="specialty">
                <option>Physician</option>
                <option>Surgon</option>
              </select>
            </td>
          </tr>
          <tr>
            <td></td>
            <td>
              <input type="submit" value="Search..." />
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
