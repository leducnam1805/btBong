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
import models.Songs;
import util.DefineUtil;

public class AdminIndexCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexCatController() {
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
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int numberOfItems = catDao.getCount();
		int numberOfPage = (int) Math.ceil((float)numberOfItems / DefineUtil.NUMBER_PER_PAGE_ADMIN);
		if(currentPage > numberOfPage || currentPage < 1) {
			currentPage = 1;
		}
		int offsetAdmin = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE_ADMIN;
		List<Category> catList = catDao.findAllAdmin(offsetAdmin);
		
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("catList", catList);
		//search
		if(request.getParameter("nameCat")!= null) {
			String nameCat = request.getParameter("nameCat");
			request.setAttribute("nameCat", nameCat);
			List<Category> searchList = catDao.search(nameCat);
			request.setAttribute("catList", searchList);
		}
		//search
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/cat/index.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
