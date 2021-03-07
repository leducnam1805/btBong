<%@page import="java.util.List"%>
<%@page import="models.Songs"%>
<%@page import="models.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Sửa bài hát</h2>
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
                                <form role="form" method="post"id="form" action="<%=request.getContextPath()%>/admin/song/edit" enctype='multipart/form-data'>
                                <%
                                	if(request.getAttribute("song") != null){
                                		Songs song = (Songs)request.getAttribute("song");
                                		int idCatSong = song.getCat().getId();
                                		String picture = song.getPicture();
                                		%>
                                			<div class="form-group">
		                                        <input type="hidden" id="id" value="<%=song.getId() %>" name="sid" class="form-control" />
		                                    </div>
		                                    <div class="form-group">
		                                        <label for="name">Tên bài hát</label>
		                                        <input type="text" id="name" value="<%=song.getName() %>" name="name" class="form-control" />
		                                    </div>
		                                    <div class="form-group">
		                                        <label for="category">Danh mục bài hát</label>
		                                        <select id="category" name="category" class="form-control">
		                                        	<%
		                                        		if(request.getAttribute("catList") != null){
		                                        			List<Category> catList = (List<Category>)request.getAttribute("catList");
		                                        			if(catList.size() > 0){
		                                        				for(Category cat : catList){
		                                        					int idCate = cat.getId();
		                                        					String catName = cat.getName();
	                                        						%>
	                                        							<option value="<%=idCate%>"
	                                        								<%
		                                        								if(idCatSong == idCate) out.print("selected");
	                                        								%>
	                                        							><%=catName %></option>
	                                        						<%
		                                        				}
		                                        			}
		                                        		}
		                                        	%>
		                                        </select>
		                                    </div>
		                                    <div class="form-group">
		                                        <label for="picture">Hình ảnh</label>
			                                        <input type="file" name="picture" id="picture"/>
			                                        <%
			                                        	if(!"".equals(picture)){
			                                        		%>
			                                        			<img src = "<%=request.getContextPath()%>/uploads/images/<%=picture %>" alt="hinhanh"
						                                        	width="200px" height="200px" id="blah"
						                                        />
			                                        		<%
			                                        	}else{
			                                        		%>
			                                        			<img width="200px" height="200px" src="<%=request.getContextPath()%>/templates/admin/assets/img/noimage.gif" alt="no-image"/>
			                                        		<%
			                                        	}
			                                        %>
			                                        
		                                    </div>
		                                    <div class="form-group">
		                                        <label for="preview">Mô tả</label>
		                                        <textarea id="preview" class="form-control" rows="3" name="preview"><%=song.getDescription() %></textarea>
		                                    </div>
		                                    <div class="form-group">
		                                        <label for="detail">Chi tiết</label>
		                                        <textarea id="detail" class="form-control" id="detail" rows="5" name="detail"><%=song.getDetail() %></textarea>
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
	
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>