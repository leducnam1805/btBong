package controllers.admin.song;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import daos.SongDao;
import models.Category;
import models.Songs;
import util.CategoryUtil;
import util.FileUtil;

@MultipartConfig
public class AdminEditSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditSongController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SongDao songDao = new SongDao();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("ctid"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		Songs item = songDao.viewsEdit(id);
		
		request.setAttribute("song", item);
		CategoryUtil.getCat(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/song/edit.jsp");
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
		
		SongDao songDao = new SongDao();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("sid"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		String name = request.getParameter("name");
		int idCat = 0;
		try {
			idCat = Integer.parseInt(request.getParameter("category"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		String preview = request.getParameter("preview");
		String detail = request.getParameter("detail");
		String fileName = FileUtil.upload("picture", request);
		
		// nếu không có ảnh thì lấy lại ảnh cũ
		if("".equals(fileName)) {
			Songs item = songDao.viewsEdit(id);
			fileName = item.getPicture();
		}
		Songs song = new Songs(id,name,preview,detail,fileName,new Category(idCat));
		int edit = songDao.edit(song);
		if(edit > 0) {
			//kiểm tra tin nếu có file thì xóa file cũ đi
//			Songs songFile = songDao.viewsEdit(id);
//			String picture = songFile.getPicture();
//			FileUtil.delFile(picture, request);
			response.sendRedirect(request.getContextPath()+"/admin/song/index?msg=OK");
			return;
		}
		request.setAttribute("song", song);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/song/edit.jsp");
		rd.forward(request, response);
	}
	
	protected void checkValue(String value, String msg, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("".equals(value)) {
			request.setAttribute("err", msg);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/song/edit.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
