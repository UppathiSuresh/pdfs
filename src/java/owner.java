/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author java01
 */
@WebServlet(urlPatterns = {"/owner"})
public class owner extends HttpServlet {
 String ad1;
    String ad2;
    String s4;
    String s5;
    String s3;
    public String s01,s22;
    public String pid;
      DBase db = new DBase();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          
           s01=request.getParameter("id");
           s22=request.getParameter("name");
           s3=request.getParameter("email");
           s4=request.getParameter("uname");
           s5=request.getParameter("pass");
           
           int rand=(int)(Math.random()*1000);
           pid="O"+String.valueOf(rand); 
           
                String query="select name from owner where ownerid='"+s01+"'";
            
                if(db.check(query)){
              
                out.println("<script type=\"text/javascript\">");
                out.println("alert('already exist');");
                out.println("location='index.jsp';");
                out.println("</script>"); 
                    
                }else{
              
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pdfs","root","root");
                Statement st=con.createStatement();
                String sql = "insert into owner values('"+pid+"','"+s01+"','"+s22+"','"+s3+"','"+s4+"','"+s5+"')";
                int i=st.executeUpdate(sql);
                
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Register Successfully');");
                out.println("location='index.jsp';");
                out.println("</script>");    
                    
           }
           
          
          
        } catch(Exception e){
           out.println("<script type=\"text/javascript\">");
                             out.println("alert('Invalid UserId');");
                             out.println("location='index.jsp';");
                             out.println("</script>"); 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
