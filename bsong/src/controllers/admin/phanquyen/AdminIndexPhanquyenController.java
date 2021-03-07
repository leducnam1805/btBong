package controllers.admin.phanquyen;

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
import models.CatUser;
import models.User;

public class AdminIndexPhanquyenController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexPhanquyenController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}else {
			User user = (User)session.getAttribute("userInfor");
			if(user.getCatUser().getId() < 2) {
				CatUserDao phanQuyenDao = new CatUserDao();
				List<CatUser> phanQuyenList = phanQuyenDao.findAllQuyen();
				if(phanQuyenList != null) {
					request.setAttribute("phanQuyenList", phanQuyenList);
				}
				RequestDispatcher rd = request.getRequestDispatcher("/views/admin/phanquyen/index.jsp");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/views/error/err403.jsp");
				rd.forward(request, response);
				return;
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
