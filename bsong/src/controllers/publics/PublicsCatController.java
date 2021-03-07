package controllers.publics;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.GlobalConstants;
import daos.CatDao;
import daos.SongDao;
import models.Category;
import models.Songs;
import util.CategoryUtil;
import util.DefineUtil;

public class PublicsCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicsCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SongDao songDao = new SongDao();
		CategoryUtil.getCat(request, response);
		CategoryUtil.getsong(request, response);
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("cid"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int numberOfItems = songDao.numberOfItems(id);
		int numberOfPage = (int)Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE);
		if(currentPage > numberOfPage || currentPage < 1) {
			currentPage  = 1;
		}
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		List<Songs> songList = songDao.viewIdCatPagination(offset,id);
		
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("songList", songList);
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/cat.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
