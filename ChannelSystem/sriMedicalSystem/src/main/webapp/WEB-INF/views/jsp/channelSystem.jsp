<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                    <li><a href="">Home</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="searchDoctor">Search Doctor</a></li>
                    <li><a href="#">Check Appointments</a></li>
                    <li><a href="#">Contact Us</a></li>
                </ul>
            </nav>
        </div>
    </header>

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
                                            <label>UserName: </label>
                                        </td>
                                        <td>
                                            <input type="text" name="userName" />
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
                                            New user? Register <a href="register">here</a>.
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </td>
                        <td>
                            <a href="register">
                                <img src="${images}/register_now.png" />
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


    <footer>
        <div class="wrapper">
            <p class="copyright">&copy; 2015 Sri Medicals. All rights reserved.</p>
        </div>
    </footer>

</body>

</html>
