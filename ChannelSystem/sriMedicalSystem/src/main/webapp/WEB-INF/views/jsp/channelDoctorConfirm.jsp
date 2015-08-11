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

        <!-- doctor search - channel -->
        <section class="search-doc-channel-box content-box">
            <h3>Channel Doctor</h3>

            <form:form method="post" modelAttribute="channelForm" action="channelDoctorConfirm">
                <table class="form-table">
                    <tr>
                        <td colspan="2">
                            <h4>Doctor Details</h4>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="doctorName">Doctor Name:</form:label></td>
                        <td><form:hidden path="doctorName"/>${channelForm.doctorName}</td>
                    </tr>
                    <tr>
                        <td><form:label path="speciality">Specialty:</form:label></td>
                        <td><form:hidden path="speciality"/>${channelForm.speciality}</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <h4>Patient Details</h4>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="patientName">Patient Name:</form:label></td>
                        <td><form:hidden path="patientName"/>${channelForm.patientName}</td>
                    </tr>
                    <tr>
                        <td><form:label path="nicNumber">NIC No:</form:label></td>
                        <td><form:hidden path="nicNumber"/>${channelForm.nicNumber}</td>
                    </tr>
                    <tr>
                        <td><form:label path="telePhone">Telephone:</form:label></td>
                        <td><form:hidden path="telePhone"/>${channelForm.telePhone}</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <h4>Appointment Details</h4>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="channelDate">Date:</form:label></td>
                        <td><form:hidden path="channelDate"/>${channelForm.channelDate}</td>
                    </tr>
                    <tr>
                        <td><form:label path="timeSlot">Time:</form:label></td>
                        <td><form:hidden path="timeSlot"/>${channelForm.timeSlot}</td>
                    </tr>
                    <tr>
                        <td><form:label path="appntNumber">Appointment No:</form:label></td>
                        <td><form:hidden path="appntNumber"/>${channelForm.appntNumber}</td>
                    </tr>
                    <tr>
                        <td><form:label path="roomNo">Room No:</form:label></td>
                        <td><form:hidden path="roomNo"/>${channelForm.roomNo}</td>
                        <form:hidden path="doctorNumber"/>
                        <form:hidden path="customerNumber"/>
                        <form:hidden path="channelSheId"/>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Confirm"/>
                        </td>
                    </tr>
                </table>
            </form:form>

        </section>


    </div>
    <!-- end of wrapper -->
</div>
<!-- end of main content -->
<%@include file="footer.jsp"%>

</body>

</html>
