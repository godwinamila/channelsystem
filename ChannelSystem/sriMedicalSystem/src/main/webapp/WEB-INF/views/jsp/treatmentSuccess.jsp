<%--
  Created by IntelliJ IDEA.
  User: chamindah
  Date: 7/31/2015
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html>

<head>
<meta charset="UTF-8">
<title>Sri Medicals</title>
<spring:url value="/resources/core/css/global.css" var="coreCss" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<body>
	<%@ include file="header.jsp"%>

	<div class="main-content">
		<div class="wrapper">

			<!-- success message -->
			<section class="success-msg">
				<p>Treatment saved successfully!</p>
			</section>
		</div>
		<!-- end of wrapper -->
	</div>
	<!-- end of main content -->

	<%@ include file="footer.jsp"%>
</body>

</html>

