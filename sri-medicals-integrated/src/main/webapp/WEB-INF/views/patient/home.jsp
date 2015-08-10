<%--
  Created by IntelliJ IDEA.
  User: chamindah
  Date: 7/31/2015
  Time: 11:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
    <title>Sri Medicals</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/global.css"/>"/>
</head>
<body>

<%@ include file="../header.jsp" %>

    <div class="main-content">
        <div class="wrapper">
<section class="user-reg-box content-box">
  <h3>Register Patient</h3>

  <form:form commandName="newPatient" id="reg" name="reg-user-form">
    <table class="form-table">
	  <tr>
        <td><form:label path="title">Title:</form:label></td>
		<td><form:input path="title"/></td>
		<td><form:errors class="invalid" path="title"/></td>
      </tr>

      <tr>
        <td><form:label path="firstName">First Name:</form:label></td>
		<td><form:input path="firstName"/></td>
		<td><form:errors class="invalid" path="firstName"/></td>
      </tr>
	  <tr>
        <td><form:label path="lastName">Last Name:</form:label></td>
		<td><form:input path="lastName"/></td>
		<td><form:errors class="invalid" path="lastName"/></td>
      </tr>
	  <tr>
	    <td><form:label path="gender">Gender:</form:label></td>
		<td><form:input path="gender"/></td>
		<td><form:errors class="invalid" path="gender"/></td>
      </tr>
      <tr>
        <td><form:label path="nicNumber">NIC:</form:label></td>
		<td><form:input path="nicNumber"/></td>
		<td><form:errors class="invalid" path="nicNumber"/></td>
      </tr>
      <tr>
        <td><form:label path="email">E-mail:</form:label></td>
		<td><form:input path="email"/></td>
		<td><form:errors class="invalid" path="email"/></td>
      </tr>
      <tr>
	    <td><form:label path="mobile">Mobile:</form:label></td>
		<td><form:input path="mobile"/></td>
		<td><form:errors class="invalid" path="mobile"/></td>
      </tr>
	  <tr>
	    <td><form:label path="officeTele">Office Tel:</form:label></td>
		<td><form:input path="officeTele"/></td>
		<td><form:errors class="invalid" path="officeTele"/></td>
      </tr>
 	  <tr>
	    <td><form:label path="address">Address:</form:label></td>
		<td><form:input path="address"/></td>
		<td><form:errors class="invalid" path="address"/></td>
      </tr>

      <tr>
		<td></td>
		<td colspan="2">
			<input type="submit" value="Register"/>
			<input type="reset" value="Cancel"/>
		</td>
	</tr>

    </table>

 </form:form>
 <h2>Patients List</h2>
        <c:choose>
            <c:when test="${patients.size()==0}">
                <em>No registered patients.</em>
            </c:when>
            <c:otherwise>
                <table id="membersTable" class="simpletablestyle">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone #</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${patients}" var="patient">
                            <tr>
                                <td>${patient.patientId}</td>
                                <td>${patient.firstName}</td>
                                <td>${patient.email}</td>
                                <td>${patient.mobile}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>


</section>
        </div>
        <!-- end of wrapper -->
    </div>
    <!-- end of main content -->

<%@ include file="../footer.jsp" %>
</body>
</html>
