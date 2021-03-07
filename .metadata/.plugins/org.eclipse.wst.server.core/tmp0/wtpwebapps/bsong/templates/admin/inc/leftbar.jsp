<%@page import="models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    
    			<nav class="navbar-default navbar-side" role="navigation">
			    <div class="sidebar-collapse">
			        <ul class="nav"id="main-menu">
			            <li class="text-center">
			                <img src="<%=request.getContextPath() %>/templates/admin/assets/img/zing.png" class="user-image img-responsive" />
			            </li>
			            <li>
			                <a id="index" href="<%=request.getContextPath()%>/admin"><i class="fa fa-dashboard fa-3x"></i> Trang chủ</a>
			            </li>
			            <li>
			                <a id="category" href="<%=request.getContextPath()%>/admin/cat/index"><i class="fa fa-list fa-3x"></i> Quản lý danh mục</a>
			            </li>
			            <li>
			                <a id="song" href="<%=request.getContextPath()%>/admin/song/index"><i class="fa fa-music fa-3x"></i> Quản lý bài hát</a>
			            </li>
			            <%
			            	if(session.getAttribute("userInfor") != null){
			            		User user = (User) session.getAttribute("userInfor");
			            		if(user.getCatUser().getId() < 3){
			            			%>
			            				<li>
							                <a id="usermanager" href=""><i class="fa fa-user fa-3x"></i> Quản lý người dùng&emsp;&emsp;&nbsp;<i class="fa fa-caret-down fa-2x" aria-hidden="true"></i></a>
							                <ul class="nav"id="main-menu" style="font-size:15px;">
								                <%
								                	if(user.getCatUser().getId() < 2){
								                		%>
								                			<li><a id="phanquyen" href="<%=request.getContextPath()%>/admin/user/phanquyen"><i class="fa fa-share fa-2x" aria-hidden="true"></i>&nbsp;Phân quyền</a></li>
								                		<%
								                	}
								                %>
							                	<li><a id="catuser" href="<%=request.getContextPath()%>/admin/catuser/index"><i class="fa fa-share fa-2x" aria-hidden="true"></i>&nbsp;Loại tài khoản</a></li>
							                	<li><a id="user" href="<%=request.getContextPath()%>/admin/user/index"><i class="fa fa-share fa-2x" aria-hidden="true"></i>&nbsp;Người dùng</a></li>
							                </ul>
							            </li>
			            			<%
			            		}
			            	}
			            %>
			            <li>
			                <a id="contact" href="<%=request.getContextPath()%>/admin/contact/index"><i class="fa fa-envelope fa-3x"></i> Quản lý liên hệ</a>
			            </li>
			        </ul>
			    </div>
			</nav>
			 <script type="text/javascript">
				if(window.location.hash) {	
					var hash = window.location.hash.substring(1);	
					$('.nav a[id="' + hash + '"]').tab('show');
				}
			</script>
