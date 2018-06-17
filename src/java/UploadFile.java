



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "UploadFile", urlPatterns = {"/UploadFile"})
public class UploadFile extends HttpServlet {
   Statement st;
   long filesize;
   String fNa,bks,dbhc;
    String fileSavePath;
    String ct;
    Statement st1;
    Statement s5;
    public String oii;
    public String id;
    public String s46,s56;
String val2;
  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Iterator it=null;
         HttpSession session=request.getSession();
            
           
        try {
            org.apache.commons.fileupload.FileItemFactory fif = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(fif);
             List items = null;
             
            try
            {
                items = upload.parseRequest(request);
            }
            catch(FileUploadException e)
            {
                e.printStackTrace();
            }
            Iterator iter = items.iterator();
            do
            {
                if(!iter.hasNext())
                    break;
                FileItem fit = (FileItem)iter.next();
                if(fit.isFormField())
                {
//                   String iname = fit.getFieldName();
                    String iname = fit.getString();
                    String ivalue = fit.getString();
                    
                   out.println((new StringBuilder()).append("Iname is ").append(iname).toString()); 
                }else{ 
                    
                        filesize=fit.getSize();
                        String itemName = fit.getName();
                        String imgfilename = itemName.substring(itemName.lastIndexOf("\\") + 1);
     
                        String cott=fit.getString();
                        int hc=cott.hashCode();
                        String shc=String.valueOf(hc);
                        
                        oii=(String)session.getAttribute("ownername");
                        id=(String)session.getAttribute("cowner");
                        session.setAttribute("oiidd",oii);
                        
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con1=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pdfs","root","root");
			st1=con1.createStatement();
	            ResultSet rs1=st1.executeQuery("select filename from uploads");
                    while(rs1.next()){
                    fNa=rs1.getString(1); 
                 
                    
                   
                       }
//                    out.println(fNa+"//"+itemName);
                    
                          
                          Class.forName("com.mysql.jdbc.Driver");
                        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pdfs","root","root");
			st=con.createStatement();
	            ResultSet rs=st.executeQuery("select blocks from uploads");
                    while(rs.next()){
                     dbhc=rs.getString(1); 
                    }
                    
                    if(dbhc.equals(shc)){
                          session.setAttribute("fn",itemName);
                    MDAlgo en1=new MDAlgo();
                     val2=en1.encrypt(fit.getString());
                          Class.forName("com.mysql.jdbc.Driver");
                        Connection conc=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pdfs","root","root");
			st=(Statement) conc.createStatement();
                        st.executeUpdate("insert into ownership values('"+id+"','"+itemName+"')");
                        
                         st.executeUpdate("insert into uploads values('"+id+"','"+oii+"','"+itemName+"','"+(String.valueOf(filesize/1024+"kb"))+"','duplicated','no','"+hc+"')");
                       
                              out.println("<script type=\"text/javascript\">");
                            out.println("alert('File duplicated....');");
                             out.println("location='ownerupload.jsp';");       
                                out.println("</script>"); 
                        
                        
                    }else{
                         try
                      {                          
                    session.setAttribute("fn",itemName);
                    MDAlgo en1=new MDAlgo();
                    
                   
                       val2=en1.encrypt(fit.getString());
                        int formDataLength = val2.length();
                     int size=formDataLength/4;
                     int  n=4;
                     
                     
                        
                  for(int i=0;i<n;i++)
		  {
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pdfs","root","root");
		
                      if(i==0){
                        String si= val2.substring(1, size);
                        st=(Statement) conn.createStatement();
                        st.executeUpdate("insert into blocks values('"+si+"','"+si.hashCode()+"')");
                        
                    }else if (i==1){
                          String si= val2.substring(size+1, size+size);
                           st=(Statement) conn.createStatement();
                            st.executeUpdate("insert into blocks values('"+si+"','"+si.hashCode()+"')");
                            
                    }else if(i==2){
                          String si= val2.substring(size+size, size+size+size);
                           st=(Statement) conn.createStatement();
                            st.executeUpdate("insert into blocks values('"+si+"','"+si.hashCode()+"')");
                            
                    }else if(i==3){
                          String si= val2.substring(size+size+size, size+size+size+size);
                           st=(Statement) conn.createStatement();
                            st.executeUpdate("insert into blocks values('"+si+"','"+si.hashCode()+"')");
                            
                    }
                       
                        
                  }
                       
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pdfs","root","root");
			st=(Statement) conn.createStatement();
                        st.executeUpdate("insert into uploads values('"+id+"','"+oii+"','"+itemName+"','"+(String.valueOf(filesize/1024+"kb"))+"','"+val2+"','no','"+hc+"')");
                        st.executeUpdate("insert into ownership values('"+id+"','"+itemName+"')");
                       
                             out.println("<script type=\"text/javascript\">");
                             out.println("alert('File Upload Successfully');");
                             out.println("location='ownerupload.jsp';");
                             out.println("</script>"); 
                             
                        }
                        
                     catch (IOException e) {
			e.printStackTrace();
                     } 
                    }
                    
                }
                   
                     }while(true);  
        
        
        }
               
                 catch(Exception ex){
                   ex.printStackTrace();
            }
             
        
   
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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