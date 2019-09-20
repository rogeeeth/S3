package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class req_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>TODO supply a title</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background-color:powderblue;\n");
      out.write("            }\n");
      out.write("            div{\n");
      out.write("                float:left;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            td{\n");
      out.write("                padding:2px;\n");
      out.write("            }\n");
      out.write("            section{\n");
      out.write("                background-color:powderblue;\n");
      out.write("            }\n");
      out.write("        </style> \n");
      out.write("       \n");
      out.write("        <h1 style=\"text-align: center;color: red;\">Registration Form</h1>\n");
      out.write("        <form action=\"/floods/request\">\n");
      out.write("            <table border='0' width='7px' cellpadding='0' cellspacing='0'>\n");
      out.write("               \n");
      out.write("                <tr><td>District</td><td><select name=\"dis\" size=\"1\">\n");
      out.write("                <option value=\"Palakkad\">Palakkad</option>\n");
      out.write("                <option value=\"Kochi\">Kochi</option>\n");
      out.write("                <option value=\"Coimbatore\">Coimbatore</option>\n");
      out.write("                <option value=\"Salem\">Salem</option>\n");
      out.write("                <option value=\"Trivandrum\">Trivandrum</option>\n");
      out.write("            </select></td></tr>\n");
      out.write("                <tr><td>Location:</td><td><input type=\"text\" name=\"loc\" required/></td></tr>\n");
      out.write("                <tr><td>Name:</td><td><input type=\"text\" name=\"fname\" required /></td></tr>\n");
      out.write("                <tr><td>Phone Number:</td><td><input type=\"tel\" name=\"pnum\" required/></td></tr>\n");
      out.write("                <tr><td>Required Items:</td><td><input type=\"checkbox\" name=\"req0\" value=\"Food\" />Food\n");
      out.write("                <input type=\"checkbox\" name=\"req1\" value=\"Water\" />Water\n");
      out.write("                <input type=\"checkbox\" name=\"req2\" value=\"Cloth\" />Clothing\n");
      out.write("                <input type=\"checkbox\" name=\"req3\" value=\"Medicine\" />Medicine</td></tr>\n");
      out.write("            <tr><td><button type=\"button\" onclick=\"download(this.form)\" id=\"submitButton\">Download</button></td></tr>\n");
      out.write("            <tr><td><input type=\"submit\" value=\"Insert into Bucket\" /></td></tr>\n");
      out.write("            \n");
      out.write("            </table> \n");
      out.write("            <p id=\"date\"></p>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("    `   <script>\n");
      out.write("            document.getElementById(\"date\").innerHTML= new Date();\n");
      out.write("        </script>\n");
      out.write("</html>");
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
