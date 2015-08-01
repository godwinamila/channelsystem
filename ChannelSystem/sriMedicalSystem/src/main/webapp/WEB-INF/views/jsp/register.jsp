<%--
  Created by IntelliJ IDEA.
  User: chamindah
  Date: 7/31/2015
  Time: 11:41 PM
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

    <!-- user registration --->
    <section class="user-reg-box content-box">
      <h3>Register User</h3>

      <form name="reg-user-form">
        <table class="form-table">
          <tr>
            <td>Name: </td>
            <td>
              <input type="text" name="firstname" placeholder="First Name" />
            </td>
            <td>
              <input type="text" name="lastname" placeholder="Last Name" />
            </td>
          </tr>
          <tr>
            <td>NIC No:</td>
            <td colspan="2">
              <input type="text" name="nic" placeholder="**********V" />
            </td>
          </tr>
          <tr>
            <td>Email:</td>
            <td colspan="2">
              <input type="text" name="email" />
            </td>
          </tr>
          <tr>
            <td>Telephone:</td>
            <td colspan="2">
              <input type="text" name="tp" placeholder="(0**) *** ****" />
            </td>
          </tr>
          <tr>
            <td>Password:</td>
            <td colspan="2">
              <input type="password" name="password" />
            </td>
          </tr>
          <tr>
            <td>Confirm Password:</td>
            <td colspan="2">
              <input type="password" name="confpassword" />
            </td>
          </tr>
          <tr>
            <td></td>
            <td colspan="2">
              <input type="submit" value="Register" />
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

