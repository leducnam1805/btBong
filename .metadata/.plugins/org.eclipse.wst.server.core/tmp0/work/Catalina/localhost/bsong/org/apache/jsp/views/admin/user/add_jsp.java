/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.36
 * Generated at: 2020-11-06 15:45:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.admin.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.CatUser;
import java.util.List;
import models.User;
import models.User;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/templates/admin/inc/leftbar.jsp", Long.valueOf(1604676832550L));
    _jspx_dependants.put("/templates/admin/inc/footer.jsp", Long.valueOf(1604109280472L));
    _jspx_dependants.put("/templates/admin/inc/header.jsp", Long.valueOf(1604200630023L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("models.User");
    _jspx_imports_classes.add("models.CatUser");
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
      out.write("    <!-- toggle css -->\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/css/toggle.css\" rel=\"stylesheet\" />\r\n");
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
      out.write("    <!-- toggle boostrap-->\r\n");
      out.write("    <link href='");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/css/bootstrap4-toggle.min.css' rel='stylesheet' type='text/css' />\r\n");
      out.write("    <!-- JQUERY -->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/js/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("\t<!-- validate -->\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/js/jquery.validate.min.js\"></script>\r\n");
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
      out.write("                <a class=\"navbar-brand\" href=\"");
      out.print(request.getContextPath() );
      out.write("/home\">VinaEnter Edu</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"color: white;padding: 15px 50px 5px 50px;float: left;font-size: 16px;\">\r\n");
      out.write("\t            <a href=\"");
      out.print(request.getContextPath() );
      out.write("/\" class=\"btn btn-danger square-btn-adjust\">Trang chủ</a> \r\n");
      out.write("\t         </div>\r\n");
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
      out.write("\t\t\t        <ul class=\"nav\"id=\"main-menu\">\r\n");
      out.write("\t\t\t            <li class=\"text-center\">\r\n");
      out.write("\t\t\t                <img src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/img/zing.png\" class=\"user-image img-responsive\" />\r\n");
      out.write("\t\t\t            </li>\r\n");
      out.write("\t\t\t            <li>\r\n");
      out.write("\t\t\t                <a id=\"index\" href=\"");
      out.print(request.getContextPath());
      out.write("/admin\"><i class=\"fa fa-dashboard fa-3x\"></i> Trang chủ</a>\r\n");
      out.write("\t\t\t            </li>\r\n");
      out.write("\t\t\t            <li>\r\n");
      out.write("\t\t\t                <a id=\"category\" href=\"");
      out.print(request.getContextPath());
      out.write("/admin/cat/index\"><i class=\"fa fa-list fa-3x\"></i> Quản lý danh mục</a>\r\n");
      out.write("\t\t\t            </li>\r\n");
      out.write("\t\t\t            <li>\r\n");
      out.write("\t\t\t                <a id=\"song\" href=\"");
      out.print(request.getContextPath());
      out.write("/admin/song/index\"><i class=\"fa fa-music fa-3x\"></i> Quản lý bài hát</a>\r\n");
      out.write("\t\t\t            </li>\r\n");
      out.write("\t\t\t            ");

			            	if(session.getAttribute("userInfor") != null){
			            		User user = (User) session.getAttribute("userInfor");
			            		if(user.getCatUser().getId() < 3){
			            			
      out.write("<li>\r\n");
      out.write("\t\t\t\t\t\t\t                <a id=\"usermanager\" href=\"\"><i class=\"fa fa-user fa-3x\"></i> Quản lý người dùng&emsp;&emsp;&nbsp;<i class=\"fa fa-caret-down fa-2x\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t                <ul class=\"nav\"id=\"main-menu\" style=\"font-size:15px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t                ");

								                	if(user.getCatUser().getId() < 2){
								                		
      out.write("<li><a id=\"phanquyen\" href=\"");
      out.print(request.getContextPath());
      out.write("/admin/user/phanquyen\"><i class=\"fa fa-share fa-2x\" aria-hidden=\"true\"></i>&nbsp;Phân quyền</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t                \t\t");

								                	}
								                
      out.write("<li><a id=\"catuser\" href=\"");
      out.print(request.getContextPath());
      out.write("/admin/catuser/index\"><i class=\"fa fa-share fa-2x\" aria-hidden=\"true\"></i>&nbsp;Loại tài khoản</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t                \t<li><a id=\"user\" href=\"");
      out.print(request.getContextPath());
      out.write("/admin/user/index\"><i class=\"fa fa-share fa-2x\" aria-hidden=\"true\"></i>&nbsp;Người dùng</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t                </ul>\r\n");
      out.write("\t\t\t\t\t\t\t            </li>\r\n");
      out.write("\t\t\t            \t\t\t");

			            		}
			            	}
			            
      out.write("<li>\r\n");
      out.write("\t\t\t                <a id=\"contact\" href=\"");
      out.print(request.getContextPath());
      out.write("/admin/contact/index\"><i class=\"fa fa-envelope fa-3x\"></i> Quản lý liên hệ</a>\r\n");
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
      out.write("<div id=\"page-wrapper\">\r\n");
      out.write("    <div id=\"page-inner\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-12\">\r\n");
      out.write("                <h2>Thêm tài khoản</h2>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /. ROW  -->\r\n");
      out.write("        <hr />\r\n");
      out.write("        ");

      	if(request.getAttribute("err")!= null){
      		
      out.write("<div class=\"alert alert-danger\" role=\"alert\">\r\n");
      out.write("\t\t\t\t  <p style=\"color:red; font-size:20px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${err}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("      \t\t");

      	}
     	 
      out.write("<div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-12\">\r\n");
      out.write("                <!-- Form Elements -->\r\n");
      out.write("                <div class=\"panel panel-default\">\r\n");
      out.write("                    <div class=\"panel-body\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-12\">\r\n");
      out.write("                                <form role=\"form\" method=\"post\"id=\"form\" action=\"");
      out.print(request.getContextPath());
      out.write("/admin/user/add\">\r\n");
      out.write("                                \t<div class=\"form-group\">\r\n");
      out.write("                                        <label for=\"username\">Tên đăng nhập</label>\r\n");
      out.write("                                        <input type=\"text\" id=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"username\" class=\"form-control\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label for=\"pass\">Mật khẩu</label>\r\n");
      out.write("                                        <input type=\"password\" id=\"pass\" value=\"\" name=\"pass\" class=\"form-control\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label for=\"fullname\">Tên đầy đủ</label>\r\n");
      out.write("                                        <input type=\"text\" id=\"fullname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fullname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"fullname\" class=\"form-control\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label for=\"category\">Loại tài khoản</label>\r\n");
      out.write("                                        <select id=\"category\" name=\"categoriesuser\" class=\"form-control\">\r\n");
      out.write("                                        ");

                                        	if(request.getAttribute("catUserList") != null){
                                        		List<CatUser> catUserList = (List<CatUser>)request.getAttribute("catUserList");
                                        		if(catUserList.size() > 0){
                                        			for(CatUser catUser : catUserList){
                                        				
      out.write("<option value=\"");
      out.print(catUser.getId());
      out.write('"');
      out.write('>');
      out.print(catUser.getName() );
      out.write("</option>\r\n");
      out.write("                                        \t\t\t\t");

                                        			}
                                        		}
                                        	}
                                        
      out.write("</select>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <button type=\"submit\" name=\"submit\" class=\"btn btn-success btn-md\">Thêm</button>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- End Form Elements -->\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /. ROW  -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /. PAGE INNER  -->\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("    document.getElementById(\"song\").classList.add('active-menu');\r\n");
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
      out.write("<!-- toggle boostrap -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/admin/assets/js/bootstrap4-toggle.min.js\"></script>\r\n");
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
