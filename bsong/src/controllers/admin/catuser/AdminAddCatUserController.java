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
import models.User;

public class AdminAddCatUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddCatUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/catuser/add.jsp");
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
		CatUserDao catUserDao = new CatUserDao();
		//get data
		String name = request.getParameter("name");
		CatUser userCatInfor = catUserDao.findUsername(name);
		if(userCatInfor != null) {
			request.setAttribute("err", "Loại người dùng "+name+" đã tồn tại. Vui lòng nhập tên khác");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/catuser/add.jsp");
			rd.forward(request, response);
			return;
		}
		//set data
		request.setAttribute("name", name);
		//check validate
		if("".equals(name)) {
			request.setAttribute("err", "Tên loại tài khoản không được bỏ trống");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/catuser/add.jsp");
			rd.forward(request, response);
			return;
		}else if(name.length() < 3){
			request.setAttribute("err", "Tên quá ngắn. vui lòng nhập lại");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/catuser/add.jsp");
			rd.forward(request, response);
			return;
		}
		CatUser catUser = new CatUser(name);
		int add = catUserDao.add(catUser);
		if(add > 0) {
			// thêm thành công
			response.sendRedirect(request.getContextPath()+"/admin/catuser/index?msg=OK");
			return;
		}
		//that bai
		request.setAttribute("catUser", catUser);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/catuser/add.jsp");
		rd.forward(request, response);
	}

}
