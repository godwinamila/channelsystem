<%--
  Created by IntelliJ IDEA.
  User: chamindah
  Date: 7/31/2015
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>Sri Medicals</title>
   <link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/global.css"/>"/>
</head>

<body>

<%@ include file="../header.jsp" %>
<div class="main-content">
  <div class="wrapper">
	<!-- success message -->
	<section class="success-msg">
	  <p>Thank you. Patient successfully registered! Please check your email to activate the account.</p>
	</section>
  </div>
  <!-- end of wrapper -->
</div>
<!-- end of main content -->

<%@ include file="../footer.jsp" %>


</body>

</html>

