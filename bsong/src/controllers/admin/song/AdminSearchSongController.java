package controllers.admin.song;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.SongDao;
import models.Category;
import models.Songs;
import util.CategoryUtil;
import util.DefineUtil;

public class AdminSearchSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminSearchSongController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		CategoryUtil.getCat(request, response);

		SongDao songDao = new SongDao();
		// tạo biến
		int searchloc = 0;
		// get data
		// lọc
		try {
			searchloc = Integer.parseInt(request.getParameter("searchloc"));
		} catch (NumberFormatException e) {
			searchloc = 0;
		}
		// input
		String namesong = request.getParameter("searchInput");
		
		// handle
		if(searchloc > 0 && !"".equals(namesong)) {
			Songs song = new Songs(namesong, new Category(searchloc));
			List<Songs> searchLocInput = songDao.searchLocInput(song);
			request.setAttribute("song", song);
			request.setAttribute("songList", searchLocInput);
		}else if (searchloc > 0) {
			List<Songs> searchCatSong = songDao.searchCatSong(searchloc);
			request.setAttribute("searchloc", searchloc);
			request.setAttribute("songList", searchCatSong);
		} else if (namesong != null || !"".equals(namesong)) {
			List<Songs> searchInput = songDao.search(namesong);
			request.setAttribute("namesong", namesong);
			request.setAttribute("songList", searchInput);
		}
		// phân trang ảo
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int numberOfItems = songDao.getCount();
		int numberOfPage = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE_ADMIN);
		if (currentPage > numberOfPage || currentPage < 1) {
			currentPage = 1;
		}
		int offsetAdmin = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE_ADMIN;

		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("currentPage", currentPage);

		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/song/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
