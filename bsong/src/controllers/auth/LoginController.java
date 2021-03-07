package controllers.auth;

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

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/auth/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userDao = new UserDao();
		//thông tin đăng nhập
		String username = request.getParameter("username");
		String pass = StringUtil.md5(request.getParameter("pass"));
		//Kiểm tra thông tin đăng nhập
		User userInfor = userDao.findUsernameANDPass(username, pass);
		if(userInfor != null) {
			//đăng nhập đúng
			//Lưu thông tin đăng nhập(session)
			User user = userDao.viewAll(username);
			if(user != null) {
				 HttpSession session = request.getSession(); 
				 session.setAttribute("userInfor",user);
				//Chuyển hướng đến trang index admin
				 response.sendRedirect(request.getContextPath()+"/admin");
			}
		}else {
			// đăng nhập sai
			response.sendRedirect(request.getContextPath()+"/auth/login?msg=ERROR");
			return;
		}
	}
}
