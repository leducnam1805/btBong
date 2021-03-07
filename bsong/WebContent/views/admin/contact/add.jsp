<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm danh mục</h2>
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
                                <form role="form" method="post"id="form">
                                    <div class="form-group">
                                        <label for="name">Tên người liên hệ</label>
                                        <input type="text" id="name" value="${name}" name="name" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="text" id="email" value="${email}" name="email" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="website">Website</label>
                                        <input type="text" id="website" value="" name="website" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                       <textarea rows="9" cols="60" name="message">${message}</textarea>
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