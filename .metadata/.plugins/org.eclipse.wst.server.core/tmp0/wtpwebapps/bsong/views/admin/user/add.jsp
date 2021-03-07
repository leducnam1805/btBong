<%@page import="models.CatUser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm tài khoản</h2>
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
                                <form role="form" method="post"id="form" action="<%=request.getContextPath()%>/admin/user/add">
                                	<div class="form-group">
                                        <label for="username">Tên đăng nhập</label>
                                        <input type="text" id="username" value="${username}" name="username" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="pass">Mật khẩu</label>
                                        <input type="password" id="pass" value="" name="pass" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="fullname">Tên đầy đủ</label>
                                        <input type="text" id="fullname" value="${fullname}" name="fullname" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="category">Loại tài khoản</label>
                                        <select id="category" name="categoriesuser" class="form-control">
                                        <%
                                        	if(request.getAttribute("catUserList") != null){
                                        		List<CatUser> catUserList = (List<CatUser>)request.getAttribute("catUserList");
                                        		if(catUserList.size() > 0){
                                        			for(CatUser catUser : catUserList){
                                        				%>
                                        					<option value="<%=catUser.getId()%>"><%=catUser.getName() %></option>
                                        				<%
                                        			}
                                        		}
                                        	}
                                        %>
                                        </select>
                                    </div>
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Thêm</button>
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