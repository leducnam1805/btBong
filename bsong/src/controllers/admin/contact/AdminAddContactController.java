package controllers.admin.contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.CatDao;
import daos.ContactDao;
import models.Category;
import models.Contact;

public class AdminAddContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddContactController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/contact/add.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//handle
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
		Contact contact = new Contact(name, website, message, email);
		int add = contactDao.add(contact);
		if(add > 0) {
			// thêm thành công
			response.sendRedirect(request.getContextPath()+"/admin/contact/index?msg=OK");
			return;
		}
		//that bai
		request.setAttribute("contact", contact);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/contact/add.jsp");
		rd.forward(request, response);
	}
	protected void checkValue(String value, String msg, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("".equals(value)) {
			request.setAttribute("err", msg);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/contact/add.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
