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
				<h3>Patient Medical Records</h3>
				<table class="tab-alt">
					<tr>
						<td>Patient ID:</td>
						<td>${patientId}</td>
					</tr>
					<tr>
						<td>Patient Name:</td>
						<td>${patientName}</td>
					</tr>
				</table>
				<table class="tab-doc-search-res tab-alt">
					<thead>
						<tr>
							<th>Channel ID</th>
							<th>Channel Date</th>
							<th>Doctor Name</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty medicalRecordslist}">
							<tr>
								<c:forEach var="listValue" items="${medicalRecordslist}">
									<td>${listValue.channelId}</td>
									<td>${listValue.createDate}</td>
									<td>${listValue.doctorNumber}</td>
									<td><a href="viewMedicalRecord?id=${listValue.medicalInfoId}">View Details</a></td>
								</c:forEach>
							</tr>

						</c:if>
						<c:if test="${empty medicalRecordslist}">
							<tr>
								<td>No records found</td>
						
							</tr>

						</c:if>
					</tbody>
				</table>

			</section>


		</div>
		<!-- end of wrapper -->
	</div>
	<!-- end of main content -->
	<%@include file="footer.jsp"%>

</body>

</html>
