<%@page import="models.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm bài hát</h2>
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
                            <%
                            		String name = request.getParameter("name");
                            		String des = request.getParameter("preview");
                            		String detail = request.getParameter("detail");
                            		%>
                            			<form role="form" method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/admin/song/add"id="form">
		                                    <div class="form-group">
		                                        <label for="name">Tên bài hát</label>
		                                        <input type="text" id="name" value="<%if(name!=null) out.print(name);  %>" name="name" class="form-control" />
		                                    </div>
		                                    <div class="form-group">
		                                        <label for="category">Danh mục bài hát</label>
		                                        <select id="category" name="category" class="form-control">
		                                        <%
		                                        	if(request.getAttribute("catList") != null){
		                                        		List<Category> catList = (List<Category>)request.getAttribute("catList");
		                                        		if(catList.size() > 0){
		                                        			for(Category cat : catList){
		                                        				%>
		                                        					<option value="<%=cat.getId()%>"><%=cat.getName() %></option>
		                                        				<%
		                                        			}
		                                        		}
		                                        	}
		                                        %>
		                                        </select>
		                                    </div>
		                                    <div class="form-group">
		                                        <label for="picture">Hình ảnh</label>
		                                        <input type="file" name="picture" id="picture" class="picture"/>
		                                        <img id="blah" src="<%=request.getContextPath()%>/templates/admin/assets/img/noimage.gif" alt="hinhanh" style="width:200px;height:250px;margin-top: 10px;"/>
		                                    </div>
		                                    <div class="form-group">
		                                        <label for="preview">Mô tả</label>
		                                        <textarea id="preview" class="form-control" rows="3" name="preview"><%if(des!=null) out.print(des);%></textarea>
		                                    </div>
		                                    <div class="form-group">
		                                        <label for="detail">Chi tiết</label>
		                                        <textarea id="detail" class="form-control" id="detail" rows="5" name="detail"><%if(detail!=null) out.print(detail);%></textarea>
		                                    </div>
		                                    <button type="submit" name="submit" class="btn btn-success btn-md">Thêm</button>
		                                </form>
                            		<%
                            %>
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
<script>
	function readURL(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    
	    reader.onload = function(e) {
	      $('#blah').attr('src', e.target.result);
	    }
	    
	    reader.readAsDataURL(input.files[0]); // convert to base64 string
	  }
	}
	$("#picture").change(function() {
	  readURL(this);
	});
	$(document).on("click",".del-image-js",function(){
		$(".picture").remove();
	})
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>