package controllers.admin.catuser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.CatUserDao;
import models.CatUser;
import models.Category;

public class AdminEditCatUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditCatUserController() {
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
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("cuid"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		CatUser catUser = catUserDao.viewsEedit(id);
		request.setAttribute("catUser", catUser);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/catuser/edit.jsp");
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
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		String name = request.getParameter("name");
		CatUser checkEdit = catUserDao.checkEdit(id,name);
		if(checkEdit != null) {
			CatUser catUser = new CatUser(id,name);
			request.setAttribute("catUser", catUser);
			request.setAttribute("err", "Loại tài khoản "+name+" đã có. Vui lòng nhập tên khác");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/catuser/edit.jsp");
			rd.forward(request, response);
			return;
		}else {
			CatUser catUser = new CatUser(id,name);
			request.setAttribute("catUser", catUser);
			
			//check value
			if("".equals(name)) {
				request.setAttribute("err", "Vui lòng nhập loại người dùng");
				RequestDispatcher rd = request.getRequestDispatcher("/views/admin/catuser/edit.jsp");
				rd.forward(request, response);
				return;
			}else if(name.length() < 3) {
				request.setAttribute("err", "Vui lòng nhập tên khác dài hơn");
				RequestDispatcher rd = request.getRequestDispatcher("/views/admin/catuser/edit.jsp");
				rd.forward(request, response);
				return;
			}
			int edit = catUserDao.edit(catUser);
			if(edit > 0) {
				// Sửa thành công
				response.sendRedirect(request.getContextPath()+"/admin/catuser/index?msg=OK");
				return;
			}
		}
		//that bai
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/catuser/edit.jsp");
		rd.forward(request, response);
	}

}
