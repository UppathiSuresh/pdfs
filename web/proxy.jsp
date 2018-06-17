<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Public Cloud</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/droid_sans_400-droid_sans_700.font.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
</head>
    
   <script>
        function AddToCart(thisForm) {
             dbUpdatedOrder = thisForm.ownerno.value;
                    
}
    </script>
    
    
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="index.html">Public <span>Cloud</span> <small>Deduplication</small></a></h1>
      </div>
      <div class="searchform">
<!--        <form id="formsearch" name="formsearch" method="post" action="#">
         
          <input name="button_search" src="images/search.gif" class="button_search" type="image" />
        </form>-->
      </div>
      <div class="clr"></div>
      <div class="menu_nav">
        <ul>
          <li><a href="index.jsp"><span>Home Page</span></a></li>
          <li><a href="registeredowner.jsp"><span>Data Owner</span></a></li>
          <li class="active"><a href="proxy.jsp"><span>server</span></a></li>
        </ul>
      </div>
      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"> <a href="#"><img src="images/slide1.jpg" width="960" height="335" alt="" /> </a>
          
            <a href="#"><img src="images/slide3.jpg" width="960" height="335" alt="" /> </a> </div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
          

        
           <%           
            String req;
            String key;
            String nme;
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
 
<%
ResultSet rs2=st1.executeQuery("select * from uploads where approve='no'");
%> 

<table  border="2" style="width:80%">

<tr>
    <th> OWNER ID</th> 
<th> FILE NAME</th> 
<th> FILE SIZE</th> 
<th> VERIFY</th> 
</tr>

<% 
while(rs2.next())
{
       String owid=rs2.getString(1);
       String fname=rs2.getString(3);
        String size=rs2.getString(4);
        session.setAttribute("fnn",  fname);
	%>
	<tr>
             <td><%=owid%></td>
             <td><%=fname%></td>
             <td><%=size%></td>
             
             <td>
                 <form id="formverify" name="formverify" method="post" action="proxyapprove">

            <input type="hidden" name="ownerno" value="<%=owid%>">
                <input type="hidden" name="fname" value="<%=fname%>">
  <input type="submit" name="submit" value="Verify this" onclick="AddToCart(this.form)"/>
             </td>
	</tr>
 <%
}

}
catch(Exception eu)
{
eu.printStackTrace();
} 
 %> 
</table> </form>   </div>   
                <div class="sidebar">
        <div class="gadget">
          <h2 class="star"><span>Owner</span> Menu</h2>
          <div class="clr"></div>
          <ul class="sb_menu">
              <li><a href="ownership.jsp">ownerships</a></li> 
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
      <p class="lf">&copy; <a href="#">cloud Allocation</a>.</p>     
      <div style="clear:both;"></div>
    </div>
  </div>
</div>
</body>
</html>
