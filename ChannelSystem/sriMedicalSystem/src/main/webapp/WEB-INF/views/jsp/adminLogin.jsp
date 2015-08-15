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
                            <form:form method="post" modelAttribute="loginForm" action="adminLogin">
                                <h3>Administrator Sign In</h3>

                                <table class="form-table">
                                    <tr> <td class="has-error">${error}<c:out value="${error}"/></td></tr>
                                    <tr>
                                        <td><form:label path="userName">User Name:</form:label></td>
                                        <td><form:input path="userName"/></td>
                                        <td><form:errors class="invalid" path="userName"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:label path="password">Password:</form:label></td>
                                        <td><form:input path="password"/></td>
                                        <td><form:errors class="invalid" path="password"/></td>
                                    </tr>
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