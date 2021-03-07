<%@page import="models.CatUser"%>
<%@page import="java.util.List"%>
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
                <h2>Phân quyền tài khoản</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <%
        	//String urlSlugCatAdd = request.getContextPath()+"/admin/quan-ly-danh-muc/them-danh-muc"+".html";
        %>
        <div class="row">
            <div class="col-md-12">
                <!-- Advanced Tables -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="table-responsive">
                            <%-- <div class="row">
                              <div class="col-sm-6">
                                    <a href="" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: center;">
                                    <form method="GET" action="<%=request.getContextPath()%>/admin/cat/index">
                                        <input type="submit" name="search" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input type="search" name="nameCat" value="${nameCat}"class="form-control input-sm" placeholder="nhập loại tài khoản" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                            </div> --%>
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
                                        <th>Loại tài khoản</th>
                                        <th>Quyền thêm</th>
                                        <th>Quyền sửa</th>
                                        <th>Quyền xóa</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%
                                	List<CatUser> phanQuyenList = (List<CatUser>)request.getAttribute("phanQuyenList");
	                                if(phanQuyenList.size() > 0){
	                                	%>
		                                	<%
		                                		int i = 0;
		                                		for(CatUser phanQuyen : phanQuyenList){
		                                			i++;
		                                			int cuid = (Integer) phanQuyen.getId();
		                                			String cuname = phanQuyen.getName();
		                                			boolean addquyen = phanQuyen.isAddquyen();
		                                			boolean editquyen = phanQuyen.isEditquyen();
		                                			boolean delquyen = phanQuyen.isDelquyen();
		                                			%>
		                                				<tr>
						                                	<td><%=i %></td>
						                                	<td><%=cuname %></td>
						                                	<td>
						                                		<div class="form-group">
														    		<div class="col-sm-7 col-md-7">
														    			<div class="input-group">
														    				<div class="form-check form-check-inline">
																			  <input id="toggle-state" class="toggle-state-add" type="checkbox" data-toggle="toggle"
																			  	<%
																			  		if(addquyen == true){
																			  			out.print("checked");
																		  			}else{
																		  				out.print("unchecked");
																		  				};
																			  	%>
																			  	cuid=<%=cuid %>
																			  >
																				<div id="console-event"></div>
																			</div>
														    			</div>
														    		</div>
														    	</div>
						                                	</td>
						                                	<td>
						                                		<div class="form-group">
														    		<div class="col-sm-7 col-md-7">
														    			<div class="input-group">
														    				<div class="form-check form-check-inline">
																			  <input id="toggle-state" class="toggle-state-edit" type="checkbox" data-toggle="toggle"
																			  	<%
																			  		if(editquyen == true){
																			  			out.print("checked");
																		  			}else{
																		  				out.print("unchecked");
																		  				};
																			  	%>
																			  	cuid=<%=cuid %>
																			  >
																				<div id="console-event"></div>
																			</div>
														    			</div>
														    		</div>
														    	</div>
						                                	</td>
						                                	<td>
						                                		<div class="form-group">
														    		<div class="col-sm-7 col-md-7">
														    			<div class="input-group">
														    				<div class="form-check form-check-inline">
																			  <input id="toggle-state" class="toggle-state-del" type="checkbox" data-toggle="toggle"
																			  	<%
																			  		if(delquyen == true){
																			  			out.print("checked");
																		  			}else{
																		  				out.print("unchecked");
																		  				};
																			  	%>
																			  	cuid=<%=cuid %>
																			  >
																				<div id="console-event"></div>
																			</div>
														    			</div>
														    		</div>
														    	</div>
						                                	</td>
						                                </tr>
		                                			<%
		                                		}
		                                	%>
	                                	<%
	                                }
                                %>
	                                
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
                <!--End Advanced Tables -->
            </div>
        </div>
    </div>
</div>
<script>
    document.getElementById("usermanager").classList.add('active-menu');
</script>

<script>
    document.getElementById("phanquyen").classList.add('active-menu');
