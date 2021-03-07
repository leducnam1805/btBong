package util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.CatDao;
import daos.SongDao;
import models.Category;
import models.Songs;

public class CategoryUtil {
	public static void getCat(HttpServletRequest request, HttpServletResponse response) throws IOException{
		CatDao catDao = new CatDao();
		List<Category> catList = catDao.findAll();
		request.setAttribute("catList", catList);
	}
	public static void getsong(HttpServletRequest request, HttpServletResponse response) throws IOException{
		SongDao songDao = new SongDao();
		List<Songs> songListFL = songDao.findLatest();
		request.setAttribute("songListFL", songListFL);
	}
}
