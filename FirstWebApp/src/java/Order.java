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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shahnawaz Hossan
 */
@WebServlet(urlPatterns = {"/Order"})
public class Order extends HttpServlet {

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

            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingsystem", "root", "");

                boolean tag = false, tag1 = false;

                String code = request.getParameter("code");

                HttpSession sessionsa = request.getSession(false);

                String eml = (String) sessionsa.getAttribute("storeEmail");

                request.setAttribute("code", code);

                String s = request.getParameter("quantity");

                int quantity = Integer.parseInt(s);

                String sql = "select * from details where code='" + code + "'";

                ResultSet rs = con.prepareStatement(sql).executeQuery();

                String cd = "", name = "", tot = "";

                int total;

                while (rs.next()) {

                    cd = rs.getString("code");

                    name = rs.getString("name");

                    total = Integer.parseInt(rs.getString("price"));

                    total *= quantity;

                    tot = Integer.toString(total);

                    if (quantity >= 1) {

                        tag1 = true;
                    }

                    if (code.equals(cd)) {

                        tag = true;

                        break;

                    }

                }

                if (tag && tag1) {

                    request.setAttribute("storeCode", cd);

                    request.setAttribute("storeTot", tot);

                    request.setAttribute("storeEmail", eml);

                    sql = "insert into takeorder values('" + eml + "','" + cd + "','" + tot + "')";

                    con.prepareStatement(sql).execute();

                    request.getRequestDispatcher("Customer.jsp").forward(request, response);

                    response.sendRedirect("Customer.jsp");

                } else if (tag1 == false) {

                    out.println("<center><h1>Please Order at least one Product.</h1></center>");

                } else {

                    out.println("<center><h1>The Product Id is invalid</h1></center>");

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
