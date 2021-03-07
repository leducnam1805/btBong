package controllers.publics;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.SongDao;
import models.Songs;
import util.CategoryUtil;
import util.DefineUtil;

public class PublicsIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicsIndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println(request.getServletContext().getRealPath(""));
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		CategoryUtil.getCat(request, response);
		CategoryUtil.getsong(request, response);

		SongDao songDao = new SongDao();

		// search
		if (request.getParameter("editbox_search") != null) {
			String editbox_search = request.getParameter("editbox_search");
			request.setAttribute("editbox_search", editbox_search);
			int searchCurrentPage = 1;
			try {
				searchCurrentPage = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
				searchCurrentPage = 1;
			}
			int searchNumberOfItems = songDao.getCountSearch(editbox_search);
			int searchNumberOfPage = (int) Math.ceil((float) searchNumberOfItems / DefineUtil.NUMBER_PER_PAGE_INDEX);
			if (searchCurrentPage > searchNumberOfPage || searchCurrentPage < 1) {
				searchCurrentPage = 1;
			}
			int searchOffset = (searchCurrentPage - 1) * DefineUtil.NUMBER_PER_PAGE_INDEX;

			List<Songs> searchList = songDao.searchPage(editbox_search, searchOffset);

			request.setAttribute("numberOfPage", searchNumberOfPage);
			request.setAttribute("currentPage", searchCurrentPage);
			request.setAttribute("songList", searchList);
		} else {
			int currentPage = 1;
			try {
				currentPage = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
				currentPage = 1;
			}
			int numberOfItems = songDao.getCount();
			int numberOfPage = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE_INDEX);
			if (currentPage > numberOfPage || currentPage < 1) {
				currentPage = 1;
			}
			int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE_INDEX;
			List<Songs> songList = songDao.findAll(offset);
			request.setAttribute("numberOfPage", numberOfPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("songList", songList);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
