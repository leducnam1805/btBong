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

public class AdminAddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/cat/add.jsp");
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
		//get data
		String name = request.getParameter("name");
		//set data
		request.setAttribute("name", name);
		//check validate
		if("".equals(name)) {
			request.setAttribute("err", "Tên danh mục không được bỏ trống");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/cat/add.jsp");
			rd.forward(request, response);
			return;
		}else if(name.length() < 3){
			request.setAttribute("err", "Tên danh mục quá ngắn. vui lòng nhập lại");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/cat/add.jsp");
			rd.forward(request, response);
			return;
		}
		Category cat = new Category(name);
		int add = catDao.add(cat);
		if(add > 0) {
			// thêm thành công
			response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg=OK");
			return;
		}
		//that bai
		request.setAttribute("cat", cat);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/cat/add.jsp");
		rd.forward(request, response);
	}
}
