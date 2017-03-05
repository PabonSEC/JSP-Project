<%-- 
    Document   : Customer
    Created on : Feb 26, 2017, 11:56:35 PM
    Author     : Shahnawaz Hossan
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>Customer</title>

        <script>

            function myfunction()
            {
                var data_true = 0;

                var code = document.getElementById("code").value;

                if (code == "")
                {
                    document.getElementById("b").innerHTML = "Please Write a Product Code";
                    data_true = 1;


                } else {
                    document.getElementById("b").innerHTML = null;
                }

                var quantity = document.getElementById("quantity").value;

                if (quantity == "")
                {
                    document.getElementById("c").innerHTML = "Please Write Product Quantity";
                    data_true = 1;


                } else {
                    document.getElementById("c").innerHTML = null;
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

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Welcome Customer</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                </ul>
            </div>
        </nav>

        <div class="container">

            <h2>We are glad to have you here</h2>

            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">Your Profile</a></li>
                <li><a data-toggle="tab" href="#menu1">Food Items</a></li>
                <li><a data-toggle="tab" href="#menu2">Order Food</a></li>
                <li><a data-toggle="tab" href="#menu3">Your Order History</a></li>
            </ul>

            <div class="tab-content">

                <!-- Home Tab  -->

                <div id="home" class="tab-pane fade in active">
                    <hr>

                    <!-- Member's Profile -->

                    <div>
                        <img src="image/Profile.jpg">
                    </div>

                    <form action="Order" method="post" class="form-horizontal">

                        <%
                            String name = "", email = "", address = "", eml = "";

                            try {
                                eml = (String) request.getAttribute("storeEmail");

                                session.setAttribute("storeEmail", eml);

                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingsystem", "root", "");
                                String sql = "select * from members where email='" + eml + "'";

                                ResultSet rs = con.prepareStatement(sql).executeQuery();

                                while (rs.next()) {

                        %>

                        <% name = rs.getString("name"); %>
                        <% email = rs.getString("email"); %>
                        <% address = rs.getString("address"); %>
                        <%
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        %>

                        <br>
                        <div class="form-group">
                            <label class="control-label col-sm-1" for="name">Name</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="name" value="<%=name%>" disabled>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-1" for="email">Email</label>
                            <div class="col-sm-4">
                                <input type="email" class="form-control" id="email" value="<%=email%>" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-1" for="address">Address</label>
                            <div class="col-sm-4"> 
                                <input type="text" class="form-control" id="address" value="<%=address%>" disabled>
                            </div>
                        </div>

                    </form>

                </div>

                <!-- Food Item  -->           

                <div id="menu1" class="tab-pane fade">

                    <div class="container">              
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Product Code</th>
                                    <th>Product Category</th>
                                    <th>Product Name</th>
                                    <th>Product Price</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%                                    try {
                                        Class.forName("com.mysql.jdbc.Driver");
                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingsystem", "root", "");

                                        String sql = "select * from details";
                                        ResultSet rs = con.prepareStatement(sql).executeQuery();

                                %>

                                <%                                    while (rs.next()) {

                                %>
                                <tr>
                                    <td><%=rs.getString("code")%></td>
                                    <td><%=rs.getString("name")%></td>
                                    <td><%=rs.getString("catagory")%></td>
                                    <td><%=rs.getString("price")%></td>
                                </tr>
                                <%
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                %>

                            </tbody>
                        </table>
                    </div>

                </div>

                <!-- Order Food  -->                

                <div id="menu2" class="tab-pane fade">

                    <hr>
                    <br>

                    <form action="Order" onsubmit="return myfunction()" method="POST" class="form-horizontal">

                        <div class="form-group">
                            <label for="email1" class="col-lg-2 control-label">Your Email</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" name="email1" id="email1" value="<%=eml%>" disabled>
                            </div>
                        </div>


                        <!-- Enter Product Code -->


                        <div class="form-group">
                            <label for="code" class="col-lg-2 control-label">Product Code</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" name="code" id="code" placeholder="Write Correct Product Code">
                            </div>
                            <span style="color:red;"></span>
                            <div class="col-lg-4">
                                <span id ="b" style="color: red;"> </span>
                            </div>
                        </div>

                        <!-- Enter Product Code -->

                        <div class="form-group">
                            <label for="quantity" class="col-lg-2 control-label">Product Quantity</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" name="quantity" id="quantity" placeholder="Write Quantity of Product">
                            </div>
                            <span style="color:red;"></span>
                            <div class="col-lg-4">
                                <span id ="c" style="color: red;"> </span>
                            </div>
                        </div>                     

                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-5">
                                <button type="submit" class="btn btn-success">Press To Order</button>
                            </div>
                        </div>

                    </form>

                </div>


                <!-- Order History  -->    

                <div id="menu3" class="tab-pane fade">

                    <div class="container">              
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Email</th>
                                    <th>Product ID</th>
                                    <th>Total Amount</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%
                                    try {
                                        Class.forName("com.mysql.jdbc.Driver");

                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingsystem", "root", "");

                                        String sql = "select * from takeorder where email='" + eml + "'";

                                        ResultSet rs = con.prepareStatement(sql).executeQuery();

                                        while (rs.next()) {


                                %>

                                <tr>
                                    <td><%=eml%></td>
                                    <td><%=rs.getString("id")%></td>
                                    <td><%=rs.getString("total")%></td>
                                </tr>

                                <%
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                %>

                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>

    </body>
</html>
