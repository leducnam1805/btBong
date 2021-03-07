<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Login</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                            <%
                            	if(request.getParameter("msg")!= null){
                            		%>
                            			<div class="alert alert-danger" role="alert">
                            		  		Sai tên đăng nhập hoặc mật khẩu
                            			</div>
                            		<%
                            	}
                            %>
                                <form role="form" method="post"id="form" action ="<%=request.getContextPath()%>/auth/login">
                                    <div class="form-group">
                                        <label for="name">Tên đăng nhập</label>
                                        <input type="text" id="name" value="" name="username" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="pass">Mật khẩu</label>
                                        <input type="password" id="pass" value="" name="pass" class="form-control" />
                                    </div>
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Đăng nhập</button>
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