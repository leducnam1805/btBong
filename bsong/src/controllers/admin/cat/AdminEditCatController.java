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

public class AdminEditCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		CatDao catDao = new CatDao();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("cid"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		Category cat = catDao.edit(id);
		request.setAttribute("cat", cat);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/cat/edit.jsp");
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
		CatDao catDao = new CatDao();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		//get data
		String name = request.getParameter("name");
		Category cat = new Category(id, name);
		request.setAttribute("cat", cat);
		//check value
		if("".equals(name)) {
			request.setAttribute("err", "Vui lòng nhập tên danh mục");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/cat/edit.jsp");
			rd.forward(request, response);
			return;
		}else if(name.length() < 3) {
			request.setAttribute("err", "Vui lòng nhập tên khác dài hơn");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/cat/edit.jsp");
			rd.forward(request, response);
			return;
		}
		int edit = catDao.edit(cat);
		if(edit > 0) {
			// Sửa thành công
			response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg=OK");
			return;
		}
		//that bai
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/cat/edit.jsp");
		rd.forward(request, response);
	}
}
