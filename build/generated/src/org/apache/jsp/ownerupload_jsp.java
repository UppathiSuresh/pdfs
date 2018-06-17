package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import javax.servlet.http.HttpSession;

public final class ownerupload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<title>Deduplication</title>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/coin-slider.css\" />\n");
      out.write("<script type=\"text/javascript\" src=\"js/cufon-yui.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/droid_sans_400-droid_sans_700.font.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-1.4.2.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/script.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/coin-slider.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"main\">\n");
      out.write("  <div class=\"header\">\n");
      out.write("    <div class=\"header_resize\">\n");
      out.write("      <div class=\"logo\">\n");
      out.write("       <h1><a href=\"index.html\">DEDUPPED   <span>FILE SYSTEM</span> <small>PDFS</small></a></h1>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"searchform\">\n");
      out.write("           \n");
      out.write("        <form id=\"formsearch\" name=\"formsearch\" method=\"post\" action=\"#\">\n");
      out.write("         ");
 String s=(String)session.getAttribute("cowner");
      out.write(" \n");
      out.write("                             \n");
      out.write("        <input name=\"button_search\" src=\"images/search.gif\" class=\"button_search\" type=\"image\" />\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("      <div class=\"clr\"></div>\n");
      out.write("      <div class=\"menu_nav\">\n");
      out.write("        <ul>\n");
      out.write("          <li class=\"active\"><a href=\"index.jsp\"><span>Home Page</span></a></li>\n");
      out.write("          <li><a href=\"ownerpage.jsp\"><span>User</span></a></li>\n");
      out.write("          <li><a href=\"server.jsp\"><span>server</span></a></li>\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("    \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write(" \n");
      out.write("    \n");
      out.write("  <div class=\"content\">\n");
      out.write("    <div class=\"content_resize\">\n");
      out.write("      <div class=\"mainbar\">\n");
      out.write("           <br></br>\n");
      out.write("           <h3>Welcome ");
      out.print(s);
      out.write("<br>\n");
      out.write("              \n");
      out.write("           </br><font color=\"orange\" size=\"05\">Choose File to Upload in Server</font> </h3><br>\n");
      out.write("           <form action=\"UploadFile\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("           <input type=\"file\" name=\"file\" required/>\n");
      out.write("           <input type=\"submit\" value=\"upload\" required/> \n");
      out.write("           </form>\n");
      out.write("          \n");
      out.write("          \n");
      out.write("         </div>\n");
      out.write("      <div class=\"sidebar\">\n");
      out.write("        <div class=\"gadget\">\n");
      out.write("          <h2 class=\"star\"><span>User</span> Menu</h2>\n");
      out.write("          <div class=\"clr\"></div>\n");
      out.write("          <ul class=\"sb_menu\">\n");
      out.write("               <li><a href=\"registeredowner.jsp\">Register</a></li>\n");
      out.write("              <li><a href=\"ownerupload.jsp\">upload</a></li>\n");
      out.write("               <li><a href=\"editfile.jsp\">Edit File</a></li> \n");
      out.write("              <li><a href=\"ownerhistory.jsp\">File History</a></li>           \n");
      out.write("            <li><a href=\"allfiles.jsp\">All Files</a></li>   \n");
      out.write("              <li><a href=\"index.jsp\">Sign Out</a></li>  \n");
      out.write("          </ul>\n");
      out.write("        </div>       \n");
      out.write("      </div>\n");
      out.write("      <div class=\"clr\"></div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"fbg\">\n");
      out.write("    \n");
      out.write("  </div>\n");
      out.write("  <div class=\"footer\">\n");
      out.write("    <div class=\"footer_resize\">\n");
      out.write("     \n");
      out.write("      <div style=\"clear:both;\"></div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("           \n");
      out.write("           \n");
      out.write("           \n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
