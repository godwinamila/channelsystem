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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

  <script>
  $(function() {
    $( "#fromDate" ).datepicker();
  });
  </script>
  
  
  <script>
  $(function() {
    $( "#toDate" ).datepicker();
  });
  </script>
</head>

<body>
	<%@ include file="header.jsp"%>

	<div class="main-content">
		<div class="wrapper">

			<!-- user registration --->
			<section class="user-reg-box content-box">

				<form:form method="post" modelAttribute="patientHistoryForm"
					action="patientHistory">
					<h3>Search Patient Medical Records</h3>
					<table class="form-table">
						<tr>
							<td><form:label path="customerNumber">Patient ID:</form:label></td>
							<td><form:input path="customerNumber" /></td>
							<td><form:errors class="invalid" path="customerNumber" /></td>
						</tr>

						<tr>
							<td><form:label path="fromDate" id="fromDate" readonly='true'>From Date:</form:label></td>
							<td><form:input path="fromDate" /></td>
							<td><form:errors class="invalid" path="fromDate" /></td>
						</tr>
						<tr>
							<td><form:label path="toDate" id="toDate" readonly='true'>To Date:</form:label></td>
							<td><form:input path="toDate" /></td>
							<td><form:errors class="invalid" path="toDate" /></td>
						</tr>

						<tr>
							<td></td>
							<td colspan="2"><input type="submit" value="Search" /></td>
						</tr>
					</table>
				</form:form>
			</section>

		</div>
		<!-- end of wrapper -->
	</div>
	<!-- end of main content -->

	<%@ include file="footer.jsp"%>
</body>

</html>