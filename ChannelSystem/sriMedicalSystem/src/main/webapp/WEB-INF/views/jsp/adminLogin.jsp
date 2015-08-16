<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Sri Medicals</title>
    <spring:url value="/resources/core/css/global.css" var="coreCss" />
    <spring:url value="/resources/core/images" var="images" />
    <link href="${coreCss}" rel="stylesheet" />
</head>

<body>
<%@ include file="header.jsp" %>

    <div class="main-content">
        <div class="wrapper">
            <!-- Login box -->
            <section class="login-box content-box">

                <table style="width: 100%;">
                    <tr>
                        <td>
                            <form:form method="post" modelAttribute="userTypeForm" action="selectUser">
                                <h3>Doctor/Staff Sign In</h3>

                                <br>Please select the user type <br>
                                <table class="form-table">
                                    <td><form:label path="userType">User Type</form:label></td>
                                    <td><form:select path="userType">
                                            <form:option value="Doctor"></form:option>
                                            <form:option value="Staff"></form:option>
                                        </form:select>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <input type="submit" value="Login" />
                                        </td>
                                    </tr>
                                </table>
                            </form:form>
                        </td>
                        <td>
                            <a href="#">
                                <img src="${images}/adminlogin.jpg" />
                            </a>
                        </td>
                    </tr>
                </table>
            </section>
            <!-- user registration --->


        </div>
        <!-- end of wrapper -->
    </div>
    <!-- end of main content -->

    <%@ include file="footer.jsp" %>

</body>

</html>