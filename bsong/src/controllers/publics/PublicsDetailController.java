package controllers.publics;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.SongDao;
import models.Songs;
import util.CategoryUtil;

public class PublicsDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicsDetailController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		SongDao songDao = new SongDao();
		
		CategoryUtil.getCat(request, response);
		CategoryUtil.getsong(request, response);
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("sid"));
		} catch (NumberFormatException e) {
			
		}
		int countID = 0;
		try {
			countID = songDao.countId(id);
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		
		Songs songList = songDao.viewsAll(id);
		List<Songs> relatedSong = songDao.relateSong(songList);
		
		request.setAttribute("songList", songList);
		request.setAttribute("relatedSong", relatedSong);
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
