package controllers.admin.phanquyen;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CatUserDao;
import models.CatUser;

public class AdminAddQuyenController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddQuyenController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		CatUserDao catUserDao = new CatUserDao();
		int cuid = 0;
		try {
			cuid = Integer.parseInt(request.getParameter("cuid"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		Boolean addquyen = Boolean.parseBoolean(request.getParameter("giatri"));
		
		CatUser catUser = new CatUser(cuid, addquyen, true, true);
		int add = catUserDao.addquyen(catUser);
		if(add > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/user/phanquyen?msg=OK");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/phanquyen/index.jsp");
		rd.forward(request, response);
	}

}
