package controllers.publics;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ContactDao;
import models.Contact;
import util.CategoryUtil;

public class PublicsContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicsContactController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		CategoryUtil.getCat(request, response);
		CategoryUtil.getsong(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/contact.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		CategoryUtil.getCat(request, response);
		CategoryUtil.getsong(request, response);
		ContactDao contactDao = new ContactDao();
		//get data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		String message = request.getParameter("message");
		//set data
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		request.setAttribute("message", message);
		//check validate
		if("".equals(name)){
			checkValue(name, "Vui lòng nhập họ tên", request, response);
			return;
		}
		
		if("".equals(email)){
			checkValue(email, "Email không đúng định dạng. vui lòng nhập lại Email", request, response);
			return;
		}
		
		if("".equals(message)){
			checkValue(message,"Bạn muốn gửi thông điệp gì ??", request, response);
			return;
		}else if(message.length() < 3) {
			checkValue(message,"Thông điệp của bạn quá ngắn ??", request, response);
			return;
		}
		Contact contact = new Contact(name,email,website,message);
		int add = contactDao.add(contact);
		if(add > 0 ) {
			response.sendRedirect(request.getContextPath()+"/lien-he/thong-bao-OK.html");
			request.setAttribute("successMessage", contact);
			return;
		}
		request.setAttribute("contact", contact);
//		RequestDispatcher rd = request.getRequestDispatcher("/views/public/contact.jsp");
//		rd.forward(request, response);
	}
	
	protected void checkValue(String value, String msg, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("".equals(value)) {
			request.setAttribute("err", msg);
			RequestDispatcher rd = request.getRequestDispatcher("/views/public/contact.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
