<%@page import="models.CatUser"%>
<%@page import="java.util.List"%>
<%@page import="models.User"%>
<%@page import="models.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Sửa tài khoản</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
         <%
      	if(request.getAttribute("err")!= null){
      		%>
      			<div class="alert alert-danger" role="alert">
				  <p style="color:red; font-size:20px;">${err}</p>
				</div>
      		<%
      	}
     	 %>
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form role="form" method="post"id="form" action="<%=request.getContextPath()%>/admin/user/edit">
                                <%
                                	if(request.getAttribute("user") != null){
                                		User user = (User)request.getAttribute("user");
                                		int idUser = user.getId();
                                		%>
                                			<div class="form-group">
		                                        <input type="hidden" id="id" value="<%=user.getId() %>" name="id" class="form-control" />
		                                    </div>
		                                    <div class="form-group">
		                                        <label for="username">Tên tài khoản</label>
		                                        <input type="text" id="username" value="<%=user.getUsername()%>" name="username" class="form-control" disabled="disabled"/>
		                                    </div>
		                                    <div class="form-group">
		                                        <label for="pass">Mật khẩu</label>
		                                        <input type="password" id="pass" value="" name="pass" class="form-control" />
		                                    </div>
		                                    <div class="form-group">
		                                        <label for="fullname">Tên đầy đủ</label>
		                                        <input type="text" id="fullname" value="<%=user.getFullname() %>" name="fullname" class="form-control" />
		                                    </div>
		                                    <div class="form-group">
		                                        <label for="category">Loại tài khoản</label>
		                                        <select id="category" name="categoriesuser" class="form-control">
		                                        	<%
		                                        		if(request.getAttribute("catUser") != null){
		                                        			List<CatUser> catUserList = (List<CatUser>) request.getAttribute("catUser");
		                                        			if(catUserList.size() > 0){
		                                        				for(CatUser catUser : catUserList){
		                                        					int idCatUser = catUser.getId();
		                                        					String catUserName = catUser.getName();
	                                        						%>
	                                        							<option value="<%=idCatUser%>"
	                                        								<%
		                                        								if(idUser == idCatUser) out.print("selected");
	                                        								%>
	                                        							><%=catUserName %></option>
	                                        						<%
		                                        				}
		                                        			}
		                                        		}
		                                        	%>
		                                        </select>
		                                    </div>
                                		<%
                                	}
                                %>
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Sửa</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Form Elements -->
            </div>
        </div>
        <!-- /. ROW  -->
    </div>
    <!-- /. PAGE INNER  -->
</div>
<script>
    document.getElementById("song").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>