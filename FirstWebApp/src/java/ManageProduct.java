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
@WebServlet(urlPatterns = {"/AddProduct"})
public class ManageProduct extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String act = request.getParameter("act");

            String code = request.getParameter("pCode");

            String name = request.getParameter("pName");

            String category = request.getParameter("pCat");

            String price = request.getParameter("pPrice");

            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingsystem", "root", "");

                boolean tag = false;

                String sql = "select * from details where code='" + code + "'";

                ResultSet rs = con.prepareStatement(sql).executeQuery();

                String cd = "", pass = "";

                if (act.equals("add")) {

                    while (rs.next()) {

                        cd = rs.getString("code");

                        if (cd.equals(code)) {

                            tag = true;

                            break;
                        }

                    }

                    if (tag) {

                        out.println("<center><h1>This Product Code already exists</h1></center>");
                    } else {

                        sql = "insert into details values('" + code + "','" + name + "','" + category + "','" + price + "')";

                        con.prepareStatement(sql).execute();

                        out.println("<center><h1>Data are successfully inserted</h1></center>");

                    }
                } else if (act.equals("del")) {
                    while (rs.next()) {

                        cd = rs.getString("code");

                        if (cd.equals(code)) {

                            tag = true;

                            String sql1 = "delete from details where code='" + code + "'";

                            con.prepareStatement(sql1).execute();

                            break;
                        }

                    }

                    if (!tag) {

                        out.println("<center><h1>This Product Code doesn't exist</h1></center>");
                    } else {
                        out.println("<center><h1>Data is successfully deleted</h1></center>");

                    }

                } else if (act.equals("updt")) {
                    while (rs.next()) {

                        cd = rs.getString("code");

                        if (cd.equals(code)) {

                            tag = true;

                            sql = "update details set name = '" + name + "',catagory='" + category + "', price='" + price + "' where code = '" + code + "' ";

                            con.prepareStatement(sql).execute();

                            break;
                        }

                    }

                    if (!tag) {

                        out.println("<center><h1>This Product Code doesn't exist</h1></center>");
                    } else {
                        out.println("<center><h1>Data is successfully updated</h1></center>");

                    }
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
