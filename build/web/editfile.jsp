<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Deduplication</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/droid_sans_400-droid_sans_700.font.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
         <h1><a href="index.html">DEDUPPED   <span>FILE SYSTEM</span> <small>PDFS</small></a></h1>
      </div>
    
      <div class="clr"></div>
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="index.jsp"><span>Home Page</span></a></li>
          <li><a href="ownerpage.jsp"><span>User</span></a></li>
          <li><a href="server.jsp"><span>server</span></a></li>
        </ul>
      </div>
      <div class="clr"></div>
     
      <div class="clr"></div>
    </div>
  </div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
                 
          
           <%           
            String req;
            String key=null;
            String nme=null;
            String onme=(String)session.getAttribute("ownername");
            String oid=(String)session.getAttribute("cowner");
           
            req=request.getParameter("msg");
            try
            {   
Class.forName("com.mysql.jdbc.Driver");
Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/pdfs","root","root");          
Statement st1=con3.createStatement();
ResultSet rs1=st1.executeQuery("select ownerkey,name from owner where ownerid='"+oid+"'");

%>

<%
while(rs1.next())
{
    key=rs1.getString(1);
    nme=rs1.getString(2);
    session.setAttribute("okey",key);    
%>



<%
}
Thread.sleep(0);
%>
 

<h2><font color="brown"><%=nme%><font></h2></marquee>
<h3>YOUR KEY IS  :<font color="blue"><%=key%></font></h3>
 
<%
ResultSet rs2=st1.executeQuery("select * from uploads where ownerid='"+oid+"'");
%> 

<table  border="2" style="width:80%">

<tr>
<th> FILENAME</th> 
<th> HASHCODE</th> 
</tr>

<% 

    while(rs2.next()){
        String data5=rs2.getString("filename");
         String data9=rs2.getString("blocks");
        session.setAttribute("fnn",  data5);
	%>
        <tr>
            <td> <%=data5%> </td>
            <td> <a href="search?value=<%=data9%>"><%=data9%></a></td>
                
	</tr>
 <%
}}
catch(Exception eu)
{
eu.printStackTrace();
} 
 %> 
  </table>    </div>   
          <div class="sidebar">
        <div class="gadget">
          <h2 class="star"><span>Owner</span> Menu</h2>
          <div class="clr"></div>
          <ul class="sb_menu">
                 <li><a href="registeredowner.jsp">Register</a></li>
              <li><a href="ownerupload.jsp">upload</a></li>
               <li><a href="editfile.jsp">Edit File</a></li> 
              <li><a href="ownerhistory.jsp">File History</a></li>           
            <li><a href="allfiles.jsp">All Files</a></li>   
              <li><a href="index.jsp">Sign Out</a></li>  
          </ul>
        </div>       
      </div>   
      
      <div class="clr"></div>
    </div>
  </div>
  <div class="fbg">

  </div>
  <div class="footer">
    <div class="footer_resize">
      <p class="lf">&copy; <a href="#">psdf</a>.</p>     
      <div style="clear:both;"></div>
    </div>
  </div>
</div>
</body>
</html>