</script>
<script>
$(document).ready(function() {
	/* quyền thêm */
	$('.toggle-state-add').change(function() {
	     var giatri = $(this).prop('checked')
	     var cuid = $(this).attr("cuid")
	     const swalWithBootstrapButtons = Swal.mixin({
			  customClass: {
			    confirmButton: 'btn btn-success',
			    cancelButton: 'btn btn-danger'
			  },
			  buttonsStyling: false
			})
	      swalWithBootstrapButtons.fire({
	    	  title: 'Bạn có chắc chắn?',
	    	  text: "Thao tác này sẽ ảnh hưởng trực tiếp đến tài khoản của bạn!",
	    	  icon: 'warning',
	    	  showCancelButton: true,
	    	  confirmButtonText: 'Tiếp tục',
	    	  cancelButtonText: 'Hủy bỏ',
	    	  reverseButtons: true
		 }).then((result) => {
			   if (result.isConfirmed) { 
				   $.ajax({
		            type: "post",
		            url: "<%=request.getContextPath()%>/admin/user/phanquyen/addquyen",
		            data: {
		            	cuid:cuid,
		            	giatri:giatri
		            	},
		            context:this,
		            success: function (response) {
		              if(response == false)
		              {
		            	  swalWithBootstrapButtons.fire(
	    	                    'Thông Báo!',
	    	                    'Bạn không thể thêm quyền cho loại tài khoản này.',
	    	                    'danger'
	    	                ).then(function () {
	    	                    location.reload();
	    	                })
		              }else{
		            	  swalWithBootstrapButtons.fire(
	            			      'Thành công!',
	            			      'Thao tác thành công.',
	            			      'success'
	            			    ).then(function () {
  	    	                    location.reload();
  	    	                })
		              }
		            },
		            error: function (xhr, ajaxOptions, thrownError) {
		            	swalWithBootstrapButtons.fire(
	    	                    'Thông Báo!',
	    	                    'Thao tác không thể thực hiện.',
	    	                    'danger'
	    	                ).then(function () {
	    	                    location.reload();
	    	                })
	    	            }
			   });
			   }else if (result.dismiss === Swal.DismissReason.cancel) {
	    		    swalWithBootstrapButtons.fire(
  	    		      'Thất bại',
  	    		      'Bạn đã hủy thao tác',
  	    		      'error'
  	    		    ).then(function () {
	                    location.reload();
	                })
  	    		  }
	    })
	})
	/* quyền sửa */
	$('.toggle-state-edit').change(function() {
	     var giatri = $(this).prop('checked')
	     var cuid = $(this).attr("cuid")
	     const swalWithBootstrapButtons = Swal.mixin({
			  customClass: {
			    confirmButton: 'btn btn-success',
			    cancelButton: 'btn btn-danger'
			  },
			  buttonsStyling: false
			})
	      swalWithBootstrapButtons.fire({
	    	  title: 'Bạn có chắc chắn?',
	    	  text: "Thao tác này sẽ ảnh hưởng trực tiếp đến tài khoản của bạn!",
	    	  icon: 'warning',
	    	  showCancelButton: true,
	    	  confirmButtonText: 'Tiếp tục',
	    	  cancelButtonText: 'Hủy bỏ',
	    	  reverseButtons: true
		 }).then((result) => {
			   if (result.isConfirmed) { 
				   $.ajax({
		            type: "post",
		            url: "<%=request.getContextPath()%>/admin/user/phanquyen/editquyen",
		            data: {
		            	cuid:cuid,
		            	giatri:giatri
		            	},
		            context:this,
		            success: function (response) {
		              if(response == false)
		              {
		            	  swalWithBootstrapButtons.fire(
	    	                    'Thông Báo!',
	    	                    'Bạn không thể thêm quyền cho loại tài khoản này.',
	    	                    'danger'
	    	                ).then(function () {
	    	                    location.reload();
	    	                })
		              }else{
		            	  swalWithBootstrapButtons.fire(
	            			      'Thành công!',
	            			      'Thao tác thành công.',
	            			      'success'
	            			    ).then(function () {
  	    	                    location.reload();
  	    	                })
		              }
		            },
		            error: function (xhr, ajaxOptions, thrownError) {
		            	swalWithBootstrapButtons.fire(
	    	                    'Thông Báo!',
	    	                    'Thao tác không thể thực hiện.',
	    	                    'danger'
	    	                ).then(function () {
	    	                    location.reload();
	    	                })
	    	            }
			   });
			   }else if (result.dismiss === Swal.DismissReason.cancel) {
	    		    swalWithBootstrapButtons.fire(
  	    		      'Thất bại',
  	    		      'Bạn đã hủy thao tác',
  	    		      'error'
  	    		    ).then(function () {
	                    location.reload();
	                })
  	    		  }
	    })
	})
	/* quyền xóa */
	$('.toggle-state-del').change(function() {
	     var giatri = $(this).prop('checked')
	     var cuid = $(this).attr("cuid")
	     const swalWithBootstrapButtons = Swal.mixin({
			  customClass: {
			    confirmButton: 'btn btn-success',
			    cancelButton: 'btn btn-danger'
			  },
			  buttonsStyling: false
			})
	      swalWithBootstrapButtons.fire({
	    	  title: 'Bạn có chắc chắn?',
	    	  text: "Thao tác này sẽ ảnh hưởng trực tiếp đến tài khoản của bạn!",
	    	  icon: 'warning',
	    	  showCancelButton: true,
	    	  confirmButtonText: 'Tiếp tục',
	    	  cancelButtonText: 'Hủy bỏ',
	    	  reverseButtons: true
		 }).then((result) => {
			   if (result.isConfirmed) { 
				   $.ajax({
		            type: "post",
		            url: "<%=request.getContextPath()%>/admin/user/phanquyen/delquyen",
		            data: {
		            	cuid:cuid,
		            	giatri:giatri
		            	},
		            context:this,
		            success: function (response) {
		              if(response == false)
		              {
		            	  swalWithBootstrapButtons.fire(
	    	                    'Thông Báo!',
	    	                    'Bạn không thể thêm quyền cho loại tài khoản này.',
	    	                    'danger'
	    	                ).then(function () {
	    	                    location.reload();
	    	                })
		              }else{
		            	  swalWithBootstrapButtons.fire(
	            			      'Thành công!',
	            			      'Thao tác thành công.',
	            			      'success'
	            			    ).then(function () {
  	    	                    location.reload();
  	    	                })
		              }
		            },
		            error: function (xhr, ajaxOptions, thrownError) {
		            	swalWithBootstrapButtons.fire(
	    	                    'Thông Báo!',
	    	                    'Thao tác không thể thực hiện.',
	    	                    'danger'
	    	                ).then(function () {
	    	                    location.reload();
	    	                })
	    	            }
			   });
			   }else if (result.dismiss === Swal.DismissReason.cancel) {
	    		    swalWithBootstrapButtons.fire(
  	    		      'Thất bại',
  	    		      'Bạn đã hủy thao tác',
  	    		      'error'
  	    		    ).then(function () {
	                    location.reload();
	                })
  	    		  }
	    })
	})
});
	
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>