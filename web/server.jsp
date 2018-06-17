<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
        <h1><a href="index.html">DEDUPPED <span>FILE SYSTEM</span> <small>PDFS</small></a></h1>
      </div>
      <div class="searchform">     
          
      </div>
      <div class="clr"></div>
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="index.jsp"><span>Home Page</span></a></li>
          <li><a href="ownerpage.jsp"><span>User</span></a></li>
          <li><a href="server.jsp"><span>server</span></a></li>
        </ul>
      </div>
     
    </div>
  </div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
                 
        <%   
            String req;
            String pp;
            String ll;           
    try
            {   
            Class.forName("com.mysql.jdbc.Driver");
            Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/pdfs","root","root");          
            Statement st1=con3.createStatement();
            ResultSet rs=st1.executeQuery("select ownerid,ownername,filename from uploads"); 
int owenrid=0;
                 String owenrname="";
                 String filename="";
                 
                 %>
                 <center>  <h1>File History</h1></center>
<table  border="2" style="width:80%">
<tr>
    <th>OWNER ID</th>
<th>OWNER NAME</th> 
<th> FILE NAME</th> 

</tr>
    
<%
while(rs.next())
{
    owenrid=rs.getInt(1);
        owenrname=rs.getString(2);
        filename=rs.getString(3);
    

%>
	<tr>
            <td><%=owenrid%></td>
           <td><%=owenrname%></td>
           <td><%=filename%></td>
       
	</tr>

 <%
}
}
catch(Exception eu)
{
eu.printStackTrace();
} 
 %> 

</table>      
         </div>
      
      <div class="clr"></div>
    </div>
  </div>
</body>
</html>
