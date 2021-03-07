package controllers.admin.song;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constants.GlobalConstants;
import daos.SongDao;
import models.Songs;
import util.FileUtil;

public class AdminDelSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDelSongController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		SongDao songDao = new SongDao();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("sid"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		//kiểm tra tin nếu có file thì xóa
		Songs song = songDao.viewsEdit(id);
		String picture = song.getPicture();
		FileUtil.delFile(picture, request);
		// xóa tin ở data
		int del = songDao.del(id);
		if(del > 0) {
			// xóa thành công
			response.sendRedirect(request.getContextPath()+"/admin/song/index?msg=OK");
			return;
		}
		//that bai
		response.sendRedirect(request.getContextPath()+"/admin/song/index?msg=err");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
