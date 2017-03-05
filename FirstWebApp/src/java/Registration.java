/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shahnawaz Hossan
 */
@WebServlet(urlPatterns = {"/Registration"})
public class Registration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String name = request.getParameter("customer");

            request.setAttribute("customer", name);

            String email = request.getParameter("email");

            request.setAttribute("email", email);

            String address = request.getParameter("address");

            request.setAttribute("address", address);

            String password = request.getParameter("password");

            request.setAttribute("password", password);

            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingsystem", "root", "");

                boolean tag = false;

                String sql = "select * from members where email='" + email + "'";

                ResultSet rs = con.prepareStatement(sql).executeQuery();

                //out.println("" + email);
                while (rs.next()) {

                    String eml = rs.getString("email");

                    String pass = rs.getString("password");

                    if (email.equals(eml)) {

                        tag = true;

                        break;

                    }

                }

                if (tag) {

                    out.println("This Email alredy exists in Our Database.");

                } else {

                    sql = "insert into members values('" + name + "','" + email + "','" + address + "','" + password + "')";

                    con.prepareStatement(sql).execute();

                    out.println("Data are successfully inserted.");
                }

            } catch (Exception ex) {

                out.println("" + ex.getMessage());

            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
