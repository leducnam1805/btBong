<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="models.Songs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<div class="content_resize">
  <div class="mainbar">
  <%
  		List<Songs> songList = (List<Songs>)request.getAttribute("songList");
  		if(songList.size() > 0){
  			Songs objsong = songList.get(0);
  	  		int idCategory = objsong.getCat().getId();
  			%>
  				<div class="article">
					<h1><%=objsong.getCat().getName() %></h1>
				</div>
  			<%
  			int i = 0;
  			for(Songs song : songList){
  				i++;
  	  			int idSong = song.getId();
  	  			String nameSong = song.getName();
  	  			// song date Create
  	  			Timestamp date = song.getCreatedAt();
  	  			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY hh:mm:ss");
  	  			int counter = song.getCounter();
  	  			String picture = song.getPicture();
  	  			String description = song.getDescription();
  	  			String detail = song.getDetail();
  	  			// song date Create
  	  			//category
  	  			int idCat = song.getCat().getId();
  	  			String nameCat = song.getCat().getName();
  	  			//category
  	  			// mapping url
  	  			String urlSlug = request.getContextPath()+"/chi-tiet/"+StringUtil.makeSlug(song.getName())+"-"+song.getId()+".html";
  	  			%>
  				    <div class="article">
  				      <h2><a href="" title="<%=nameSong%>" style="text-decoration: none;"><%=nameSong %></a></h2>
  				      <p class="infopost">Ngày đăng: <%=sdf.format(date) %>. Lượt xem: <%=counter %> <a href="#" class="com"><span><%=i %></span></a></p>
  				      <div class="clr"></div>
  				      <%
  				      	if(!"".equals(picture)){
  				      		%>
  				      			<div class="img"><img src="<%=request.getContextPath()%>/uploads/images/<%=picture %>" width="177" height="213" alt="<%=nameSong %>" class="fl" /></div>
  				      		<%
  				      	}else{
  				      		%>
  				      			<div class="img"><img src="<%=request.getContextPath()%>/templates/admin/assets/img/noimage.gif" width="177" height="213" alt="Đổi thay" class="fl" /></div>
  				      		<%
  				      	}
  				      %>
  				      
  				      <div class="post_content">
  				        <p><%=description%></p>
  				        <p class="spec"><a href="<%=urlSlug %>" class="rm">Chi tiết &raquo;</a></p>
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
	  				for(int j = 1; j <= numberOfPage; j++ ){
	  					%>
		  					<%
		  						if(currentPage == j){
		  							%>
		  								<span><%=j %></span>
		  							<%
		  						}else{
		  							%>
		  								<a href="<%=request.getContextPath()%>/cat?cid=<%=idCategory%>&page=<%=j%>"><%=j %></a>
		  							<%
		  						}
		  					%>
	  					<%
	  				}
	  			%>
		  	    </p>
	  		<%
	  	}
  		}else{
  			%>
  				<div class="article">
					<h1>Không có bài hát</h1>
				</div>
  			<%
  		}
  %>
  
  </div>
  <div class="sidebar">
     <%@ include file="/templates/public/inc/leftbar.jsp" %>
  </div>
  <div class="clr"></div>
</div>
<%@ include file="/templates/public/inc/footer.jsp" %>