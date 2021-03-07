<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="models.Songs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<div class="content_resize">
  <div class="mainbar">
  <%
  	if(request.getAttribute("songList") != null){
  		Songs song = (Songs) request.getAttribute("songList");
  		int id = song.getId();
  		int idcat = song.getCat().getId();
  		String catName = song.getCat().getName();
  		// ngày đăng
  		Timestamp date = song.getCreatedAt();
  		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY hh:mm:ss");
  		// ngày đăng
  		int counter = song.getCounter();
  		String description = song.getDescription();
  		String detail = song.getDetail();
  		String picture = song.getPicture();
  		%>
  			<div class="article">
		      <h1><%=catName %></h1>
		      <div class="clr"></div>
		      <p class="infopost">Ngày đăng: <%=sdf.format(date) %>. Lượt xem: <%=counter %> </p>
		      <%
		      	if(!"".equals(picture)){
		      		%>
		      		<div class="img">
		      			<img alt="" src="<%=request.getContextPath()%>/uploads/images/<%=picture%>"width="200px" height="200px">
		      		</div>
		      		<%
		      	}else{
		      		%>
		      		<div class="img">
		      			<img src="<%=request.getContextPath()%>/templates/admin/assets/img/noimage.gif" width="177" height="213" alt="no-image" class="fl" />
		      		</div>
					<%
		      	}
		      %>
		      <div class="clr"></div>
		      <div class="vnecontent">
		         <%=detail %>
		      </div>
		    </div>
		    <%
  	}
  %>
  			<div class="clr"></div>
		    <div class="article">
		      <h2>Bài viết liên quan</h2>
		      <div class="clr"></div>
		      <%
		      	if(request.getAttribute("relatedSong")!=null){
		      		List<Songs> relatedSong = (List<Songs>)request.getAttribute("relatedSong");
		      		if(relatedSong.size() > 0){
		      			for(Songs cat : relatedSong){
			      			int idCat = cat.getId();
			      			String name = cat.getName();
			      			String description = cat.getDescription();
			      			String picture = cat.getPicture();
			      			String urlSlug = request.getContextPath()+"/chi-tiet/"+StringUtil.makeSlug(cat.getName())+"-"+cat.getId()+".html";
			      			%>
			      				<div class="comment">
			      				<%
			      					if(!"".equals(picture)){
			      						%>
			      							<a href=""><img src="<%=request.getContextPath()%>/uploads/images/<%=picture %>" width="40" height="40" alt="image" class="userpic" /></a>
			      						<%
			      					}else{
			      						%>
		      							<a href=""><img src="<%=request.getContextPath()%>/templates/admin/assets/img/noimage.gif" width="40" height="40" alt="no-images" class="userpic" /></a>
		      							<%
			      					}
			      				%>
							        <h2><a href="<%=urlSlug%>"><%=name %></a></h2>
							        <p><%=description %></p>
							    </div>
				      		<%
			      		}
		      		}else{
		      			%>
		      				<div class="alert alert-success" role="alert">
							 Không có bài viết liên quan
							</div>
		      			<%
		      		}
		      	}
		      %>
		    </div>
  		
  </div>
  <div class="sidebar">
  <%@ include file="/templates/public/inc/leftbar.jsp" %>
  </div>
  <div class="clr"></div>
</div>
<%@ include file="/templates/public/inc/footer.jsp" %>
