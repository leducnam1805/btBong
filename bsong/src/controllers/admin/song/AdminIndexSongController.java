package controllers.admin.song;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.SongDao;
import models.Songs;
import util.CategoryUtil;
import util.DefineUtil;

public class AdminIndexSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexSongController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		CategoryUtil.getCat(request, response);
		
		SongDao songDao = new SongDao();
		
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int numberOfItems = songDao.getCount();
		int numberOfPage = (int) Math.ceil((float)numberOfItems / DefineUtil.NUMBER_PER_PAGE_ADMIN);
		if(currentPage > numberOfPage || currentPage < 1) {
			currentPage = 1;
		}
		int offsetAdmin = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE_ADMIN;
		
		List<Songs> songList = songDao.findAllAdmin(offsetAdmin);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("songList", songList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/song/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
