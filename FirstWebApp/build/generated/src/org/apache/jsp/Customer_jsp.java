package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Customer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <title>Customer</title>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Welcome Customer</a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                    <li><a href=\"Login.jsp\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <h2>We are glad to have you here</h2>\n");
      out.write("\n");
      out.write("            <ul class=\"nav nav-tabs\">\n");
      out.write("                <li class=\"active\"><a data-toggle=\"tab\" href=\"#home\">Your Profile</a></li>\n");
      out.write("                <li><a data-toggle=\"tab\" href=\"#menu1\">Food Items</a></li>\n");
      out.write("                <li><a data-toggle=\"tab\" href=\"#menu2\">Order Food</a></li>\n");
      out.write("                <li><a data-toggle=\"tab\" href=\"#menu3\">Your Order History</a></li>\n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("            <div class=\"tab-content\">\n");
      out.write("                <div id=\"home\" class=\"tab-pane fade in active\">\n");
      out.write("\n");
      out.write("                    <!-- Member's Profile -->\n");
      out.write("\n");
      out.write("                    ");

                        String name = "", email = "", address = "";

                        try {
                            String eml = request.getParameter("email");
                            
                            out.println(""+eml);

                            Class.forName("com.mysql.jdbc.Driver");
                            String sql = "select * from members where email='" + eml + "'";
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingsystem", "root", "");
                            ResultSet rs = con.prepareStatement(sql).executeQuery();


                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");
                        while (rs.next()) {


                    
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 name = rs.getString("name"); 
      out.write("\n");
      out.write("                    ");
 email = rs.getString("email"); 
      out.write("\n");
      out.write("                    ");
 address = rs.getString("address"); 
      out.write("\n");
      out.write("                    ");

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    
      out.write("\n");
      out.write("                    \n");
      out.write("                    <br><br><br>\n");
      out.write("\n");
      out.write("                    <form class=\"form-horizontal\">\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label col-sm-2\" for=\"name\">Name</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"name\" value=\"");
      out.print(name);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label col-sm-2\" for=\"email\">Email</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input type=\"email\" class=\"form-control\" id=\"email\" value=\"");
      out.print(email);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label col-sm-2\" for=\"address\">Address</label>\n");
      out.write("                            <div class=\"col-sm-10\"> \n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"address\" value=\"");
      out.print(address);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div id=\"menu1\" class=\"tab-pane fade\">\n");
      out.write("\n");
      out.write("                    <div class=\"container\">              \n");
      out.write("                        <table class=\"table table-striped\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Product Code</th>\n");
      out.write("                                    <th>Product Category</th>\n");
      out.write("                                    <th>Product Name</th>\n");
      out.write("                                    <th>Product Price</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("\n");
      out.write("                                ");
                                    try {
                                        Class.forName("com.mysql.jdbc.Driver");
                                        String sql = "select * from details";
                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingsystem", "root", "");
                                        ResultSet rs = con.prepareStatement(sql).executeQuery();

                                
      out.write("\n");
      out.write("\n");
      out.write("                                ");
                                    while (rs.next()) {

                                
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>");
      out.print(rs.getString("code"));
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(rs.getString("name"));
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(rs.getString("catagory"));
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(rs.getString("price"));
      out.write("</td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");

                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                
      out.write("\n");
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div id=\"menu2\" class=\"tab-pane fade\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div id=\"menu3\" class=\"tab-pane fade\">\n");
      out.write("\n");
      out.write("                    <div class=\"container\">              \n");
      out.write("                        <table class=\"table table-striped\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Email</th>\n");
      out.write("                                    <th>Product ID</th>\n");
      out.write("                                    <th>Total Amount</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("\n");
      out.write("                                ");

                                    try {
                                        Class.forName("com.mysql.jdbc.Driver");
                                        String sql = "select * from takeorder";
                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingsystem", "root", "");
                                        ResultSet rs = con.prepareStatement(sql).executeQuery();

                                
      out.write("\n");
      out.write("\n");
      out.write("                                ");
                                    while (rs.next()) {

                                
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>");
      out.print(rs.getString("email"));
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(rs.getString("id"));
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(rs.getString("total"));
      out.write("</td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");

                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                
      out.write("\n");
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
