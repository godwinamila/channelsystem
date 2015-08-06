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
           
            <form:form method="post" modelAttribute="registerForm" action="register">
                <h3>Register User</h3>
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
                        <td><form:label path="idCardNumber">NIC:</form:label></td>
                        <td><form:input path="idCardNumber"/></td>
                        <td><form:errors class="invalid" path="idCardNumber"/></td>
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

