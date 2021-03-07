<%@page import="util.StringUtil"%>
<%@page import="models.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý danh mục</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Advanced Tables -->
                <div class="panel panel-default">
                    <div class="panel-body">
						<%
							if(session.getAttribute("userInfor") != null){
								User checkUser = (User) session.getAttribute("userInfor");
								%>
									<div class="table-responsive">
			                            <div class="row">
			                            <%
			                            	if(checkUser.getCatUser().isAddquyen() == true){
			                            		%>
			                            			<div class="col-sm-6">
					                                    <a href="<%=request.getContextPath()%>/admin/cat/add" class="btn btn-success btn-md">Thêm</a>
					                                </div>
			                            		<%
			                            	}
			                            %>
			                                <div class="col-sm-6" style="text-align: right;">
			                                    <form method="GET" action="<%=request.getContextPath()%>/admin/cat/index">
			                                        <input type="submit" name="search" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
			                                        <input type="search" name="nameCat" value="${nameCat}"class="form-control input-sm" placeholder="Nhập tên danh mục" style="float:right; width: 300px;" />
			                                        <div style="clear:both"></div>
			                                    </form><br />
			                                </div>
			                            </div>
										<%
											if(!"".equals(request.getParameter("msg"))){
												String msg = request.getParameter("msg");
												if("OK".equals(msg)){
													%>
														<div class="alert alert-success" role="alert">
															 Xử lý thành công!
														</div>
													<%
												}
											}
										%>
			                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
			                                <thead>
			                                    <tr>
			                                        <th>STT</th>
			                                        <th>Tên danh mục</th>
			                                        <th width="160px">Chức năng</th>
			                                    </tr>
			                                </thead>
			                                <tbody>
			                                <%
			                                	if(request.getAttribute("catList")!= null){
			                                		ArrayList<Category> catList = (ArrayList<Category>) request.getAttribute("catList");
			                                		if(catList.size() > 0){
			                                			%>
			                                				<%
			                                					int i = 0;
				                                				for(Category cat : catList){
				                                					i++;
				                                    				int id = cat.getId();
				                                    				String name = cat.getName();
				                                    				//String urlSlugCatEdit = request.getContextPath()+"/admin/quan-ly-danh-muc/sua-danh-muc/"+StringUtil.makeSlug(cat.getName())+"-"+cat.getId()+".html";
				                                    				// String urledit = request.getContextPath()+"/admin/cat/edit?cid="+id;
				                                    				// String urlDel = request.getContextPath()+"/admin/cat/del?cid="+id;
				                                    				%>
				                                    					<tr>
				    				                                        <td><%=i %></td>
				    				                                        <td class="center"><%=name %></td>
				    				                                        <td class="center">
				    				                                        <%
												                            	if(checkUser.getCatUser().isEditquyen() == true){
												                            		%>
												                            			<a href="<%=request.getContextPath()%>/admin/cat/edit?cid=<%=id %>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
												                            		<%
												                            	}
												                            %>
												                            <%
												                            	if(checkUser.getCatUser().isDelquyen() == true){
												                            		%>
												                            			<a idCategory=<%=id%> title="" class="btn btn-danger del-cat"><i class="fa fa-pencil"></i> Xóa</a>
												                            		<%
												                            	}
												                            %>
				    				                                        </td>
				    				                                    </tr>
				                                    				<%
				                                    			}
			                                				%>
			                                				<%
			                                				int numberOfPage = (Integer)request.getAttribute("numberOfPage");
				                                		  	int currentPage = (Integer)request.getAttribute("currentPage");
				                                		  	if(catList != null && catList.size() > 0){
				                                		  		%>
				                                		  			<div class="row">
									                                <!-- <div class="col-sm-6">
									                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Hiển thị từ 1 đến 5 của 24 truyện</div>
									                                </div> -->
									                                <div class="col-sm-6" style="text-align: right;">
									                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
									                                        <ul class="pagination">
									                                            <!-- <li class="paginate_button previous disabled" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="#">Trang trước</a></li> -->
									                                            <%
									                                            	for(int j = 1; j <= numberOfPage;j++){
									                                            		%>
									                                            			<%
									                                            				if(currentPage == j){
									                                            					%>
									                                            						<li class="paginate_button active" aria-controls="dataTables-example" tabindex="0"><a href=""><%=j %></a></li>
									                                            					<%
									                                            				}else{
									                                            					%>
									                                            						<li class="paginate_button" aria-controls="dataTables-example" tabindex="0">
									                                            							<a href="<%=request.getContextPath()%>/admin/cat/index?page=<%=j%>"><%=j%></a>
									                                            						</li>
									                                            					<%
									                                            				}
									                                            			%>
									                                            		<%
									                                            	}
									                                            %>
									                                            <!-- <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="#">Trang tiếp</a></li> -->
									                                        </ul>
									                                    </div>
									                                </div>
									                            </div>
				                                		  		<%
				                                		  	}
			                                				%>
			                                			<%
			                                		}
			                                	}
			                                %>
			                                    
			                                </tbody>
			                            </table>
			                        </div>
								<%
							}else{
								%>
									<div class="alert alert-danger" role="alert">
									   Chúng tôi đang khắc phục sự cố. Xin lỗi vì sự bất tiện này.!
									</div>
								<%
							}
						%>                    
                        

                    </div>
                </div>
                <!--End Advanced Tables -->
            </div>
        </div>
    </div>
