/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shahnawaz Hossan
 */
@WebServlet(urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String _type = request.getParameter("usertype");

            int user_num = Integer.parseInt(_type);

            String _username = request.getParameter("email");

            request.setAttribute("email", _username);

            String _password = request.getParameter("password");

            request.setAttribute("password", _password);

            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingsystem", "root", "");

                boolean tag = false;

                if (user_num == 1) {

                    String sql = "select * from admin where email='" + _username + "' and password='" + _password + "'";

                    ResultSet rs = con.prepareStatement(sql).executeQuery();

                    out.println("" + _username);

                    while (rs.next()) {

                        String email = rs.getString("email");

                        String pass = rs.getString("password");

                        if (email.equals(_username) && pass.equals(_password)) {

                            tag = true;

                            break;

                        }

                    }

                    if (tag) {

                        response.sendRedirect("Admin.jsp");

                    } else {

                        out.println("<center><h1>Sorry , I can't recognize you!!!</h1></center>");

                    }

                } else if (user_num == 2) {

                    String sql = "select * from members where email='" + _username + "' and password='" + _password + "'";

                    ResultSet rs = con.prepareStatement(sql).executeQuery();

                    //out.println("" + _username);
                    String email = "", pass = "";

                    while (rs.next()) {

                        email = rs.getString("email");

                        pass = rs.getString("password");

                        if (email.equals(_username) && pass.equals(_password)) {

                            tag = true;

                            request.setAttribute("storeEmail", email);

                            request.getRequestDispatcher("Customer.jsp").forward(request, response);

                            response.sendRedirect("Customer.jsp");

                            break;

                        }

                    }

                    if (!tag) {

                        out.println("<center><h1>Sorry , I can't recognize you!!!</h1></center>");

                    }
                }

            } catch (Exception ex) {

                out.print("" + ex.getMessage());

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
