<%--
  Created by IntelliJ IDEA.
  User: chamindah
  Date: 7/31/2015
  Time: 11:41 PM
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

        <!-- user registration --->
        <section class="user-reg-box content-box">
        
        	<h3>Patient Treatment</h3>
           
            <form:form method="post" modelAttribute="treatment" action="newTreatment">
                <table class="form-table">
                    <tr>
                        <td><form:hidden path="medicalInfoId" /></td>
                        <td><form:hidden path="patientNumber"/></td>
                        <td><form:hidden path="doctorNumber"/></td>
                        <td><form:hidden path="channelId"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="diagonasisInfo">Diagnosis:</form:label></td>
                        <td><form:textarea path="diagonasisInfo"/></td>
                        <td><form:errors class="invalid" path="diagonasisInfo"/></td>
                    </tr>

                    <tr>
                        <td><form:label path="prescriptionInfo">Prescription:</form:label></td>
                        <td><form:textarea path="prescriptionInfo"/></td>
                        <td><form:errors class="invalid" path="prescriptionInfo"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2">
                            <input type="submit" value="Save Treatment"/>
                        </td>
                    </tr>
                </table>
            </form:form>
        </section>

    </div>
    <!-- end of wrapper -->
</div>
<!-- end of main content -->

<%@ include file="footer.jsp" %>
</body>

</html>

