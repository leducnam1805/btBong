/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.36
 * Generated at: 2020-11-06 15:44:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.admin.catuser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.CatUser;
import util.StringUtil;
import models.Category;
import java.util.ArrayList;
import models.User;
import models.User;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("util.StringUtil");
    _jspx_imports_classes.add("models.User");
    _jspx_imports_classes.add("models.CatUser");
    _jspx_imports_classes.add("models.Category");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("                <h2>Quản lý loại tài khoản</h2>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /. ROW  -->\r\n");
      out.write("        <hr />\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-12\">\r\n");
      out.write("                <!-- Advanced Tables -->\r\n");
      out.write("                <div class=\"panel panel-default\">\r\n");
      out.write("                    <div class=\"panel-body\">\r\n");
      out.write("                    ");

                    	if(session.getAttribute("userInfor") != null){
                    		User checkUser = (User) session.getAttribute("userInfor");
                    		
      out.write("<div class=\"table-responsive\">\r\n");
      out.write("\t\t                            <div class=\"row\">\r\n");
      out.write("\t\t                            ");

		                            	if(checkUser.getCatUser().isAddquyen() == true){
		                            		
      out.write("<div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t                                    <a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/catuser/add\" class=\"btn btn-success btn-md\">Thêm</a>\r\n");
      out.write("\t\t\t\t                                </div>\r\n");
      out.write("\t\t                            \t\t");

		                            	}
		                            
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

										if(!"".equals(request.getParameter("msg"))){
											String msg = request.getParameter("msg");
											if("OK".equals(msg)){
												
      out.write("<div class=\"alert alert-success\" role=\"alert\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t Xử lý thành công!\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t");

											}
										}
									
      out.write("<table class=\"table table-striped table-bordered table-hover\" id=\"dataTables-example\">\r\n");
      out.write("\t\t                                <thead>\r\n");
      out.write("\t\t                                    <tr>\r\n");
      out.write("\t\t                                        <th>STT</th>\r\n");
      out.write("\t\t                                        <th>Loại tài khoản</th>\r\n");
      out.write("\t\t                                        <th width=\"160px\">Chức năng</th>\r\n");
      out.write("\t\t                                    </tr>\r\n");
      out.write("\t\t                                </thead>\r\n");
      out.write("\t\t                                <tbody>\r\n");
      out.write("\t\t                                ");

		                                	if(request.getAttribute("catUserList")!= null){
		                                		ArrayList<CatUser> catUserList = (ArrayList<CatUser>) request.getAttribute("catUserList");
		                                		if(catUserList.size() > 0){
		                                			

		                                					int i = 0;
			                                				for(CatUser catUser : catUserList){
			                                					i++;
			                                    				int id = catUser.getId();
			                                    				String name = catUser.getName();
			                                    				//String urlSlugCatEdit = request.getContextPath()+"/admin/quan-ly-tai-khoan/sua-loai-tai-khoan/"+StringUtil.makeSlug(catUser.getName())+"-"+catUser.getId()+".html";
			                                    				String urledit = request.getContextPath()+"/admin/catuser/edit?cuid="+id;
			                                    				String urlDel = request.getContextPath()+"/admin/catuser/del?cuid="+id;
			                                    				
      out.write("<tr>\r\n");
      out.write("\t\t\t    \t\t\t\t                                        <td>");
      out.print(i );
      out.write("</td>\r\n");
      out.write("\t\t\t    \t\t\t\t                                        <td class=\"center\">");
      out.print(name );
      out.write("</td>\r\n");
      out.write("\t\t\t    \t\t\t\t                                        <td class=\"center\">\r\n");
      out.write("\t\t\t    \t\t\t\t                                       ");

											                            	if(checkUser.getCatUser().isEditquyen() == true){
											                            		
      out.write("<a href=\"");
      out.print(urledit);
      out.write("\" title=\"\" class=\"btn btn-primary\"><i class=\"fa fa-edit \"></i> Sửa</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t                            \t\t");

											                            	}
											                            

											                            	if(checkUser.getCatUser().isDelquyen() == true){
											                            		
      out.write("<a idCatUser=");
      out.print(id );
      out.write(" title=\"\" class=\"btn btn-danger del-catuser\"><i class=\"fa fa-pencil\"></i> Xóa</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t                            \t\t");

											                            	}
											                            
      out.write("</td>\r\n");
      out.write("\t\t\t    \t\t\t\t                                    </tr>\r\n");
      out.write("\t\t\t                                    \t\t\t\t");

			                                    			}
		                                				

		                                				int numberOfPage = (Integer)request.getAttribute("numberOfPage");
			                                		  	int currentPage = (Integer)request.getAttribute("currentPage");
			                                		  	if(catUserList != null && catUserList.size() > 0){
			                                		  		
      out.write("<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t                                <!-- <div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t                                    <div class=\"dataTables_info\" id=\"dataTables-example_info\" style=\"margin-top:27px\">Hiển thị từ 1 đến 5 của 24 truyện</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t                                </div> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t                                <div class=\"col-sm-6\" style=\"text-align: right;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t                                    <div class=\"dataTables_paginate paging_simple_numbers\" id=\"dataTables-example_paginate\">\r\n");
      out.write("\t\t\t\t\t\t\t\t                                        <ul class=\"pagination\">\r\n");
      out.write("\t\t\t\t\t\t\t\t                                            <!-- <li class=\"paginate_button previous disabled\" aria-controls=\"dataTables-example\" tabindex=\"0\" id=\"dataTables-example_previous\"><a href=\"#\">Trang trước</a></li> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t                                            ");

								                                            	for(int j = 1; j <= numberOfPage;j++){
								                                            		

								                                            				if(currentPage == j){
								                                            					
      out.write("<li class=\"paginate_button active\" aria-controls=\"dataTables-example\" tabindex=\"0\"><a href=\"\">");
      out.print(j );
      out.write("</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t                                            \t\t\t\t\t");

								                                            				}else{
								                                            					
      out.write("<li class=\"paginate_button\" aria-controls=\"dataTables-example\" tabindex=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t                                            \t\t\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/cat/index?page=");
      out.print(j);
      out.write('"');
      out.write('>');
      out.print(j);
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t                                            \t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t                                            \t\t\t\t\t");

								                                            				}
								                                            			

								                                            	}
								                                            
      out.write("<!-- <li class=\"paginate_button next\" aria-controls=\"dataTables-example\" tabindex=\"0\" id=\"dataTables-example_next\"><a href=\"#\">Trang tiếp</a></li> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t                                        </ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t                                    </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t                                </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t                            </div>\r\n");
      out.write("\t\t\t                                \t\t  \t\t");

			                                		  	}
		                                				

		                                		}
		                                	}
		                                
      out.write("</tbody>\r\n");
      out.write("\t\t                            </table>\r\n");
      out.write("\t\t                        </div>\r\n");
      out.write("                    \t\t");

                    	}else{
							
      out.write("<div class=\"alert alert-danger\" role=\"alert\">\r\n");
      out.write("\t\t\t\t\t\t\t\t   Chúng tôi đang khắc phục sự cố. Xin lỗi vì sự bất tiện này.!\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t");
                    		
                    	}
                    
      out.write("</div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!--End Advanced Tables -->\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("    document.getElementById(\"catuser\").classList.add('active-menu');\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("    document.getElementById(\"usermanager\").classList.add('active-menu');\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("        $(document).on(\"click\", \"a.del-catuser\", (function () {\r\n");
      out.write("        \t//lấy dữ liêu\r\n");
      out.write("    \t    var id = $(this).attr(\"idCatUser\");\r\n");
      out.write("    \t    const swalWithBootstrapButtons = Swal.mixin({\r\n");
      out.write("    \t    \t  customClass: {\r\n");
      out.write("    \t    \t    confirmButton: 'btn btn-success',\r\n");
      out.write("    \t    \t    cancelButton: 'btn btn-danger'\r\n");
      out.write("    \t    \t  },\r\n");
      out.write("    \t    \t  buttonsStyling: false\r\n");
      out.write("    \t    \t})\r\n");
      out.write("    \t    swal.fire({\r\n");
      out.write("    \t        title: 'Bạn Có Chắc Chắn?',\r\n");
      out.write("    \t        text: \"Dữ Liệu Sẽ Không Thể Phục Hồi!\",\r\n");
      out.write("    \t        icon: 'warning',\r\n");
      out.write("    \t        padding: '3em',\r\n");
      out.write("    \t        showCancelButton: true,\r\n");
      out.write("    \t        confirmButtonColor: '#3085d6',\r\n");
      out.write("    \t        cancelButtonColor: '#d33',\r\n");
      out.write("    \t        confirmButtonText: 'Đồng Ý, Xóa!',\r\n");
      out.write("    \t        cancelButtonText: 'Hủy bỏ',\r\n");
      out.write("    \t        reverseButtons: true,\r\n");
      out.write("    \t        customClass: null\r\n");
      out.write("    \t    }).then((result) => {\r\n");
      out.write("    \t    \t  if (result.value) {\r\n");
      out.write("    \t    \t\t  $.ajax({\r\n");
      out.write("    \t    \t\t\t  \tasync: false,\r\n");
      out.write("    \t    \t            type: \"get\",\r\n");
      out.write("    \t    \t            url: \"");
      out.print(request.getContextPath());
      out.write("/admin/catuser/del\",\r\n");
      out.write("    \t    \t            data: { id : id },\r\n");
      out.write("    \t    \t            success: function (data) {\r\n");
      out.write("    \t    \t            \tif(data==false){\r\n");
      out.write("\t   \t    \t            \t\tSwal.fire(\r\n");
      out.write("   \t    \t    \t                    'Thông Báo!',\r\n");
      out.write("   \t    \t    \t                    'Bạn không thể xóa loại tài khoản này.',\r\n");
      out.write("   \t    \t    \t                    'danger'\r\n");
      out.write("   \t    \t    \t                ).then(function () {\r\n");
      out.write("   \t    \t    \t                    location.reload();\r\n");
      out.write("   \t    \t    \t                })\r\n");
      out.write("    \t    \t            \t}else{\r\n");
      out.write("   \t    \t            \t\t\tSwal.fire(\r\n");
      out.write("\t   \t            \t\t\t      'Thành công!',\r\n");
      out.write("\t   \t            \t\t\t      'Bạn đã xóa thành công.',\r\n");
      out.write("\t   \t            \t\t\t      'success'\r\n");
      out.write("\t   \t            \t\t\t    ).then(function () {\r\n");
      out.write("   \t    \t    \t                    location.reload();\r\n");
      out.write("   \t    \t    \t                })\r\n");
      out.write("    \t    \t            \t}\r\n");
      out.write("    \t    \t            },\r\n");
      out.write("    \t    \t            error: function (xhr, ajaxOptions, thrownError) {\r\n");
      out.write("    \t    \t                Swal.fire(\r\n");
      out.write("    \t    \t                    'Thông Báo!',\r\n");
      out.write("    \t    \t                    'Thao tác không thể thực hiện.',\r\n");
      out.write("    \t    \t                    'danger'\r\n");
      out.write("    \t    \t                ).then(function () {\r\n");
      out.write("    \t    \t                    location.reload();\r\n");
      out.write("    \t    \t                })\r\n");
      out.write("    \t    \t            }\r\n");
      out.write("    \t    \t        });\r\n");
      out.write("    \t    \t\t  } else if (result.dismiss === Swal.DismissReason.cancel) {\r\n");
      out.write("    \t    \t\t    swalWithBootstrapButtons.fire(\r\n");
      out.write("    \t    \t\t      'Thất bại',\r\n");
      out.write("    \t    \t\t      'Bạn Chưa thực hiện xóa',\r\n");
      out.write("    \t    \t\t      'error'\r\n");
      out.write("    \t    \t\t    )\r\n");
      out.write("    \t    \t\t  }\r\n");
      out.write("    \t    \t\t})\r\n");
      out.write("    \t}));\r\n");
      out.write("        </script>\r\n");
      out.write("<!-- /. PAGE INNER  -->\r\n");
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
