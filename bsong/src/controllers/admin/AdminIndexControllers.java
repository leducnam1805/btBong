package controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.CatDao;
import daos.SongDao;
import daos.UserDao;

public class AdminIndexControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexControllers() {
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
		SongDao songDao = new SongDao();
		UserDao userDao = new UserDao();
		
		int countCat = catDao.getCountCat();
		if(countCat > 0) {
			request.setAttribute("countCat", countCat);
		}
		
		int countSong = songDao.getCountSong();
		if(countSong > 0) {
			request.setAttribute("countSong", countSong);
		}
		
		int countUser = userDao.getcountUser();
		if(countUser > 0) {
			request.setAttribute("countUser", countUser);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
