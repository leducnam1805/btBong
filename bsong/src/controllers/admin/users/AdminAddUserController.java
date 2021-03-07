package controllers.admin.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.CatUserDao;
import daos.UserDao;
import models.CatUser;
import models.User;
import util.StringUtil;

public class AdminAddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddUserController() {
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
		List<CatUser> catUserList = catUserDao.findAll();
		request.setAttribute("catUserList", catUserList);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/add.jsp");
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
		List<CatUser> catUserList = catUserDao.findAll();
		
		//handle1
		UserDao userDao = new UserDao();
		//get data
		String username = request.getParameter("username");
		User userInfor = userDao.findUsername(username);
		if(userInfor != null) {
			request.setAttribute("err", "Tên tài khoản "+username+" đã tồn tại. Vui lòng nhập tên khác");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/add.jsp");
			rd.forward(request, response);
			return;
		}
		String pass = request.getParameter("pass");
		String password = StringUtil.md5(pass);
		String fullname = request.getParameter("fullname");
		int categoriesuser = 0;
		try {
			categoriesuser = Integer.parseInt(request.getParameter("categoriesuser"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		//set data
		request.setAttribute("username", username);
		request.setAttribute("fullname", fullname);
		request.setAttribute("catUserList", catUserList);
//		// check validate
		if("".equals(pass) || "".equals(username) || "".equals(fullname)) {
			request.setAttribute("err", "Vui lòng điền đầy đủ thông tin");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/add.jsp");
			rd.forward(request, response);
			return;
		}else if(pass.length() < 6) {
			request.setAttribute("err", "Vui lòng nhập mật khẩu dài hơn để tăng độ bảo mật.");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/add.jsp");
			rd.forward(request, response);
			return;
		}
		System.out.println("categoriesuser: "+categoriesuser);
		User user = new User(username, password, fullname, new CatUser(categoriesuser));
		int add = userDao.add(user);
		if(add > 0) {
			// thêm thành công
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg=OK");
			return;
		}
		//that bai
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/add.jsp");
		rd.forward(request, response);
		
	}

}
