/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.36
 * Generated at: 2020-10-30 10:06:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.public_;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.StringUtil;
import com.sun.glass.ui.Size;
import models.Songs;
import java.util.ArrayList;
import models.Category;
import java.util.List;

public final class contact_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/templates/public/inc/footer.jsp", Long.valueOf(1601799006275L));
    _jspx_dependants.put("/templates/public/inc/header.jsp", Long.valueOf(1603284303032L));
    _jspx_dependants.put("/templates/public/inc/leftbar.jsp", Long.valueOf(1603487347165L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("util.StringUtil");
    _jspx_imports_classes.add("com.sun.glass.ui.Size");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("models.Songs");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("models.Category");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>BSong</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/templates/public/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/templates/public/css/coin-slider.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/public/js/jquery-3.2.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/public/js/script.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/public/js/coin-slider.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"main\">\r\n");
      out.write("  <div class=\"header\">\r\n");
      out.write("    <div class=\"header_resize\">\r\n");
      out.write("      <div class=\"logo\">\r\n");
      out.write("        <h1><a href=\"\">BSong <small>Một dự án khóa JAVA tại VinaEnter Edu</small></a></h1>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"menu_nav\">\r\n");
      out.write("        <ul>\r\n");
      out.write("          <li class=\"active\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/index\"><span>Trang chủ</span></a>\r\n");
      out.write("          <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/contact\"><span>Liên hệ</span></a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"clr\"></div>\r\n");
      out.write("      <div class=\"slider\">\r\n");
      out.write("        <div id=\"coin-slider\"><a href=\"#\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/public/images/slide1.jpg\" width=\"935\" height=\"307\" alt=\"\" /></a> <a href=\"#\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/public/images/slide2.jpg\" width=\"935\" height=\"307\" alt=\"\" /></a> <a href=\"#\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/public/images/slide3.jpg\" width=\"935\" height=\"307\" alt=\"\" /></a></div>\r\n");
      out.write("        <div class=\"clr\"></div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"clr\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"content\">");
      out.write("<div class=\"content_resize\">\r\n");
      out.write("  <div class=\"mainbar\">\r\n");
      out.write("    <div class=\"article\">\r\n");
      out.write("      <h2><span>Liên hệ</span></h2>\r\n");
      out.write("      <div class=\"clr\"></div>\r\n");
      out.write("      <p>Khi bạn có thắc mắc, vui lòng gửi liên hệ, chúng tôi sẽ phản hồi trong thời gian sớm nhất.</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"article\">\r\n");
      out.write("      <h2>Gửi liên hệ đến chúng tôi</h2>\r\n");
      out.write("      <div class=\"clr\"></div>\r\n");
      out.write("      ");

      	if(request.getAttribute("err")!= null){
      		
      out.write("<div class=\"alert alert-danger\" role=\"alert\">\r\n");
      out.write("\t\t\t\t  <p style=\"color:red; font-size:20px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${err}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("      \t\t");

      	}
      

			if(!"".equals(request.getParameter("msg"))){
				String msg = request.getParameter("msg");
				if("OK".equals(msg)){
					
      out.write("<div class=\"alert alert-success\" role=\"alert\" style=\"background-color:yellow;padding:10px;width:500px;color:green;font-size:16px;font-weight:bold\">\r\n");
      out.write("\t\t\t\t\t\t\t Xử lý thành công!\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t");

				}
			}
		
      out.write("<form action=\"");
      out.print(request.getContextPath());
      out.write("/contact\" method=\"post\" id=\"sendemail\">\r\n");
      out.write("        <ol>\r\n");
      out.write("          <li>\r\n");
      out.write("            <label for=\"name\">Họ tên (required)</label>\r\n");
      out.write("            <input id=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"name\" class=\"text\"/>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li>\r\n");
      out.write("            <label for=\"email\">Email (required)</label>\r\n");
      out.write("            <input id=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"email\" class=\"text\"/>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li>\r\n");
      out.write("            <label for=\"website\">Website</label>\r\n");
      out.write("            <input id=\"website\" value=\"\" name=\"website\" class=\"text\" />\r\n");
      out.write("          </li>\r\n");
      out.write("          <li>\r\n");
      out.write("            <label for=\"message\">Nội dung</label>\r\n");
      out.write("            <textarea id=\"message\" name=\"message\" rows=\"8\" cols=\"50\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li>\r\n");
      out.write("            <input type=\"image\" name=\"imageField\" id=\"imageField\" src=\"");
      out.print(request.getContextPath());
      out.write("/templates/public/images/submit.gif\" class=\"send\" />\r\n");
      out.write("            <div class=\"clr\"></div>\r\n");
      out.write("          </li>\r\n");
      out.write("        </ol>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"sidebar\">\r\n");
      out.write("  ");
      out.write("<div class=\"searchform\">\r\n");
      out.write("  <form id=\"formsearch\" name=\"formsearch\" method=\"GET\" action=\"");
      out.print(request.getContextPath());
      out.write("/index\">\r\n");
      out.write("    <span>\r\n");
      out.write("    <input name=\"editbox_search\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${editbox_search}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"class=\"editbox_search\" id=\"editbox_search\" maxlength=\"80\" value=\"Tìm kiếm bài hát\" type=\"text\" />\r\n");
      out.write("    </span>\r\n");
      out.write("    <input name=\"button_search\" src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/public/images/search.jpg\" class=\"button_search\" type=\"image\" />\r\n");
      out.write("  </form>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"clr\"></div>\r\n");
      out.write("<div class=\"gadget\">\r\n");
      out.write("  <h2 class=\"star\">Danh mục bài hát</h2>\r\n");
      out.write("  <div class=\"clr\"></div>\r\n");
      out.write("  <ul class=\"sb_menu\">\r\n");
      out.write("  ");

  	if(request.getAttribute("catList") != null){
		List<Category> catList = (ArrayList<Category>)request.getAttribute("catList");
		for(Category cat : catList){
			String urlSlug = request.getContextPath()+"/danh-muc/"+ StringUtil.makeSlug(cat.getName()) + "-" + cat.getId()+".html";
			
      out.write("<li><a href=\"");
      out.print(urlSlug);
      out.write('"');
      out.write('>');
      out.print(cat.getName() );
      out.write("</a></li>\r\n");
      out.write("\t\t\t");

		}
  	}
  
      out.write("</ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"gadget\">\r\n");
      out.write("  <h2 class=\"star\"><span>Bài hát mới</span></h2>\r\n");
      out.write("  <div class=\"clr\"></div>\r\n");
      out.write("  ");

  	if(request.getAttribute("songListFL") != null){
  		List<Songs> songListFL = (List<Songs>)request.getAttribute("songListFL");
  		
      out.write("<ul class=\"ex_menu\">\r\n");
      out.write("\t  \t\t\t");

	  				for(Songs song : songListFL){
	  					int id = song.getId();
	  					String name = song.getName();
	  					String description = song.getDescription();
	  					// mapping url
	  					//detail?sid=2
	  					String urlSlug = request.getContextPath()+"/chi-tiet/"+ StringUtil.makeSlug(song.getName()) + "-" + song.getId()+".html";
	  					
      out.write("<li><a href=\"");
      out.print(urlSlug);
      out.write('"');
      out.write('>');
      out.print(name );
      out.write("</a><br />\r\n");
      out.write("\t\t\t     \t\t\t\t");

				     				for(String w : description.split("\\s", 10)){
				     					out.println(w);
				     				}
			     				
      out.write("</li>\r\n");
      out.write("\t  \t\t\t\t\t");

	  				}
	  			
      out.write("</ul>\r\n");
      out.write("  \t\t");

  	}
  
      out.write("</div>");
      out.write("</div>\r\n");
      out.write("  <div class=\"clr\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"footer\">\r\n");
      out.write("    <div class=\"footer_resize\">\r\n");
      out.write("      <p class=\"lf\">Copyright &copy; <a href=\"#\">VinaEnter Edu</a>. All Rights Reserved</p>\r\n");
      out.write("      <p class=\"rf\">Code by Gia Huy - Khóa JAVA17</a></p>\r\n");
      out.write("      <div style=\"clear:both;\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
