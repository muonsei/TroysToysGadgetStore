package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SomeServlet")
public class SomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String USER = "root";
        final String PASS = "password";
        String DB_URL = "jdbc:mysql://localhost:3306/troystoys";
        Connection conn = null;
        Statement stmt = null;
        ArrayList<Product> products = new ArrayList<>();
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * from product";
            ResultSet rs = stmt.executeQuery(sql);


            while(rs.next()){
                //Retrieve by column name
                products.add(new Product(rs.getInt("Product_ID"), rs.getString("Product_name")
                , rs.getDouble("Product_price"), rs.getInt("Product_quantity"),
                        rs.getString("Product_description"), rs.getInt("Product_rating"),
                        rs.getString("Product_brand"), rs.getInt("Product_type")));
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        request.setAttribute("data", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("loadingDB.jsp");
        if (dispatcher != null){
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
