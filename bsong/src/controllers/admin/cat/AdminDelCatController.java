package controllers.admin.cat;

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
import models.Category;

public class AdminDelCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDelCatController() {
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
		CatDao catDao = new CatDao();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("cid"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		Category cat = new Category(id);
		int del = catDao.del(id);
		if(del > 0) {
			// xóa thành công
			response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg=OK");
			return;
		}
		//that bai
		response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg=err");
		return;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
