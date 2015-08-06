<%--
  Created by IntelliJ IDEA.
  User: chamindah
  Date: 8/1/2015
  Time: 12:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Sri Medicals</title>
    <spring:url value="/resources/core/css/global.css" var="coreCss"/>
    <link href="${coreCss}" rel="stylesheet"/>
</head>

<body>
<%@ include file="header.jsp" %>

<div class="main-content">
<div class="wrapper">

<!-- doctor search -->
<section class="search-doc-box content-box">
<h3>Search Doctor</h3>

<form:form method="post" modelAttribute="searchDocForm" action="searchDoctor">
    <table class="form-table">
    <tr>
    <td><form:label path="lastName">Last Name:</form:label></td>
    <td><form:input path="lastName"/></td>
    <td><form:errors class="invalid" path="lastName"/></td>
    </tr>
    <tr>

    <td><form:label path="speciality">Speciality:</form:label></td>
    <td><form:select path="speciality">
    <form:option value="Physician"></form:option>
    <form:option value="Surgon"></form:option>
</form:select>
    </td>

    </tr>
    <tr>
    <td></td>
    <td>
    <input type="submit" value="Search..." />
    </td>
    </tr>
    </table>
    </form:form >


    </section>


    </div>
    <!-- end of wrapper -->
    </div>
    <!-- end of main content -->

    <%@ include file="footer.jsp" %>
    </body>

    </html>
