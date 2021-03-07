package controllers.admin.contact;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.ContactDao;
import models.Contact;

public class AdminDelContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDelContactController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		ContactDao contactDao = new ContactDao();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("ctid"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		Contact contact = new Contact(id);
		int del = contactDao.del(id);
		if(del > 0) {
			// xóa thành công
			response.sendRedirect(request.getContextPath()+"/admin/contact/index?msg=OK");
			return;
		}
		//that bai
		response.sendRedirect(request.getContextPath()+"/admin/contact/index?msg=err");
		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
