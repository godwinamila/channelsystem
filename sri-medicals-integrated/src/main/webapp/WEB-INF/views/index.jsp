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

<%@ include file="header.jsp" %>
    <div class="main-content">
        <div class="wrapper">
<!-- Login box -->
            <section class="login-box content-box">

                <table style="width: 100%;">
                    <tr>
                        <td>
                            <form name="login-form">
                                <h3>Sign In</h3>
                                <table class="form-table">
                                    <tr>
                                        <td>
                                            <label>Email: </label>
                                        </td>
                                        <td>
                                            <input type="text" name="email" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Password: </label>
                                        </td>
                                        <td>
                                            <input type="password" name="password" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <input type="submit" value="Login" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="text-center">
                                            Forgot your password? Click <a href="#">here</a>.
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="text-center">
                                            New user? Register <a href="patient/register">here</a>.
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </td>
                        <td>
                            <a href="#">
                                <img src="<c:url value="/static/resources/images/register_now.png"/>" />
                            </a>
                        </td>
                    </tr>
                </table>

            </section>

  </div>
        <!-- end of wrapper -->
    </div>
    <!-- end of main content -->


<%@ include file="footer.jsp" %>
</body>
</html>