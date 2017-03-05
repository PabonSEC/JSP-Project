<%-- 
    Document   : Registration
    Created on : Feb 26, 2017, 1:04:59 AM
    Author     : Shahnawaz Hossan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <script>

            function myfunction()
            {
                var data_true = 0;

                var name = document.getElementById("customer").value;

                if (name == "")
                {
                    document.getElementById("b").innerHTML = "Write Your Name Please";
                    data_true = 1;


                } else {
                    document.getElementById("b").innerHTML = null;
                }

                var email = document.getElementById("email").value;

                if (email == "")
                {
                    document.getElementById("c").innerHTML = "Write your Email Please";
                    data_true = 1;

                } else {
                    document.getElementById("c").innerHTML = null;
                }

                var address = document.getElementById("address").value;

                if (address == "")
                {
                    document.getElementById("d").innerHTML = "Write Your Address Please";
                    data_true = 1;

                } else {
                    document.getElementById("d").innerHTML = null;
                }

                var password = document.getElementById("password").value;

                if (password == "")
                {
                    document.getElementById("e").innerHTML = "Write Your Password Please";
                    data_true = 1;

                } else {
                    document.getElementById("e").innerHTML = null;
                }

                var repassword = document.getElementById("confirm").value;

                if (password != repassword)
                {
                    document.getElementById("f").innerHTML = "Password doesn't match";
                    data_true = 1;

                } else {
                    document.getElementById("f").innerHTML = null;
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

        <style>

            .pp{
                color:#4F8A10;
            }
            .xx{
                color:#D8000C;
            }

        </style>


    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Registration Form</a>
                </div>

                <ul class="nav navbar-nav navbar-right">

                    <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>

                </ul>
            </div>
        </nav>

    <center><h3>Please Complete Your Registration Process</h3></center>

    <br>

    <hr>

    <!--This is the form -->

    <section>

        <div class="container">

            <div class="col-lg-12">

                <div >
                    <div class="col-lg-3">

                    </div>
                    <div class="col-lg-1">
                        <div class="img-responsive">
                            <img src="image/SignUp.jpg" />
                        </div>  
                    </div>
                    <div class="col-lg-8">
                        <h1>Sign Up</h1>
                    </div>
                </div>

                <br><br>
                <br><br>
                <br><br>

                <form action="Registration" onsubmit="return myfunction()" method="POST" class="form-horizontal">

                    <!-- Enter Name -->

                    <div class="form-group">
                        <label for="customer" class="col-lg-3 control-label"><span class="glyphicon glyphicon-user"></span> Name</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" name="customer" id="customer" placeholder="Write Your Name">
                        </div>
                        <span style="color:red;"></span>
                        <div class="col-lg-4">
                            <span id ="b" style="color: red;"> </span>
                        </div>
                    </div>


                    <!-- Enter Email -->

                    <div class="form-group">
                        <label for="email" class="col-lg-3 control-label"><span class="glyphicon glyphicon-envelope"></span> Email</label>
                        <div class="col-lg-5">
                            <input type="email" class="form-control" name="email" id="email" placeholder="Write Your Email">
                        </div>
                        <span style="color:red;"></span>
                        <div class="col-lg-4">
                            <span id ="c" style="color: red;"> </span>
                        </div>
                    </div>

                    <!-- Enter Address -->

                    <div class="form-group">
                        <label for="address" class="col-lg-3 control-label"><span class="glyphicon glyphicon-home"></span> Address</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" name="address" id="address" placeholder="Write Your Address">
                        </div>
                        <span style="color:red;"></span>
                        <div class="col-lg-4">
                            <span id ="d" style="color: red;"> </span>
                        </div>
                    </div>

                    <!-- script of confirm password -->

                    <script>

                        function confirmPassword(str) {
                            var x = document.getElementById("password").value;

                            if (x == str)
                            {
                                document.getElementById("pabon").className = "glyphicon glyphicon-ok-sign form-control-feedback pp";
                            } else {
                                document.getElementById("pabon").className = "danger glyphicon glyphicon-remove-sign form-control-feedback xx";
                            }
                        }
                    </script>

                    <!-- Enter Password -->

                    <div class="form-group">
                        <label for="password" class="col-lg-3 control-label"><span class="glyphicon glyphicon-lock"></span> Password</label>
                        <div class="col-lg-5">
                            <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                        </div>
                        <span style="color:red;"></span>
                        <div class="col-lg-4">
                            <span id ="e" style="color: red;"> </span>
                        </div>
                    </div>

                    <!-- Confirm Password -->

                    <div class="form-group">
                        <label for="confirm" class="col-lg-3 control-label"><span class="glyphicon glyphicon-lock"></span> Confirm</label>
                        <div class="col-lg-5 has-feedback">

                            <input type="password" class="form-control" name="confirm" id="confirm" onkeyup="confirmPassword(this.value)" placeholder="Confirm Password">

                            <span id="pabon"></span>

                        </div>
                        <span style="color:red;"></span>
                        <div class="col-lg-4">
                            <span id ="f" style="color: red;"> </span>
                        </div>
                    </div>

                    <!-- Sign Up Button -->

                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-5">
                            <button type="submit" class="btn btn-primary">Sign Up</button>
                        </div>
                    </div>

                </form>

            </div>

        </div>

    </section>

    <!-- End of the form -->

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body>
</html>