</div>
<script>
    document.getElementById("category").classList.add('active-menu');
</script>
<script>
        $(document).on("click", "a.del-cat", (function () {
        	//lấy dữ liêu
    	    var id = $(this).attr("idCategory");
    	    const swalWithBootstrapButtons = Swal.mixin({
    	    	  customClass: {
    	    	    confirmButton: 'btn btn-success',
    	    	    cancelButton: 'btn btn-danger'
    	    	  },
    	    	  buttonsStyling: false
    	    	})
    	    swal.fire({
    	        title: 'Bạn Có Chắc Chắn?',
    	        text: "Dữ Liệu Sẽ Không Thể Phục Hồi!",
    	        icon: 'warning',
    	        padding: '3em',
    	        showCancelButton: true,
    	        confirmButtonColor: '#3085d6',
    	        cancelButtonColor: '#d33',
    	        confirmButtonText: 'Đồng Ý, Xóa!',
    	        cancelButtonText: 'Hủy bỏ',
    	        reverseButtons: true,
    	        customClass: null
    	    }).then((result) => {
    	    	  if (result.value) {
    	    		  $.ajax({
    	    			  	async: false,
    	    	            type: "get",
    	    	            url: "<%=request.getContextPath()%>/admin/cat/del",
    	    	            data: { cid : id },
    	    	            success: function (data) {
    	    	            	if(data==false){
	   	    	            		Swal.fire(
   	    	    	                    'Thông Báo!',
   	    	    	                    'Bạn không thể xóa loại tài khoản này.',
   	    	    	                    'danger'
   	    	    	                ).then(function () {
   	    	    	                    location.reload();
   	    	    	                })
    	    	            	}else{
   	    	            			Swal.fire(
	   	            			      'Thành công!',
	   	            			      'Bạn đã xóa thành công.',
	   	            			      'success'
	   	            			    ).then(function () {
   	    	    	                    location.reload();
   	    	    	                })
    	    	            	}
    	    	            },
    	    	            error: function (xhr, ajaxOptions, thrownError) {
    	    	                Swal.fire(
    	    	                    'Thông Báo!',
    	    	                    'Thao tác không thể thực hiện.',
    	    	                    'danger'
    	    	                ).then(function () {
    	    	                    location.reload();
    	    	                })
    	    	            }
    	    	        });
    	    		  } else if (result.dismiss === Swal.DismissReason.cancel) {
    	    		    swalWithBootstrapButtons.fire(
    	    		      'Thất bại',
    	    		      'Bạn Chưa thực hiện xóa',
    	    		      'error'
    	    		    )
    	    		  }
    	    		})
    	}));
        </script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>