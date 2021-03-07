<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="models.Songs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<div class="content_resize">
  <div class="mainbar">
  
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
  <%
  	if(request.getAttribute("songList") != null){
  		List<Songs> songList = (List<Songs>)request.getAttribute("songList");
  		if(songList.size() > 0){
  			Songs objsong = songList.get(0);
  			%>
  				<div class="article">
					<h1>Bài hát mới nhất</h1>
				</div>
	  			<%
	  			int i = 0;
	  			for(Songs song : songList){
	  				i++;
		  			int id = song.getId();
		  			String name = song.getName();
		  			//date_create
		  			Timestamp date = song.getCreatedAt();
		  			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY hh:mm:ss");
		  			//date_create
		  			int counter = song.getCounter();
		  			String picture = song.getPicture();
		  			String description = song.getDescription();
		  			String detail = song.getDetail();
		  			// map url
		  	  		String urlSlug = request.getContextPath()+"/chi-tiet/"+ StringUtil.makeSlug(song.getName()) + "-" + song.getId()+".html";
		  			%>
		  				<div class="article">
					      <h2><a href="" title="<%=name%>" style="text-decoration: none;"><%=name%></a></h2>
					      <p class="infopost">Ngày đăng: <%=sdf.format(date) %> Lượt xem: <%=counter %> <a href="#" class="com"><span><%=i%></span></a></p>
					      <div class="clr"></div>
					      <%
					      	if(!"".equals(picture)){
					      		%>
					      			<div class="img"><img src="<%=request.getContextPath() %>/uploads/images/<%=picture %>" width="177" height="213" alt="Đổi thay" class="fl" /></div>
					      		<%
					      	}else{
					      		%>
					      		<div class="img"><img src="<%=request.getContextPath()%>/templates/admin/assets/img/noimage.gif" width="177" height="213" alt="no-image" class="fl" /></div>
		            			<%
					      	}
					      %>
					      
					      <div class="post_content">
					        <p><%=description %></p>
					        <p class="spec"><a href="<%=urlSlug%>" class="rm">Chi tiết &raquo;</a></p>
					      </div>
					      <div class="clr"></div>
					    </div>
		  			<%
		  		}
  			%>
  			<%
  				int numberOfPage = (Integer)request.getAttribute("numberOfPage");
  				int currentPage = (Integer)request.getAttribute("currentPage");
  				if(songList != null && songList.size() > 0){
  					%>
  						<p class="pages"><!-- <small>Trang 1 của 5</small> -->
						    <%
						    	for(int j = 1; j <= numberOfPage; j++){
						    		///home?page=1
						    		String urlSug = request.getContextPath()+"/trang-"+j+".html";
						    		%>
						    			<%
						    				if(currentPage == j){
						    					%>
						    						<span><%=j %></span>
						    					<%
						    				}else{
						    					%>
						    						<a href="<%=urlSug%>"><%=j %></a>
						    					<%
						    				}
						    			%>
						    		<%
						    	}
						    %>
						    <!-- <a href="#">&raquo;</a> -->
						</p>
  					<%
  				}
  			%>
  			<%
  		}else{
  			%>
				<div class="article">
					<h1>Không có bài hát</h1>
				</div>
			<%
		}
  	}
  %>
  </div>
  <script type="text/javascript">
  document.getElementById("trang-chu").classList.add('active-menu');
  </script>
  <script type="text/javascript">
  document.getElementById("lien-he").classList.add('active-menu');
  </script>
  <div class="sidebar">
      <%@ include file="/templates/public/inc/leftbar.jsp" %>
  </div>
  
  <div class="clr"></div>
</div>
<%@ include file="/templates/public/inc/footer.jsp" %>
