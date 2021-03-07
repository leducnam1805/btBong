package controllers.admin.contact;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.ContactDao;
import models.Category;
import models.Contact;
import util.DefineUtil;

public class AdminIndexContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexContactController() {
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
		
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int numberOfItems = contactDao.getCount();
		int numberOfPage = (int) Math.ceil((float)numberOfItems / DefineUtil.NUMBER_PER_PAGE_ADMIN);
		if(currentPage > numberOfPage || currentPage < 1) {
			currentPage = 1;
		}
		int offsetAdmin = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE_ADMIN;
		
		List<Contact> list = contactDao.findAllAdmin(offsetAdmin);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("listContact", list);
		//search
		if(request.getParameter("nameContact")!= null) {
			String nameContact = request.getParameter("nameContact");
			request.setAttribute("nameContact", nameContact);
			List<Contact> searchList = contactDao.search(nameContact);
			request.setAttribute("listContact", searchList);
		}
		//search
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/contact/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
