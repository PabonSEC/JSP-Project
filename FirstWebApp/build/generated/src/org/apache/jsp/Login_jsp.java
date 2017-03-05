package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <title>Login Page</title>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            function myfunction()\n");
      out.write("            {\n");
      out.write("                var data_true = 0;\n");
      out.write("\n");
      out.write("                var sem = document.getElementById(\"usertype\").value;\n");
      out.write("\n");
      out.write("                if (sem == \"0\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"d\").innerHTML = \"Please Select a user type\";\n");
      out.write("                    data_true = 1;\n");
      out.write("\n");
      out.write("\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById(\"d\").innerHTML = null;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                var reg = document.getElementById(\"email\").value;\n");
      out.write("\n");
      out.write("                if (reg == \"\" || reg == null)\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"b\").innerHTML = \"Please Write your Email\";\n");
      out.write("                    data_true = 1;\n");
      out.write("\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById(\"b\").innerHTML = null;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                var session = document.getElementById(\"password\").value;\n");
      out.write("\n");
      out.write("                if (session == \"\" || session == null)\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"e\").innerHTML = \"Please Write Your Password\";\n");
      out.write("                    data_true = 1;\n");
      out.write("\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById(\"e\").innerHTML = null;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                if (data_true == 0)\n");
      out.write("                {\n");
      out.write("                    return true;\n");
      out.write("\n");
      out.write("                } else\n");
      out.write("                {\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- Navigation Bar -->\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Login Area</a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"nav navbar-nav\">\n");
      out.write("                    <li class=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("\n");
      out.write("                    <li><a href=\"Registration.jsp\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>\n");
      out.write("\n");
      out.write("                    <!--<li><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>-->\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"well\"><center><h1>Welcome to Restaurant Billing System</h1></center>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <br><br>\n");
      out.write("\n");
      out.write("    <center><h3>Please Fill up the Login Criteria</h3></center>\n");
      out.write("\n");
      out.write("    <hr>\n");
      out.write("\n");
      out.write("    <div class=\"col-lg-4\">\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"well-lg col-lg-6\">\n");
      out.write("\n");
      out.write("        <form action=\"Controller\" class=\"form-horizontal\" onsubmit=\"return myfunction()\" method=\"post\">\n");
      out.write("            <!--            <div class=\"col-lg-12\">\n");
      out.write("            \n");
      out.write("                        </div>-->\n");
      out.write("\n");
      out.write("            <!--                            <script>\n");
      out.write("                                            $(document).ready(function () {\n");
      out.write("                                                $('[data-toggle=\"tooltip\"]').tooltip();\n");
      out.write("                                            });\n");
      out.write("                                        </script>-->\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">                                \n");
      out.write("                <label for=\"usertype\" class=\"col-lg-2 control-label\">Select User</label>\n");
      out.write("                <div class=\"col-lg-6\">\n");
      out.write("                    <select class=\"form-control\" id=\"usertype\" name=\"usertype\">\n");
      out.write("                        <option value=\"0\">Select User</option>\n");
      out.write("                        <option value=\"1\">Admin</option>\n");
      out.write("                        <option value=\"2\">Customer</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                <span style=\"color:red;\"></span>\n");
      out.write("                <div class=\"col-lg-4\">\n");
      out.write("                    <span id =\"d\" style=\"color: red;\"> </span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"email\" class=\"col-lg-2 control-label\" >Email</label>\n");
      out.write("                <div class=\"col-lg-6\">\n");
      out.write("                    <input type=\"email\" id=\"email\"  class=\"form-control\" placeholder=\"Write Your Email\" name=\"email\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Email\">\n");
      out.write("                </div>\n");
      out.write("                <span style=\"color:red;\"></span>\n");
      out.write("                <div class=\"col-lg-4\">\n");
      out.write("                    <span id =\"b\" style=\"color: red;\"> </span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label  for=\"password\" class=\"col-lg-2 control-label\">Password</label>\n");
      out.write("                <div class=\"col-lg-6\">\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"password\" placeholder=\"Write Your Password\" name=\"password\">\n");
      out.write("                </div>\n");
      out.write("                <span style=\"color:red;\"></span>\n");
      out.write("                <div class=\"col-lg-4\">\n");
      out.write("                    <span id =\"e\" style=\"color: red;\"> </span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-offset-2 col-sm-5\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-info\">Login</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!--        <footer class=\"footer \">\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    ");

        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
    
      out.write("\n");
      out.write("    <p class=\"text-muted\">Copyright &COPY 2015 to ");
      out.print(year);
      out.write(" <br>by Department Of CSE All rights reserved </p>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</footer>-->\n");
      out.write("\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
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
