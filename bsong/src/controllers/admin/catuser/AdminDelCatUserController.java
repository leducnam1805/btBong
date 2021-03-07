package controllers.admin.catuser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.CatDao;
import daos.CatUserDao;
import models.CatUser;
import models.Category;

public class AdminDelCatUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDelCatUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		//handle
		CatUserDao catUserDao = new CatUserDao();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}

		CatUser catUser = new CatUser(id);
		int del = catUserDao.del(id);
		if (del > 0) {
			// xóa thành công
			response.sendRedirect(request.getContextPath() + "/admin/catuser/index?msg=OK");
			return;
		} // that bai
		response.sendRedirect(request.getContextPath() + "/admin/catuser/index?msg=err");
		return;
				 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
