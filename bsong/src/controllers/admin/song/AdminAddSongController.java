package controllers.admin.song;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import daos.CatDao;
import daos.SongDao;
import models.Category;
import models.Songs;
import util.CategoryUtil;
import util.FileUtil;

@MultipartConfig
public class AdminAddSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddSongController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		CatDao catDao = new CatDao();
		List<Category> catList = catDao.findAll();
		request.setAttribute("catList", catList);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/song/add.jsp");
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
		
		CatDao catDao = new CatDao();
		List<Category> catList = catDao.findAll();
		request.setAttribute("catList", catList);
		
		SongDao songDao = new SongDao();
		//get data
		String name = request.getParameter("name");
		String des = request.getParameter("preview");
		String detail = request.getParameter("detail");
		int idCat = 0;
		try {
			idCat = Integer.parseInt(request.getParameter("category"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/error/err404.jsp");
			rd.forward(request, response);
			return;
		}
		//upload file
		String fileName = FileUtil.upload("picture", request);
		//set data
		request.setAttribute("name", name);
		request.setAttribute("des", des);
		request.setAttribute("detail", detail);
		request.setAttribute("idCat", idCat);
		//check validate
		if("".equals(name)) {
			checkValue(name, "Vui lòng nhập tên bài hát", request, response);
			return;
		}
		if("".equals(des)) {
			checkValue(des, "Vui lòng nhập mô tả cho bài hát", request, response);
			return;
		}
		
		if("".equals(detail)) {
			checkValue(detail, "Vui lòng nhập chi tiết bài hát", request, response);
			return;
		}
		
		//insert data
		Songs song = new Songs(name, des, detail, fileName, new Category(idCat));
		int add = songDao.add(song);
		if(add > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/song/index?msg=OK");
			return;
		}
		request.setAttribute("song", song);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/song/add.jsp");
		rd.forward(request, response);
	}
	protected void checkValue(String value, String msg, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("".equals(value)) {
			request.setAttribute("err", msg);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/song/add.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
