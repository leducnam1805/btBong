/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.36
 * Generated at: 2020-10-30 09:45:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.User;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/templates/admin/inc/leftbar.jsp", Long.valueOf(1604051097905L));
    _jspx_dependants.put("/templates/admin/inc/footer.jsp", Long.valueOf(1603700477943L));
    _jspx_dependants.put("/templates/admin/inc/header.jsp", Long.valueOf(1604000370549L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("models.User");
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
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <title>AdminCP | VinaEnter Edu</title>\r\n");
      out.write("    <!-- BOOTSTRAP STYLES-->\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/css/bootstrap.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <!-- FONTAWESOME STYLES-->\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/css/font-awesome.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <!-- CUSTOM STYLES-->\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/css/custom.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <!-- GOOGLE FONTS-->\r\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />\r\n");
      out.write("    <!-- JQUERY -->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/js/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"wrapper\">\r\n");
      out.write("        <nav class=\"navbar navbar-default navbar-cls-top \" role=\"navigation\" style=\"margin-bottom: 0\">\r\n");
      out.write("            <div class=\"navbar-header\">\r\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".sidebar-collapse\">\r\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                </button>\r\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.html\">VinaEnter Edu</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");

            	if(session.getAttribute("userInfor") != null){
            		User userInfor = (User) session.getAttribute("userInfor");
            		
      out.write("<div style=\"color: white;padding: 15px 50px 5px 50px;float: right;font-size: 16px;\">\r\n");
      out.write("            \t\t\t\t Xin chào, <b>");
      out.print(userInfor.getFullname());
      out.write("</b> &nbsp; \r\n");
      out.write("\t\t\t\t            <a href=\"");
      out.print(request.getContextPath() );
      out.write("/auth/logout\" class=\"btn btn-danger square-btn-adjust\">Đăng xuất</a> \r\n");
      out.write("\t\t\t\t         </div>\r\n");
      out.write("            \t\t");

            	}
            
      out.write("</nav>\r\n");
      out.write("        <!-- /. NAV TOP  -->");
      out.write("<nav class=\"navbar-default navbar-side\" role=\"navigation\">\r\n");
      out.write("\t\t\t    <div class=\"sidebar-collapse\">\r\n");
      out.write("\t\t\t    ");

			    	// mapping url
			    	// /admin/cat/index
  	  				String urlSlugCat = request.getContextPath()+"/admin/quan-ly-danh-muc/danh-sach"+".html";
				    String urlSlugSong = request.getContextPath()+"/admin/quan-ly-bai-hat.html";
				    String urlSlugUser = request.getContextPath()+"/admin/quan-ly-nguoi-dung"+".html";
				    String urlSlugContact = request.getContextPath()+"/admin/quan-ly-lien-he"+".html";
				    //admin/catuser/index 
				     String urlSlugCatUser = request.getContextPath()+"/admin/quan-ly-tai-khoan/loai-tai-khoan"+".html";
			    
      out.write("<ul class=\"nav\"id=\"main-menu\">\r\n");
      out.write("\t\t\t            <li class=\"text-center\">\r\n");
      out.write("\t\t\t                <img src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/img/find_user.png\" class=\"user-image img-responsive\" />\r\n");
      out.write("\t\t\t            </li>\r\n");
      out.write("\t\t\t            <li>\r\n");
      out.write("\t\t\t                <a id=\"index\" href=\"");
      out.print(request.getContextPath());
      out.write("/admin\"><i class=\"fa fa-dashboard fa-3x\"></i> Trang chủ</a>\r\n");
      out.write("\t\t\t            </li>\r\n");
      out.write("\t\t\t            <li>\r\n");
      out.write("\t\t\t                <a id=\"category\" href=\"");
      out.print(urlSlugCat);
      out.write("\"><i class=\"fa fa-list fa-3x\"></i> Quản lý danh mục</a>\r\n");
      out.write("\t\t\t            </li>\r\n");
      out.write("\t\t\t            <li>\r\n");
      out.write("\t\t\t                <a id=\"song\" href=\"");
      out.print(urlSlugSong);
      out.write("\"><i class=\"fa fa-music fa-3x\"></i> Quản lý bài hát</a>\r\n");
      out.write("\t\t\t            </li>\r\n");
      out.write("\t\t\t            <li>\r\n");
      out.write("\t\t\t                <a id=\"usermanager\" href=\"\"><i class=\"fa fa-user fa-3x\"></i> Quản lý người dùng&emsp;&emsp;&nbsp;<i class=\"fa fa-caret-down fa-2x\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t                <ul class=\"nav\"id=\"main-menu\" style=\"font-size:15px;\">\r\n");
      out.write("\t\t\t                \t<li><a id=\"phanquyen\" href=\"");
      out.print(request.getContextPath());
      out.write("/admin/user/phanquyen\"><i class=\"fa fa-share fa-2x\" aria-hidden=\"true\"></i>&nbsp;Phân quyền</a></li>\r\n");
      out.write("\t\t\t                \t<li><a id=\"catuser\" href=\"");
      out.print(urlSlugCatUser);
      out.write("\"><i class=\"fa fa-share fa-2x\" aria-hidden=\"true\"></i>&nbsp;Loại tài khoản</a></li>\r\n");
      out.write("\t\t\t                \t<li><a id=\"user\" href=\"");
      out.print(urlSlugUser);
      out.write("\"><i class=\"fa fa-share fa-2x\" aria-hidden=\"true\"></i>&nbsp;Người dùng</a></li>\r\n");
      out.write("\t\t\t                </ul>\r\n");
      out.write("\t\t\t            </li>\r\n");
      out.write("\t\t\t            <li>\r\n");
      out.write("\t\t\t                <a id=\"contact\" href=\"");
      out.print(urlSlugContact);
      out.write("\"><i class=\"fa fa-envelope fa-3x\"></i> Quản lý liên hệ</a>\r\n");
      out.write("\t\t\t            </li>\r\n");
      out.write("\t\t\t        </ul>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t</nav>\r\n");
      out.write("\t\t\t <script type=\"text/javascript\">\n");
      out.write("\t\t\t\tif(window.location.hash) {\t\r\n");
      out.write("\t\t\t\t\tvar hash = window.location.hash.substring(1);\t\r\n");
      out.write("\t\t\t\t\t$('.nav a[id=\"' + hash + '\"]').tab('show');\r\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t<!-- /. NAV SIDE  -->\r\n");
      out.write("    \t\t");
      out.write("<div id=\"page-wrapper\">\r\n");
      out.write("    <div id=\"page-inner\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-12\">\r\n");
      out.write("                <h2>TRANG QUẢN TRỊ VIÊN</h2>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /. ROW  -->\r\n");
      out.write("        <hr />\r\n");
      out.write("        ");

        	int countCat = (Integer)request.getAttribute("countCat");
        	int countSong = (Integer)request.getAttribute("countSong");
        	int countUser = (Integer)request.getAttribute("countUser");
        
      out.write("<div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-4 col-sm-4 col-xs-4\">\r\n");
      out.write("                <div class=\"panel panel-back noti-box\">\r\n");
      out.write("                    <span class=\"icon-box bg-color-green set-icon\">\r\n");
      out.write("                    <i class=\"fa fa-bars\"></i>\r\n");
      out.write("                </span>\r\n");
      out.write("                    <div class=\"text-box\">\r\n");
      out.write("                        <p class=\"main-text\"><a href=\"");
      out.print(urlSlugCat);
      out.write("\" title=\"\">Quản lý danh mục</a></p>\r\n");
      out.write("                        <p class=\"text-muted\">Có ");
      out.print(countCat);
      out.write(" danh mục</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-4 col-sm-4 col-xs-4\">\r\n");
      out.write("                <div class=\"panel panel-back noti-box\">\r\n");
      out.write("                    <span class=\"icon-box bg-color-blue set-icon\">\r\n");
      out.write("                    <i class=\"fa fa-bell-o\"></i>\r\n");
      out.write("                </span>\r\n");
      out.write("                    <div class=\"text-box\">\r\n");
      out.write("                        <p class=\"main-text\"><a href=\"");
      out.print(urlSlugSong);
      out.write("\" title=\"\">Quản lý bài hát</a></p>\r\n");
      out.write("                        <p class=\"text-muted\">Có ");
      out.print(countSong );
      out.write(" bài hát</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-4 col-sm-4 col-xs-4\">\r\n");
      out.write("                <div class=\"panel panel-back noti-box\">\r\n");
      out.write("                    <span class=\"icon-box bg-color-brown set-icon\">\r\n");
      out.write("                    <i class=\"fa fa-rocket\"></i>\r\n");
      out.write("                </span>\r\n");
      out.write("                    <div class=\"text-box\">\r\n");
      out.write("                        <p class=\"main-text\"><a href=\"");
      out.print(urlSlugUser);
      out.write("\" title=\"\">Quản lý người dùng</a></p>\r\n");
      out.write("                        <p class=\"text-muted\">Có ");
      out.print(countUser );
      out.write(" người dùng</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("    document.getElementById(\"index\").classList.add('active-menu');\r\n");
      out.write("</script>\r\n");
      out.write("<!-- /. PAGE WRAPPER  -->\r\n");
      out.write("</div>\r\n");
      out.write("<!-- /. WRAPPER  -->\r\n");
      out.write("<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->\r\n");
      out.write("<!-- JQUERY -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/js/jquery-3.2.1.js\"></script>\r\n");
      out.write("<!-- BOOTSTRAP SCRIPTS -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!-- METISMENU SCRIPTS -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/js/jquery.metisMenu.js\"></script>\r\n");
      out.write("<!-- CUSTOM SCRIPTS -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/js/custom.js\"></script>\r\n");
      out.write("<!-- sweetalert -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/node_modules/sweetalert2/dist/sweetalert2.all.min.js\"></script>\r\n");
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
