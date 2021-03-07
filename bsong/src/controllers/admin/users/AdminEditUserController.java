package controllers.admin.users;

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
import daos.CatUserDao;
import daos.UserDao;
import models.CatUser;
import models.Category;
import models.User;
import util.StringUtil;

public class AdminEditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		CatUserDao catUserDao = new CatUserDao();
		List<CatUser> catUser = catUserDao.findAll();
		request.setAttribute("catUser", catUser);
		UserDao userDao = new UserDao();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("uid"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		User user = userDao.viewsEdit(id);
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/edit.jsp");
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
		
		CatUserDao catUserDao = new CatUserDao();
		List<CatUser> catUser = catUserDao.findAll();
		request.setAttribute("catUser", catUser);
		//handle
		UserDao userDao = new UserDao();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		// lấy lại dữ liệu cũ
		User user = userDao.viewsEdit(id);
		String password = request.getParameter("pass");
		
		if("".equals(password)) {
			password = user.getPassword();
		}else {
			password = StringUtil.md5(password);
		}
		String fullname = request.getParameter("fullname");
		int categoriesuser = 0;
		try {
			categoriesuser = Integer.parseInt(request.getParameter("categoriesuser"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		User userEdit = new User(id, password, fullname, new CatUser(categoriesuser));
		int edit = userDao.edit(userEdit);
		if(edit > 0) {
			// Sửa thành công
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg=OK");
			return;
		}
		//that bai
		request.setAttribute("user", user);
		// check validate
		if("".equals(fullname)) {
			request.setAttribute("err", "Vui lòng điền đầy đủ thông tin");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/edit.jsp");
			rd.forward(request, response);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/edit.jsp");
		rd.forward(request, response);
	}
}
