package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class findflight_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Find flight</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Find your flight!</h1>\n");
      out.write("        \n");
      out.write("\n");
      out.write("<form action='success.jsp' method='post'>\n");
      out.write("    \n");
      out.write("\n");

int tickets = Integer.parseInt(request.getParameter("tickets"));
String dep = request.getParameter("dep");
String arr = request.getParameter("arr");

try
{
    Class.forName("org.apache.derby.jdbc.ClientDriver");
     Connection c;
   c = DriverManager.getConnection("jdbc:derby://localhost:1527/Fly", "fly", "fly1");
    Statement stmt = c.createStatement();
    ResultSet result;
    result = stmt.executeQuery("select * from flight  where depparture = '"+dep+"' and arrival = '"+arr+"' and no_seats >= 0 ");

  while (result.next()){
   out.println("<br /><input type='radio' name='id' value='"+result.getInt("flight_id")+"'> flight id: "+result.getInt("flight_id") + " date and time: "+result.getString("date") + " ("+result.getString("time") + ") <br /><br />");
  }
  
  if (result.next() == false) 
{
         out.println("we did not find any flights");
        }
    out.print("<input type='hidden' value='"+tickets+"' name='tickets' /><input type='submit' value='Select this flight' />");

      }
catch(Exception ex)
{
         out.println("Error");

}

      out.write(" \n");
      out.write("\n");
      out.write("</form>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
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
