<%@page import="java.util.StringTokenizer"%>
<%@page import="util.StringUtil"%>
<%@page import="models.Songs"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<div class="searchform">
  <form id="formsearch" name="formsearch" method="GET" action="<%=request.getContextPath()%>/index.jsp">
    <span>
    <input name="editbox_search" value="${editbox_search}"class="editbox_search" id="editbox_search" maxlength="80" value="Tìm kiếm bài hát" type="text" />
    </span>
    <input name="button_search" src="<%=request.getContextPath() %>/templates/public/images/search.jpg" class="button_search" type="image" />
  </form>
</div>
<div class="clr"></div>
<div class="gadget">
  <h2 class="star">Danh mục bài hát</h2>
  <div class="clr"></div>
  <ul class="sb_menu">
  <%
  	if(request.getAttribute("catList") != null){
		List<Category> catList = (ArrayList<Category>)request.getAttribute("catList");
		for(Category cat : catList){
			String urlSlug = request.getContextPath()+"/danh-muc/"+ StringUtil.makeSlug(cat.getName()) + "-" + cat.getId()+".html";
			%>
				<li><a href="<%=urlSlug%>"><%=cat.getName() %></a></li>
			<%
		}
  	}
  %>
  </ul>
</div>

<div class="gadget">
  <h2 class="star"><span>Bài hát mới</span></h2>
  <div class="clr"></div>
  <%
  	if(request.getAttribute("songListFL") != null){
  		List<Songs> songListFL = (List<Songs>)request.getAttribute("songListFL");
  		%>
  			 <ul class="ex_menu">
	  			<%
	  			int i = 0;
	  				for(Songs song : songListFL){
	  					i++;
	  					int id = song.getId();
	  					String name = song.getName();
	  					String description = song.getDescription();
	  					// cắt chuỗi tại vị trí thứ 10
	  					//String [] chuoi = description.split("\\s",0);
	  					//String chuoi1 = chuoi[0];
	  					//String chuoi2 = chuoi[1];
	  					//System.out.println("chuoi1: "+chuoi1);
	  					//System.out.println("chuoi2: "+chuoi2);
		  					// đếm số ký tự trong phần mô tả bài hát
	  					//StringTokenizer stringTokenizer = new StringTokenizer(description);
	  					//int soTuTrongChuoi = stringTokenizer.countTokens();
	  					// mapping url
	  					//detail?sid=2
	  					String urlSlug = request.getContextPath()+"/chi-tiet/"+ StringUtil.makeSlug(song.getName()) + "-" + song.getId()+".html";
	  					%>
	  						<li><a href="<%=urlSlug%>"><%=name %></a><br />
			     				<%
			     					out.print(description);
			     				%>
			     			</li>
	  					<%
	  				}
	  			%>
			</ul>
  		<%
  	}
  %>
</div>