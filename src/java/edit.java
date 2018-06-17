/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Java1
 */
@WebServlet(urlPatterns = {"/edit"})
public class edit extends HttpServlet {
 public String oii,id,fne;
 
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
         HttpSession session=request.getSession();
        try (PrintWriter out = response.getWriter()) 
        
        { 
            String text = request.getParameter("textarea1");
             out.println(text); 
            id=(String)session.getAttribute("cowner");
            oii=(String)session.getAttribute("ownername");
            fne=(String)session.getAttribute("fnme");
            MDAlgo en1=new MDAlgo();
            String val2=en1.encrypt(text);
                    
                    
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pdfs","root","root");
			Statement st=(Statement) con.createStatement();
                        ResultSet rs= st.executeQuery("select content from edit where filename='"+fne+"' and ownerid='"+oii+"' ");
                        if(rs.next())
                        {
                        st.executeUpdate("update edit set content='"+val2+"' filename='"+fne+"' and ownerid='"+oii+"' ");
                        st.close();
                        response.sendRedirect("ownerupload.jsp");
                     
                        }else{
                        st.executeUpdate("insert into edit values('"+id+"','"+oii+"','"+fne+"','"+val2+"')");
                        st.close();
                        response.sendRedirect("ownerupload.jsp");
                        }
                       
            
            
        }catch(Exception g){
            g.printStackTrace();
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
