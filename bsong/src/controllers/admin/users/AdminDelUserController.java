package controllers.admin.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.UserDao;
import models.Category;
import models.User;

public class AdminDelUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDelUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		UserDao userDao = new UserDao();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("uid"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		User user = new User(id);
		int del = userDao.del(id);
		if(del > 0) {
			// xóa thành công
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg=OK");
			return;
		}
		//that bai
		response.sendRedirect(request.getContextPath()+"/admin/user/index?msg=err");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
