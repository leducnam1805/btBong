<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<div class="content_resize">
  <div class="mainbar">
    <div class="article">
      <h2 class="lienhe"><span>Liên hệ</span></h2>
      <div class="clr"></div>
      <p>Khi bạn có thắc mắc, vui lòng gửi liên hệ, chúng tôi sẽ phản hồi trong thời gian sớm nhất.</p>
    </div>
    <div class="article">
      <h2>Gửi liên hệ đến chúng tôi</h2>
      <div class="clr"></div>
      <%
      	if(request.getAttribute("err")!= null){
      		%>
      			<div class="alert alert-danger" role="alert">
				  <p style="color:red; font-size:20px;">${err}</p>
				</div>
      		<%
      	}
      %>
      	<%
			if(!"".equals(request.getParameter("msg"))){
				String msg = request.getParameter("msg");
				if("OK".equals(msg)){
					%>
						<div class="alert alert-success" role="alert" style="background-color:yellow;padding:10px;width:460px;color:green;font-size:16px;font-weight:bold">
							 Cảm ơn bạn đã phản hồi.! Chúc bạn có một ngày thật vui vẻ
						</div>
					<%
				}
			}
		%>
      <form action="<%=request.getContextPath()%>/contact" method="post" id="sendemail">
        <ol>
          <li>
            <label for="name">Họ tên (required)</label>
            <input id="name" value="${name}" name="name" class="text"/>
          </li>
          <li>
            <label for="email">Email (required)</label>
            <input id="email" value="${email}" name="email" class="text"/>
          </li>
          <li>
            <label for="website">Website</label>
            <input id="website" value="" name="website" class="text" />
          </li>
          <li>
            <label for="message">Nội dung</label>
            <textarea id="message" name="message" rows="8" cols="50">${message}</textarea>
          </li>
          <li>
            <input type="image" name="imageField" id="imageField" src="<%=request.getContextPath()%>/templates/public/images/submit.gif" class="send" />
            <div class="clr"></div>
          </li>
        </ol>
      </form>
    </div>
  </div>
<script type="text/javascript">
$().ready(function() {
	$("#sendemail").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			"name": {
				required: true,
				minlength: 3
			},
			"email": {
				required: true,
				email: true
			},
			"message": {
				required: true
			}
		},
		messages: {
			"name": {
				required: "<p style='color:red'>Bắt buộc nhập họ tên</p>",
				minlength: "<p style='color:red'>Hãy nhập ít nhất 3 ký tự</p>"
			},
			"email": {
				email: "<p style='color:red'>Vui lòng nhập đúng định dạng email</p>"
			},
			"message": {
				required: "<p style='color:red'>Nội dung không được bỏ trống</p>",
			}
		}
	});
});
</script>
 	
  <div class="sidebar">
  <%@ include file="/templates/public/inc/leftbar.jsp" %>
  </div>
  <div class="clr"></div>
</div>
<%@ include file="/templates/public/inc/footer.jsp" %>
