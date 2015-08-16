<%--
  Created by IntelliJ IDEA.
  User: chamindah
  Date: 8/1/2015
  Time: 12:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

			<!-- doctor search -->
			<section class="search-doc-box content-box">
				<h3>Patient Medical Record Details</h3>
				<table class="tab-alt">
					<tr>
						<td>Patient ID:</td>
						<td>${medicalRecord.patientNumber}</td>
					</tr>
					<tr>
						<td>Patient Name:</td>
						<td>{patientName}</td>
					</tr>
					<tr>
						<td>Channel Date:</td>
						<td>${medicalRecord.createDate}</td>
					</tr>
					<tr>
						<td>Doctor Name:</td>
						<td>${docName}</td>
					</tr>
					<tr>
						<td>Diagnosis:</td>
						<td>${medicalRecord.diagonasisInfo}</td>
					</tr>
					<tr>
						<td>Prescription:</td>
						<td>${medicalRecord.prescriptionInfo}</td>
					</tr>
				</table>
			</section>


		</div>
		<!-- end of wrapper -->
	</div>
	<!-- end of main content -->
	<%@include file="footer.jsp"%>

</body>

</html>
