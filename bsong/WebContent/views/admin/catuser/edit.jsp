<%@page import="models.CatUser"%>
<%@page import="models.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Sửa loại tài khoản</h2>
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
                                <form role="form" method="post"id="form" action="<%=request.getContextPath()%>/admin/catuser/edit">
                                <%
                                	if(request.getAttribute("catUser") != null){
                                		CatUser catUser = (CatUser)request.getAttribute("catUser");
                                		%>
                                			<div class="form-group">
		                                        <input type="hidden" id="id" value="<%=catUser.getId() %>" name="id" class="form-control" />
		                                    </div>
		                                    <div class="form-group">
		                                        <label for="name">Tên loại tài khoản</label>
		                                        <input type="text" id="name" value="<%=catUser.getName()%>" name="name" class="form-control" />
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