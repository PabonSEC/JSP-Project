<%-- 
    Document   : Admin
    Created on : Feb 26, 2017, 10:11:42 PM
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

        <title>Admin</title>

        <script>

            function myfunction()
            {
                var data_true = 0;

                var cd = document.getElementById("pCode").value;

                if (cd == "")
                {
                    document.getElementById("b").innerHTML = "Write Product Code";
                    data_true = 1;


                } else {
                    document.getElementById("b").innerHTML = null;
                }

                var pnm = document.getElementById("pName").value;

                if (pnm == "")
                {
                    document.getElementById("c").innerHTML = "Write Product Name";
                    data_true = 1;

                } else {
                    document.getElementById("c").innerHTML = null;
                }

                var cat = document.getElementById("pCat").value;

                if (cat == "")
                {
                    document.getElementById("d").innerHTML = "Write Product Category";
                    data_true = 1;

                } else {
                    document.getElementById("d").innerHTML = null;
                }

                var price = document.getElementById("pPrice").value;

                if (price == "")
                {
                    document.getElementById("e").innerHTML = "Write Product Price";
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

        <script>
            function removeOrder()
            {
                var data_true = 0;

                var cd = document.getElementById("eml").value;

                if (cd == "")
                {
                    document.getElementById("f").innerHTML = "Write Customer's Email Please";
                    data_true = 1;


                } else {
                    document.getElementById("f").innerHTML = null;
                }

                if (data_true == 0)
                {
                    return true;
                } else {

                    return false;
                }
            }
        </script>

    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Administration Panel</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                </ul>
            </div>
        </nav>

        <div class="container">

            <h2>Restricted Area</h2>

            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">Customers' List</a></li>
                <li><a data-toggle="tab" href="#menu1">Food Item</a></li>
                <li><a data-toggle="tab" href="#menu2">Manage List</a></li>
                <li><a data-toggle="tab" href="#menu3">Order History</a></li>
                <li><a data-toggle="tab" href="#menu4">Remove Order</a></li>
            </ul>

            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">

                    <!-- Member's Table -->

                    <div class="container">              
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                    <th>Password</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%
                                    try {
                                        Class.forName("com.mysql.jdbc.Driver");
                                        String sql = "select * from members";
                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingsystem", "root", "");
                                        ResultSet rs = con.prepareStatement(sql).executeQuery();

                                %>

                                <%                                    while (rs.next()) {

                                %>
                                <tr>
                                    <td><%=rs.getString("name")%></td>
                                    <td><%=rs.getString("email")%></td>
                                    <td><%=rs.getString("address")%></td>
                                    <td><%=rs.getString("password")%></td>
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

                <div id="menu1" class="tab-pane fade">

                    <!-- Food List -->

                    <div class="container">              
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Product Code</th>
                                    <th>Product Name</th>
                                    <th>Product Category</th>
                                    <th>Product Price</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%
                                    try {
                                        Class.forName("com.mysql.jdbc.Driver");
                                        String sql = "select * from details";
                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingsystem", "root", "");
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

                <div id="menu2" class="tab-pane fade">

                    <!-- Manage Product -->

                    <hr>
                    <br>

                    <form action="ManageProduct" onsubmit="return myfunction()" method="post" class="form-horizontal">

                        <div class="form-group">
                            <label for="pCode" class="col-lg-2 control-label">Product Code</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" name="pCode" id="pCode" placeholder="Write Product Code">
                            </div>
                            <span style="color:red;"></span>
                            <div class="col-lg-6">
                                <span id ="b" style="color: red;"> </span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="pName" class="col-lg-2 control-label">Product Name</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" name="pName" id="pName" placeholder="Write Product Name">
                            </div>
                            <span style="color:red;"></span>
                            <div class="col-lg-6">
                                <span id ="c" style="color: red;"> </span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="pCat" class="col-lg-2 control-label">Product Category</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" name="pCat" id="pCat" placeholder="Write Product Category">
                            </div>
                            <span style="color:red;"></span>
                            <div class="col-lg-6">
                                <span id ="d" style="color: red;"> </span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="pPrice" class="col-lg-2 control-label">Product Price</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" name="pPrice" id="pPrice" placeholder="Write Product Price">
                            </div>
                            <span style="color:red;"></span>
                            <div class="col-lg-6">
                                <span id ="e" style="color: red;"> </span>
                            </div>
                        </div>

                        <br>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-4">
                                <button type="submit" class="btn btn-primary" name="act" value="add">Add Product</button>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-4">
                                <button type="submit" class="btn btn-danger" name="act" value="del">Delete Product</button>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-4">
                                <button type="submit" class="btn btn-success" name="act" value="updt">Update Product</button>
                            </div>
                        </div>

                    </form>
                </div>


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
                                        String sql = "select * from takeorder";
                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingsystem", "root", "");
                                        ResultSet rs = con.prepareStatement(sql).executeQuery();

                                %>

                                <%                                    while (rs.next()) {

                                %>
                                <tr>
                                    <td><%=rs.getString("email")%></td>
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


                <div id="menu4" class="tab-pane fade">

                    <hr>

                    <form action="RemoveOrder" onsubmit="return removeOrder()" method="post" class="form-horizontal">

                        <div class="form-group">
                            <label for="eml" class="col-lg-2 control-label">Customer's Email</label>
                            <div class="col-lg-4">
                                <input type="email" class="form-control" name="eml" id="eml" placeholder="Write Customer's Email">
                            </div>
                            <span style="color:red;"></span>
                            <div class="col-lg-6">
                                <span id ="f" style="color: red;"> </span>
                            </div>
                        </div>

                        <br>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-4">
                                <button type="submit" class="btn btn-warning" name="gt" value="del">Remove Order</button>
                            </div>
                        </div>

                    </form>
                </div>

            </div>
        </div>


    </body>
</html>
