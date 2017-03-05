<%-- 
    Document   : welcome
    Created on : Feb 23, 2017, 5:12:32 PM
    Author     : Shahnawaz Hossan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

        <title>Login Page</title>


        <script>

            function myfunction()
            {
                var data_true = 0;

                var sem = document.getElementById("usertype").value;

                if (sem == "0")
                {
                    document.getElementById("d").innerHTML = "Please Select a user type";
                    data_true = 1;


                } else {
                    document.getElementById("d").innerHTML = null;
                }

                var reg = document.getElementById("email").value;

                if (reg == "" || reg == null)
                {
                    document.getElementById("b").innerHTML = "Please Write your Email";
                    data_true = 1;

                } else {
                    document.getElementById("b").innerHTML = null;
                }

                var session = document.getElementById("password").value;

                if (session == "" || session == null)
                {
                    document.getElementById("e").innerHTML = "Please Write Your Password";
                    data_true = 1;

                } else {
                    document.getElementById("e").innerHTML = null;
                }

                if (data_true == 0)
                {
                    return true;

                } else
                {
                    return false;
                }
            }
        </script>

    </head>

    <body>

        <!-- Navigation Bar -->

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Login Area</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">

                    <li><a href="Registration.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>

                    <!--<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>-->

                </ul>
            </div>
        </nav>

        <div class="well"><center><h1>Welcome to Restaurant Billing System</h1></center>

        </div>

        <br><br>

    <center><h3>Please Fill up the Login Criteria</h3></center>

    <hr>

    <div class="col-lg-4">

    </div>

    <div class="well-lg col-lg-6">

        <form action="Controller" class="form-horizontal" onsubmit="return myfunction()" method="post">
            <!--            <div class="col-lg-12">
            
                        </div>-->

            <!--                            <script>
                                            $(document).ready(function () {
                                                $('[data-toggle="tooltip"]').tooltip();
                                            });
                                        </script>-->

            <div class="form-group">                                
                <label for="usertype" class="col-lg-2 control-label">Select User</label>
                <div class="col-lg-6">
                    <select class="form-control" id="usertype" name="usertype">
                        <option value="0">Select User</option>
                        <option value="1">Admin</option>
                        <option value="2">Customer</option>
                    </select>
                </div>
                <span style="color:red;"></span>
                <div class="col-lg-4">
                    <span id ="d" style="color: red;"> </span>
                </div>
            </div>


            <div class="form-group">
                <label for="email" class="col-lg-2 control-label" >Email</label>
                <div class="col-lg-6">
                    <input type="email" id="email"  class="form-control" placeholder="Write Your Email" name="email" data-toggle="tooltip" data-placement="top" title="Email">
                </div>
                <span style="color:red;"></span>
                <div class="col-lg-4">
                    <span id ="b" style="color: red;"> </span>
                </div>
            </div>

            <div class="form-group">
                <label  for="password" class="col-lg-2 control-label">Password</label>
                <div class="col-lg-6">
                    <input type="password" class="form-control" id="password" placeholder="Write Your Password" name="password">
                </div>
                <span style="color:red;"></span>
                <div class="col-lg-4">
                    <span id ="e" style="color: red;"> </span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                    <button type="submit" class="btn btn-info">Login</button>
                </div>
            </div>

        </form>
    </div>

    <!--        <footer class="footer ">
                <div class="text-center">
    
    <%@ page import="java.io.*,java.util.*" %>
    <%
        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
    %>
    <p class="text-muted">Copyright &COPY 2015 to <%=year%> <br>by Department Of CSE All rights reserved </p>

</div>

</footer>-->

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>