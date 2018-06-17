<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.HttpSession"%>

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
      <div class="searchform">
           
        <form id="formsearch" name="formsearch" method="post" action="#">
         <% String s=(String)session.getAttribute("cowner");%> 
                                    
        </form>
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
 
      <% String sc=(String)session.getAttribute("fn");%> 
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
           <br>  
           <h3>Welcome <%=s%><br>
             
           </br><font color="orange" size="05">Edit and Upload</font> </h3><br>
           <form action="edit" method="post" >
               <TEXTAREA name="textarea1" ROWS="10" > <%=sc%> </TEXTAREA><br></br>
            
           <input type="submit" value="UpdateFile" required/> 
           </form>
          
          
         </div>
      <div class="sidebar">
        <div class="gadget">
          <h2 class="star"><span>User</span> Menu</h2>
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
     
      <div style="clear:both;"></div>
    </div>
  </div>
</div>
           
           
           
</body>
</html>
